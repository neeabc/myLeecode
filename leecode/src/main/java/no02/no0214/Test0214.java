package no02.no0214;

import org.junit.Test;

public class Test0214 {

    @Test
    public void test01(){
        Solution1 so = new Solution1();
        String a = so.shortestPalindrome("ababbbabbaba");
        System.out.println(a);
    }

}
