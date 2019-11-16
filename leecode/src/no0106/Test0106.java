package no0106;

import org.junit.jupiter.api.Test;

public class Test0106 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		
		so.buildTree(inorder, postorder);
	}
}
