package no1122;

public class Solution1 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
    	int[] base = new int[1001];
    	
    	for(int i:arr1) {
    		base[i]++;
    	}
    	
    	
    	int[] res = new int[arr1.length];
    	int count = 0;
    	for(int i:arr2) {
    		for(int j=0;j<base[i];j++) {
    			res[count] = i;
    			count++;
    		}
    		base[i] = 0;
    	}
    	
    	int bCount = 0;
    	for(int i:base) {
    		for(int j=0;j<i;j++) {
    			res[count] = bCount;
    			count++;
    		}
    		
    		if(count>=res.length) {
    			break;
    		}
    		bCount++;
    	}
    	
		return res;
        
    }
}
