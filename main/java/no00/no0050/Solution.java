package no00.no0050;
/*
* 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */
public class Solution {
    private Double[] p = new Double[32];
    public double myPow(double x, int n) {
        long h = n;
        if (h == 0){ //幂为零,返回1
            return 1;
        }
        if (x == 0){ //数为零
            if (h>0){
                return 0;
            }else{
                return Double.POSITIVE_INFINITY;
            }
        }
        if (h<0){
            x = 1/x;
            h = -h;
        }

        p[0] = x;
        Double res = 1.0;
        long j = 1;
        for(int i=0;i<32;i++){
            if((j & h) != 0){
                res *= getP(i);
            }
            j = j << 1;
        }

        return res;
    }

    private Double getP(int i) {
        if (p[i]==null){
            Double h = getP(i-1);
            p[i] = h*h;
            return p[i];
        }else {
            return p[i];
        }
    }
}
