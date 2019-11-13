package no0120;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	
    	if(triangle.size()==1) {
    		return triangle.get(0).get(0);
    	}
    	
    	List<Integer> temp = null;
    	Integer tempNum;
    	for(int i=1;i<triangle.size();i++) {

    		temp = triangle.get(i);
    		for(int j=0;j<temp.size();j++) {
    			tempNum = temp.get(j);
    			
    			if(j==0) {
    				temp.set(j, triangle.get(i-1).get(j)+tempNum);
    			}else if(j==temp.size()-1) {
    				temp.set(j, triangle.get(i-1).get(j-1)+tempNum);
    			}else {
    				temp.set(j, Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1))+tempNum);
    			}
    			
    		}
    	}
    	
    	Integer min = temp.get(0);
    	for(int i=1;i<temp.size();i++) {
    		min = Math.min(min, temp.get(i));
    	}
    	
		return min;
        
    }
}
