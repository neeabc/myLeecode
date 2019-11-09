package no0665;
/**
给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。

示例 1:

输入: [4,2,3]
输出: True
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:

输入: [4,2,1]
输出: False
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
说明:  n 的范围为 [1, 10,000]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-decreasing-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        
    	int[] temp = new int[] {Integer.MIN_VALUE,0,0,Integer.MAX_VALUE};
    	int count = 0;
    	for(int i=0;i<nums.length-1;i++) {
    		if(nums[i]>nums[i+1]) {
    			//给temp赋值
    			for(int j=i-1,k=0;j<i+3;j++,k++) {
    				if(j>=0&&j<nums.length) {
    					temp[k]=nums[j];
    				}
    			}
    			
    			//判断temp是否可修复可修复
    			if((temp[1]>=temp[0]&&temp[1]<=temp[3])||(temp[2]>=temp[0]&&temp[2]<=temp[3])) {
    				//可修复,修复次数加一,判断修复次数是否大于1
    				if(count==1) {
    					return false;
    				}
    				count++;
    			}else {
    				//不可修复,返回false
    				return false;
    			}
    			//temp复位
    			temp = new int[] {Integer.MIN_VALUE,0,0,Integer.MAX_VALUE};
    		}
    	}
    	
    	return true;
    	
    }
}
