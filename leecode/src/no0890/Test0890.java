package no0890;

import org.junit.jupiter.api.Test;

public class Test0890 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
		
		so.findAndReplacePattern(words, pattern);
	}
}
