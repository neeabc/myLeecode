package no00.no0050;

import org.junit.Test;

public class Test0050 {

    @Test
    public void test01(){
        Solution so = new Solution();
        double v = so.myPow(2, -2147483648);
        System.out.println(v);
    }
}
