package no0321;

import org.junit.Test;

import java.util.Arrays;



public class Test0321 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[] nums1 = {6, 7};
		int[] nums2 = {6, 0, 4};
		int k = 5;
		
		int[] max = so.maxNumber(nums1, nums2, k);
		System.out.println(Arrays.toString(max));
	}
}
