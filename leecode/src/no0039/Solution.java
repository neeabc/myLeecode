package no0039;

import java.util.LinkedList;
import java.util.List;

/**
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
	public LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,new int[candidates.length],0);
        return res;
    }
    
    public void helper(int[] candidates, int target,int[] counts,int len) {
    	if(len==counts.length) { //终止条件
    		if(target==0) {
    			res.add(transformer(candidates, counts, len));
    		}
    		return;
    	}
    	
    	int num = target/candidates[len];
    	for(int i=0;i<=num;i++) {
    		counts[len]=i;
    		helper(candidates, target-i*candidates[len], counts, len+1);
    	}
    }
    
    public List<Integer> transformer(int[] candidates, int[] counts,int len){
    	LinkedList<Integer> res = new LinkedList<>();
    	
    	for(int i=0;i<len;i++) {
    		for(int j=0;j<counts[i];j++) {
    			res.addLast(candidates[i]);
    		}
    	}
    	
		return res;
    	
    }
}
