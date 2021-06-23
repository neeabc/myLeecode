package no01.no0118;

import java.util.ArrayList;
import java.util.List;

/**
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(numRows==0)return res;
    	List<Integer> line1 = new ArrayList<>();
    	line1.add(0, 1);
    	res.add(0,line1);
    	if(numRows==1)return res;
    	List<Integer> line2 = new ArrayList<>();
    	line2.add(0,1);
    	line2.add(1,1);
    	res.add(1,line2);
    	if(numRows==2)return res;
    	
    	
    	res = (generate(numRows-1));
    	
    	List<Integer> temp1 = res.get(res.size()-1);
    	List<Integer> temp2 = new ArrayList<>();
    	
    	temp2.add(0,1);
    	for(int i=1;i<temp1.size();i++) {
    		temp2.add(i,(temp1.get(i)+temp1.get(i-1)));
    	}
    	temp2.add(temp1.size(),1);
    	
    	res.add(temp2);
		return res;
        
    }
}
