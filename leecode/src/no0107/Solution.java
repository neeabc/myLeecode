package no0107;

import java.util.LinkedList;
import java.util.List;
/**
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		
		List<TreeNode> now = new LinkedList<>();
		if(root==null) {
			return res;
		}
		now.add(root);
		List<TreeNode> future = new LinkedList<>();
		
		while(now.size()>0) {
			List<Integer> temp = new LinkedList<>();
			for(TreeNode node:now) {
				
				temp.add(node.val);
				if(node.left!=null) {
					future.add(node.left);
				}
				if(node.right!=null) {
					future.add(node.right);
				}
			}
			
			res.add(0,temp);
			now = future;
			future = new LinkedList<>();
			
		}
    	return res;
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}