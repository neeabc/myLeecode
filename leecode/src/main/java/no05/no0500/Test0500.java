package no05.no0500;


import org.junit.Test;

public class Test0500 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		String[] words = new String[] {"Hello", "Alaska", "Dad", "Peace"};
		
		for(String word:so.findWords(words)) {
			System.out.println(word);
		}
	}
}
