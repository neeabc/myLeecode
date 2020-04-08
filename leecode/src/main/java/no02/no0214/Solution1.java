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
//可以前后加字符串,获取回文
public class Solution1 {
    private char[] s;
    public String shortestPalindrome(String s) {
        this.s = s.toCharArray();
        int start = 0;
        int end = s.length();

        if (isPalindrome(start, end)){
            return s;
        }

        int ts = start+1;
        int te = end-1;
        while (true){
            if((ts<end) && isPalindrome(ts, end)){
                return create(ts,end);
            }
            if ((start<te) && isPalindrome(start, te)){
                return create(start,te);
            }
            ts++;
            te--;
        }
    }

    private String create(int start, int end) {
        int i = s.length*2 - (end - start);
        char[] res = new char[i];

        int ts = 0;
        int te = i;
        if (start == 0){
            int p = end;
            while (ts <= te){
                res[ts] = s[p-1];
                res[te-1] = s[p-1];
                ts++;p--;te--;
            }
        }else {
            int p = 0;
            while (ts <= te){
                res[ts] = s[p];
                res[te-1] = s[p];
                ts++;p++;te--;
            }
        }
        return new String(res);
    }

    private boolean isPalindrome(int start, int end) {
        while (start<end){
            if(s[start] != s[end-1]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
