package no0120;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Test0120 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		List<List<Integer>> triangle = new ArrayList<>();
		
		List<Integer> line1 = new ArrayList<>();
		line1.add(2);
		
		List<Integer> line2 = new ArrayList<>();
		line2.add(3);
		line2.add(4);
		
		List<Integer> line3 = new ArrayList<>();
		line3.add(6);
		line3.add(5);
		line3.add(7);
		
		List<Integer> line4 = new ArrayList<>();
		line4.add(4);
		line4.add(1);
		line4.add(8);
		line4.add(3);
		
		triangle.add(line1);
		triangle.add(line2);
		triangle.add(line3);
		triangle.add(line4);
		
		so.minimumTotal(triangle);
		
		
	}
}
