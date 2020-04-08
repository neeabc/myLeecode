package no02.no0216;

import java.util.LinkedList;
import java.util.List;

/**
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public LinkedList<List<Integer>> res = new LinkedList<>();
	public List<List<Integer>> combinationSum3(int k, int n) { //k 选择数字的个数	n 每组数字的和
        helper(new int[10],1,k,n);
		return res;
    }
    
    public void helper(int[] count,int len,int k,int n) {
    	if(len==10||k==0||n==0) { //结束条件
    		if(k==0&&n==0) {
    			res.addLast(transformer(count,len));
    		}
    		return;
    	}
    	
    	//不选择此数字
    	count[len]=0;
    	helper(count, len+1, k, n);
    	
    	//选择此数字
    	count[len]=1;
    	helper(count, len+1, k-1, n-len);
    	
    }
    
    public List<Integer> transformer(int[] count,int len){
    	LinkedList<Integer> res = new LinkedList<>();
    	for(int i=1;i<len;i++) {
    		if(count[i]==1) {
    			res.addLast(i);
    		}
    	}
		return res;
    }
    
}
