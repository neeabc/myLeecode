package no0113;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> line = new LinkedList<>();
        int check = 0;
        
        helper(res,line,sum,check,root);
        return res;
    }
    
    public void helper(List<List<Integer>> res,LinkedList<Integer> line,int sum,int check,TreeNode root) {
    	if(root==null)return;
    	
    	check += root.val;
    	line.addLast(root.val);
    	
    	if(root.left!=null) {

    		helper(res, line, sum, check, root.left);
    		line.removeLast();
    	}
    	
    	if(root.right!=null) {
    		
    		helper(res, line, sum, check, root.right);
    		line.removeLast();
    	}

    	if(root.left==null&&root.right==null) {
            if(sum==check) {
    		    res.add(new LinkedList<>(line));
    	    }
    		return;
    	}
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}