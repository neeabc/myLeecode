package no00.no0047;

import org.junit.Test;

import java.util.List;


public class Test0047 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[] nums = {1,1,2,2};
		
		List<List<Integer>> list= so.permuteUnique(nums);
		
		System.out.println(list);
	}
}
