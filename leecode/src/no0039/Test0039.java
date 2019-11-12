package no0039;

import org.junit.jupiter.api.Test;

public class Test0039 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		int[] candidates = {2,3,5};
		int target = 8;
		
		so.combinationSum(candidates, target);
	}
}
