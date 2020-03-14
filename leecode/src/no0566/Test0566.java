package no0566;


import org.junit.Test;

public class Test0566 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		int[][] nums = {{1,2},{3,4},{5,6}};
		int r = 2;
		int c = 3;
		so.matrixReshape(nums, r, c);
	}
}
