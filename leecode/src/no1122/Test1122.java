package no1122;

import org.junit.jupiter.api.Test;

public class Test1122 {
	@Test
	public void startTest() {
		Solution1 so = new Solution1();
		
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		
		so.relativeSortArray(arr1, arr2);
	}
}
