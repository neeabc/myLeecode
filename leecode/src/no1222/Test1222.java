package no1222;

import org.junit.jupiter.api.Test;

public class Test1222 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[][] queens = {
				{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},
				{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},
				{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},
				{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};

		int[] king = {3,4};
		
		so.queensAttacktheKing(queens, king);
	}
}

