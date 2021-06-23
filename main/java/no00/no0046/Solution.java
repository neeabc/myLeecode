package no00.no0046;

import java.util.ArrayList;
import java.util.List;

/**
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	//准备需要的变量
    	int all = 1;
    	for(int i=nums.length;i>1;i--) {
    		all *= i;
    	}
    	List<List<Integer>> result = new ArrayList<>(all);
    	List<Integer> temp;
    	
    	//将第一个数先输入至 result
    	if(nums.length>0) {
    		temp = new ArrayList<>(nums.length);
    		temp.add(0, nums[0]);
    		result.add(0, temp);
    	}
    	int x = 0;
    	int y = 0;
    	
    	//循环遍历 nums
    	for(int i =1;i<nums.length;i++) {
    		//补充
    		for(int j=0;j<=y;j++) {
    			temp = result.get(j);
    			temp.add(x+1,nums[i]);
    		}
    		
    		//复制
    		for(int j = 0;j<(x+1)*(y+1);j++) {
    			//复制一行
    			temp = result.get(j);
    			List<Integer> newTemp = new ArrayList<>();
    			for(int k=0;k<temp.size();k++) {
    				newTemp.add(k,temp.get(k));
    			}
    			int change = x-(j)/(y+1);
    			
    			int numTemp = newTemp.get(change);
    			newTemp.set(change,newTemp.get(change+1));
    			newTemp.set(change+1,numTemp);
    			
    			result.add(y+1+j, newTemp);
    		}
    		
    		x++;
    		y = result.size()-1;
    		
    	}
    	
		return result;
        
    }
}
