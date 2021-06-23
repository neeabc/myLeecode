package no01.no0112;
/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        int check = 0;
        return helper(root,sum,check);
    }
    
    public boolean helper(TreeNode root, int sum,int check) {
        if(root==null)return false;
    	check += root.val;
    	
    	if(root.left==null&&root.right==null) { //结束条件
    		if(check==sum) {
    			return true;
    		}else {
    			return false;
    		}
    	}
    	
    	if(helper(root.left, sum, check)) {
    		return true;
    	}
    	
    	if(helper(root.right, sum, check)) {
    		return true;
    	}
    		
    	return false;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}