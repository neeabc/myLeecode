package no02.no0214;
/*给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

示例 1:

输入: "aacecaaa"
输出: "aaacecaaa"
示例 2:

输入: "abcd"
输出: "dcbabcd"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
//只能在前面加
public class Solution2 {
    private char[] s;
    public String shortestPalindrome(String s) {

        if(s == null || s.equals("")){
            return s;
        }

        this.s = s.toCharArray();
        int start = 0;
        int end = s.length();
        int[] center = findCenter(start, end);
        return create(center[0], center[1]);
    }

    private int[] findCenter(int start, int end) {
        int ts = start;
        int te = end;

        while (ts<te){
            if(s[ts] == s[te-1]){ //指向的可能是中心
                ts++;
                te--;
            }else {
                end--;
                ts = start;
                te = end;
            }
        }
        return new int[]{start,end};
    }

    private String create(int start, int end) {
        int te = s.length*2 - (end - start);
        char[] res = new char[te];

        int ts = 0;
        int p = s.length;
        while (ts <= te){
            res[ts] = s[p-1];
            res[te-1] = s[p-1];
            ts++;p--;te--;
        }
        return new String(res);
    }
}
