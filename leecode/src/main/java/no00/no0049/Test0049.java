package no00.no0049;

import java.util.List;

import org.junit.Test;

public class Test0049 {
	@Test
	public void test01() {
		Solution so = new Solution();
		String[] strs = {"ron","huh","gay","tow","moe","tie","who","ion","rep","bob","gte","lee","jay","may","wyo","bay","woe","lip","tit","apt","doe","hot","dis","fop","low","bop","apt","dun","ben","paw","ere","bad","ill","fla","mop","tut","sol","peg","pop","les"};
		List<List<String>> list = so.groupAnagrams(strs);
		System.out.println(list);
	}

}
