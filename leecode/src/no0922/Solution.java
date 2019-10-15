package no0922;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
    	int D = 1;
    	int S = 0;
    	
    	while(D<A.length&&S<A.length) {
    		if(A[S]%2==0) {
    			S += 2;
    			continue;
    		}
    		if(A[D]%2==1) {
    			D += 2;
    			continue;
    		}
    		
    		int temp = A[S];
    		A[S] = A[D];
    		A[D] = temp;
    	}
    	
    	
		return A;
        
    }
}
