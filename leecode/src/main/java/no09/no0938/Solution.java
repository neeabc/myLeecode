package no09.no0938;

import java.util.LinkedList;

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
    	
    	LinkedList<TreeNode> s = new LinkedList<>();
    	s.add(root);
    	
    	TreeNode temp;
    	
    	int sum = 0;
    	
    	while(s.isEmpty()!=true) {
    		temp = s.pop();
    		
    		if(temp.val>=L&&temp.val<=R) {
    			sum += temp.val;
    			
    			if(temp.left!=null)s.add(temp.left);
    			if(temp.right!=null)s.add(temp.right);
    			
    		}else if(temp.val<L) {
    			if(temp.right!=null)s.add(temp.right);
    		}else {
    			if(temp.left!=null)s.add(temp.left);
    		}
    		
    	}
    	
    	
		return sum;
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
