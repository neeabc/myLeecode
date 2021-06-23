package no08.no0846;


import org.junit.Test;

public class Test0846 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[] hand = {1,1,2,2,3,3};
		int W = 3;
		
		so.isNStraightHand(hand, W);
	}
}
