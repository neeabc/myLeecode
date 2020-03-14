package no0113;


import org.junit.Test;

public class Test0113 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		TreeNode root = new TreeNode(5);
		
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(8);
		
		TreeNode t3 = new TreeNode(11);
		TreeNode t4 = new TreeNode(13);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(7);
		TreeNode t7 = new TreeNode(2);
		TreeNode t8 = new TreeNode(5);
		TreeNode t9 = new TreeNode(1);
		
		root.left=t1;
		root.right=t2;
		
		t1.left=t3;
		t3.left=t6;
		t3.right=t7;
		
		t2.left=t4;
		t2.right=t5;
		t5.left=t8;
		t5.right=t9;
				
		int sum = 22;
		so.pathSum(root, sum);
		
	}
}
