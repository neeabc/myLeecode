package no0047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	LinkedList<Integer> line = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] tip = new boolean[nums.length];
        int count=0;
        
        helper(res,tip,line,nums,count);
        return res;
    }
    
    public void helper(List<List<Integer>> res,boolean[] tip,LinkedList<Integer> line,int[] nums,int count) {
    	//结束条件
    	if(count==nums.length) {
    		res.add(new LinkedList<>(line));
    		return;
    	}
    	
    	for(int i=0;i<tip.length;i++) {
    		if(!tip[i]) { //i点的数没有被使用
    			
    			if(i>0&&nums[i]==nums[i-1]&&!tip[i-1]) {
    				continue;
    			}
    			
    			line.addLast(nums[i]);
    			tip[i]=true;
    			
    			helper(res,tip,line,nums,count+1);
    			
    			line.removeLast();
    			tip[i]=false;
    		}
    	}
    }
}
