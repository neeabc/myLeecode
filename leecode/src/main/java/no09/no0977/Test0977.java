package no09.no0977;


import org.junit.Test;

public class Test0977 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		int[] A = new int[] {-3,-3,-2,1};
		for(int a:so.sortedSquares(A)) {
			System.out.println(a);
		}
		
	}
}
