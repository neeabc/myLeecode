package no0048;

import org.junit.jupiter.api.Test;

public class Test0048 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[][] matrix = {
				{2,29,20,26,16,28},
				{12,27,9,25,13,21},
				{32,33,32,2,28,14},
				{13,14,32,27,22,26},
				{33,1,20,7,21,7},
				{4,24,1,6,32,34}
		};
		
		so.rotate(matrix);
	}
}
