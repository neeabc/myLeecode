package no0929;


import org.junit.Test;

public class Test0929 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		so.numUniqueEmails(emails);
	}
}
