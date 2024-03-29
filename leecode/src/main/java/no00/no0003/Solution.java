package no00.no0003;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("tmtmzuxt"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Map<Character,Integer> aMap = new HashMap<>();

        int p = 1; //每个字符的位置
        int startPlace = 0; //标记子串的开始位置
        int res = 0; //最大的p-startPalce

        for (Character c : s.toCharArray()){
            if(aMap.containsKey(c)){
                //含有此字符,判断此字符是否在子串的起点
                int temp = aMap.get(c);
                if(temp > startPlace){
                    startPlace = temp;
                }
                //更新此字符的位置
                aMap.put(c, p);
            }else{
                //添加此字符
                aMap.put(c, p);
            }
            res = Math.max(res,p-startPlace);
            p++;
        }
        return res;
    }

}
