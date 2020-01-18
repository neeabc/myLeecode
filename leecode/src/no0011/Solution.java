package no0011;
/**
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int maxArea01(int[] height) {
    	
    	int[] base = new int[height.length];
    	
        for(int i=1;i<height.length;i++) {
        	int max = Integer.MIN_VALUE;
        	for(int m=0,n=i;n<height.length;m++,n++) {
        		max = Math.max(max, Math.min(height[m], height[n]));
        	}
        	base[i]=max;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=1;i<base.length;i++) {
        	
        	max = Math.max(max, i*base[i]);
        	
        }
        
        return max;
    }
    
    public int maxArea(int[] height) {
    	int s = 0;
    	int e = height.length-1;
    	
    	int max = 0;
    	
    	while(s<e) {
    		
    		int temp = Math.min(height[s], height[e])*(e-s);
    		max = Math.max(max, temp);
    		
    		if(height[s]>height[e]) {
    			e--;
    		}else {
    			s++;
    		}
    	}
    	
    	return max;
    }
}
