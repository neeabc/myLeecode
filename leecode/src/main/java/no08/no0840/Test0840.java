package no08.no0840;


import org.junit.Test;

public class Test0840 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[][] grid = {{4,3,8,4},
		                {9,5,1,9},
		                {2,7,6,2}};
		
		so.numMagicSquaresInside(grid);
	}
}
