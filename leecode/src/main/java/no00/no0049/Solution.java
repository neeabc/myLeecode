package no00.no0049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xiao
 *
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
    	List<List<String>> res = new ArrayList<>();
    	if(strs==null||strs.length==0) {
    		return res;
    	}
    	Map<String,Integer> map = new HashMap<>();
    	for(String str:strs) {
    		//字符串转数组
    		int[] temp = new int[26];
    		int len = str.length();
    		for(int i=0;i<len;i++) {
    			temp[str.charAt(i)-'a']++;
    		}
    		
    		//将数组转成字符串
    		StringBuilder b = new StringBuilder();
    		for(int i=0;i<26;i++) {
    			if(temp[i]!=0) {
    				b.append(""+((char)(i+'a'))+temp[i]);
    			}
    		}
    		String newStr = b.toString();
    		
    		//处理
    		if(map.containsKey(newStr)) { //已经存在
    			res.get(map.get(newStr)).add(str);
    		}else { //不存在
    			//加入res
    			List<String> list = new ArrayList<String>();
    			list.add(str);
    			res.add(list);
    			//加入map
    			map.put(newStr,map.size());
    		}
    	}
    	return res;
    }
}
