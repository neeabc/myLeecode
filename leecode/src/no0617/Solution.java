package no0617;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	TreeNode left = null;
    	TreeNode right = null;
    	
    	left = mergeTrees(t1.left,t2.left);
    	
    	right = mergeTrees(t1.right,t2.right);
        
    	TreeNode head = new TreeNode(t1.val+t2.val);
    	head.left = left;
    	head.right = right;
    	
    	return head;
    	
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
