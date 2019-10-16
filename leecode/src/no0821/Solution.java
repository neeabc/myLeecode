package no0821;
/**
给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

示例 1:

输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
说明:

字符串 S 的长度范围为 [1, 10000]。
C 是一个单字符，且保证是字符串 S 里的字符。
S 和 C 中的所有字母均为小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int[] shortestToChar(String S, char C) {
    	
    	char[] a = S.toCharArray();
    	int[] b = new int[S.length()];
    	
    	int left = -1;
    	int right = -1;
    	for(int i=0;i<S.length();i++) {
    		if(a[i]==C) {
    			right = i;
    			break;
    		}
    	}
    	
        for(int i=0;i<S.length();) {
        	//判断是否在范围内
        	if(left==-1&&right==-1) {
        		b[i]=0;
        		i++;
        		continue;
        		
        	}else if(left==-1&&right!=-1) {
        		b[i] = right-i;
        		i++;
        		
        		if(right<i) {
        			left = right;
        			right = -1;
        			for(int j=i;j<S.length();j++) {
        	    		if(a[j]==C) {
        	    			right = j;
        	    			break;
        	    		}
        	    	}
        		}
        		
        	}else if(left!=-1&&right==-1) {
        		b[i] = i-left;
        		i++;
        		
        	}else {
        		b[i] = (i-left)>(right-i)?(right-i):(i-left);
        		i++;
        		
        		if(right<i) {
        			left = right;
        			right = -1;
        			for(int j=i;j<S.length();j++) {
        	    		if(a[j]==C) {
        	    			right = j;
        	    			break;
        	    		}
        	    	}
        		}
        		
        	}
        	
        }
        
		return b;
    }
}
