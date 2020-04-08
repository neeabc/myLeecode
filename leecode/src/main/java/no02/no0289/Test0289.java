package no02.no0289;


import org.junit.Test;

public class Test0289 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[][] board = {
		                  {0,1,0},
		                  {0,0,1},
		                  {1,1,1},
		                  {0,0,0}
		                };
		
		so.gameOfLife(board);
	}
}
