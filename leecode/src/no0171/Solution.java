package no0171;
/**
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int titleToNumber(String s) {
    	char[] S = s.toCharArray();
    	
    	int num = 0;
    	
    	for(int i=S.length-1,count=0;i>=0;i--,count++) {
    		num += (S[i]-64)*Math.pow(26, count);
    	}

		return num;
        
    }
}
