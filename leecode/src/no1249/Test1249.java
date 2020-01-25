package no1249;

import org.junit.Test;

public class Test1249 {
	@Test
	public void test01() {
		Solution so = new Solution();
		String s = "(a(b(c)d)";
		String valid = so.minRemoveToMakeValid(s);
		System.out.println(valid);
	}
}
