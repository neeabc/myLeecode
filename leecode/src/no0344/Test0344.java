package no0344;


import org.junit.Test;

public class Test0344 {
	@Test
	public void startTest() {
		Solution so = new Solution();
		
		char[] s = new char[] {' ','a',' ',','};
		
		so.reverseString(s);
		
		for(char m:s) {
			System.out.print("|"+m+"|");
		}
		
	}
}
