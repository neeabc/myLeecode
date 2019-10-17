package no0338;

import org.junit.jupiter.api.Test;

public class Test0338 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		int[] ans = so.countBits(5);
		for(int i = 0;i<5;i++) {
			System.out.println(ans[i]);
		}
	}
}
