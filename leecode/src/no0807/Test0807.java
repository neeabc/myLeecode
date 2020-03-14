package no0807;


import org.junit.Test;

public class Test0807 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[][] grid = new int[][] {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		
		so.maxIncreaseKeepingSkyline(grid);
	}
}
