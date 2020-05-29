package no09.no0973;

import org.junit.Test;

import java.util.Arrays;

public class Test0973 {

    @Test
    public void test01() {

        Solution solution = new Solution();
        int[][] ints = solution.kClosest(new int[][]{{3, 3}, {4, 3}, {1, 2}, {2, 2}}, 2);
        System.out.println(Arrays.toString(ints));

    }

}
