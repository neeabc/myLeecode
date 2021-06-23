package no08.no0830;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
    	
        List<List<Integer>> res = new ArrayList<>();
        
        if(S.length()<3)
        	return new ArrayList<>();

        char s1=S.charAt(0);
        int a1 = 0;
        int b1 = 0;
        List<Integer> temp = null;
        for(int i=1;i<S.length();i++) {
        	if(s1==S.charAt(i)) {
        		b1++;
        	}else {
        		if((b1-a1+1)>=3) {
        			temp = new ArrayList<Integer>();
        			temp.add(a1);
        			temp.add(b1);
        			res.add(temp);
        		}
                s1=S.charAt(i);
        		a1=i;
        		b1=i;
        	}
        	
        }
        if((b1-a1+1)>=3) {
        	temp = new ArrayList<Integer>();
			temp.add(a1);
			temp.add(b1);
			res.add(temp);
        }
        return res;
    }
}
