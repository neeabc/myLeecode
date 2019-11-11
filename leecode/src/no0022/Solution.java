package no0022;

import java.util.ArrayList;
import java.util.List;

/**
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
	public List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
    	helper(n, n, "", "");
    	return res;
    }
    
    public void helper(int left,int right,String check,String result) {
    	
    	if(left>0&&right>0) {//还有左括号和右括号
    		//添加左括号
    		helper(left-1, right, check+"(", result+"(");
    		
    		//添加右括号
    		if(check.length()>0&&check.charAt(check.length()-1)=='(') {
    			helper(left, right-1, check.substring(0, check.length()-1), result+")");
    		}
    		
    	}else if(left>0&&right==0) {//只有左括号
    		
    		return;
    		
    	}else if(left==0&&right>0) {//只有右括号
    		
    		if(check.length()>0&&check.charAt(check.length()-1)=='(') {
    			helper(left, right-1, check.substring(0, check.length()-1), result+")");
    		}
    		
    	}else {//都没有了
    		
    		if(check.length()==0) {
    			res.add(result);
    		}
    		
    	}
    }
}
