package no03.no0329;

import org.junit.Test;

public class Test0329 {
	@Test
	public void test01() {
		Solution so = new Solution();
		
		int[][] matrix = {
			{3,4,5},
			{3,2,6},
			{2,2,1}
		};
		
		int i = so.longestIncreasingPath(matrix);
		System.out.println(i);
	}
}
