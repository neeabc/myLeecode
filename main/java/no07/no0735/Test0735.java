package no07.no0735;

import java.util.Arrays;

import org.junit.Test;

public class Test0735 {
	
	@Test
	public void test01() {
		Solution so = new Solution();
		
		int[] asteroids = {5, 10, -5};
		
		int[] is = so.asteroidCollision(asteroids);
		
		System.out.println(Arrays.toString(is));
	}

}
