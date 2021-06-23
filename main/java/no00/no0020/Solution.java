package no00.no0020;

import java.util.LinkedList;

/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for(char c:s.toCharArray()){
            //如果list为空
            if(list.size()==0){
                //如果是左括弧
                if (c=='(' || c=='[' || c=='{'){
                    list.addLast(c);
                }else { //是右括弧
                    return false;
                }
            }else{ //如果list不为空
                if ((c==')' && list.getLast()=='(') ||
                        (c=='}' && list.getLast()=='{') ||
                        (c==']' && list.getLast()=='[') ){
                    list.removeLast();
                }else {
                    list.addLast(c);
                }
            }
        }

        return list.size() == 0;
    }
}
