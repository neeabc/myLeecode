package no08.no0821;


import org.junit.Test;

public class Test0821 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		String S = "loveleetcode";
		char C = 'e';
		int[] result = so.shortestToChar(S, C);
		for(int r:result) {
			System.out.println(r);
		}
	}
}
