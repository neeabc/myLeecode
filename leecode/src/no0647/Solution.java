package no0647;

public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        
        for(int i=0;i<s.length();i++) {
        	
        	for(int m=i,n=i+1;;m--,n++) { //以[i,i+1)为回文的中心
        		if(check(s,m,n)) {
        			count++;
        		}else {
        			break;
        		}
        	}
        	
        	for(int m=i,n=i+2;;m--,n++) { //以[i,i+2)为回文的中心
        		if(check(s,m,n)) {
        			count++;
        		}else {
        			break;
        		}
        	}
        	
        }
        
        return count;
    }
    
    public boolean check(String s,int start,int end) {
    	if(start<0||end>s.length()) { //超界
    		return false;
    	}
    	
    	if(end-start==1) {
    		return true;
    	}
    	
    	if(s.charAt(start)==s.charAt(end-1)) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
