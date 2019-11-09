package no0605;

import org.junit.jupiter.api.Test;

public class Test0605 {
	@Test
	public void startTest() {
		Solution solution = new Solution();
		
		int[] flowerbed = new int[] {1,0,0,0,1};
		int n = 1;
		
		solution.canPlaceFlowers(flowerbed, n);
		
	}
}
