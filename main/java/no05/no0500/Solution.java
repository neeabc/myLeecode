package no05.no0500;

import java.util.HashMap;

/**
 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。

示例：

输入: ["Hello", "Alaska", "Dad", "Peace"]
输出: ["Alaska", "Dad"]
 

注意：

你可以重复使用键盘上同一字符。
你可以假设输入的字符串将只包含字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/keyboard-row
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */

public class Solution {
	public static HashMap<Character,Integer> charList = new HashMap<>();
	static{
		charList.put('Q', 1);charList.put('q', 1);
		charList.put('W', 1);charList.put('w', 1);
		charList.put('E', 1);charList.put('e', 1);
		charList.put('R', 1);charList.put('r', 1);
		charList.put('T', 1);charList.put('t', 1);
		charList.put('Y', 1);charList.put('y', 1);
		charList.put('U', 1);charList.put('u', 1);
		charList.put('I', 1);charList.put('i', 1);
		charList.put('O', 1);charList.put('o', 1);
		charList.put('P', 1);charList.put('p', 1);
		
		charList.put('A', 2);charList.put('a', 2);
		charList.put('S', 2);charList.put('s', 2);
		charList.put('D', 2);charList.put('d', 2);
		charList.put('F', 2);charList.put('f', 2);
		charList.put('G', 2);charList.put('g', 2);
		charList.put('H', 2);charList.put('h', 2);
		charList.put('J', 2);charList.put('j', 2);
		charList.put('K', 2);charList.put('k', 2);
		charList.put('L', 2);charList.put('l', 2);
		
		charList.put('Z', 3);charList.put('z', 3);
		charList.put('X', 3);charList.put('x', 3);
		charList.put('C', 3);charList.put('c', 3);
		charList.put('V', 3);charList.put('v', 3);
		charList.put('B', 3);charList.put('b', 3);
		charList.put('N', 3);charList.put('n', 3);
		charList.put('M', 3);charList.put('m', 3);
	}
	
    public String[] findWords(String[] words) {
    	
    	String[] newwords = new String[words.length];
    	int count = 0;
    	for(String word:words) {
    		if(checkString(word)) {
    			newwords[count] = word;
    			count++;
    		}
    	}
    	
    	String[] w = new String[count];
    	for(int i=0;i<count;i++) {
    		w[i] = newwords[i];
    	}
    	
		return w;
        
    }
    
    public boolean checkString(String str) {
    	char[] ch = str.toCharArray();
    	
    	int level = charList.get(ch[0]);
    	
    	for(int i=1;i<ch.length;i++) {
    		if(level!=charList.get(ch[i])) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
