package no05.no0532;


import org.junit.Test;

public class Test0532 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[] nums = new int[] {6,3,5,7,2,3,3,8,2,4};
		int k = 2;
		
		so.findPairs(nums, k);
	}
}
