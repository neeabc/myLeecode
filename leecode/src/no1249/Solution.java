package no1249;

import java.util.LinkedList;

/**给你一个由 '('、')' 和小写字母组成的字符串 s。

你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。

请返回任意一个合法字符串。

有效「括号字符串」应当符合以下 任意一条 要求：

空字符串或只包含小写字母的字符串
可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 

示例 1：

输入：s = "lee(t(c)o)de)"
输出："lee(t(c)o)de"
解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
示例 2：

输入：s = "a)b(c)d"
输出："ab(c)d"
示例 3：

输入：s = "))(("
输出：""
解释：空字符串也是有效的
示例 4：

输入：s = "(a(b(c)d)"
输出："a(b(c)d)"
 

提示：

1 <= s.length <= 10^5
s[i] 可能是 '('、')' 或英文小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xiao
 *
 */
public class Solution {
    public String minRemoveToMakeValid(String s) {
        Character[] res = new Character[s.length()]; 
        LinkedList<Integer> stack = new LinkedList<>();
        
        //通过栈判断删除哪一些括弧
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	if(c=='(') { //是左括弧
        		stack.addLast(i);
        	}else if(c==')'){ //是右括弧
        		if(!stack.isEmpty()) { //括弧匹配上了
        			int left = stack.pollLast();
        			res[left] = '(';
        			res[i] = ')';
        		}
        	}else { //不是
        		res[i] = c;
        	}
        }
        //清理栈
        Integer p = null;
        while((p = stack.pollLast())!=null) {
        	res[p] = null;
        }
        
        //数组转字符串,去除为null的
        StringBuilder str = new StringBuilder(res.length);
        for(int i=0;i<res.length;i++) {
        	if(res[i]!=null) {
        		str.append(res[i]);
        	}
        }
        
        return str.toString();
    }
}
