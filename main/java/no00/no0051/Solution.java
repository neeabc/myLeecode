package no00.no0051;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> res = new ArrayList<List<String>>();
	public List<List<String>> solveNQueens(int n) {
        helper(new int[n+1], 1,n);
        return res;
    }
    
    public void helper(int[] result,int count,int len) {
    	//结束条件
    	if(count==len+1) {
    		res.add(transfomer(result,len));
    		return;
    	}
    	
    	//推测下一行可以选择的位置
    	int[] can = new int[len+1];
    	for(int i=1;i<count;i++) {
    		int temp=result[i];
    		//上方不能放
    		can[temp]=1;
    		
    		//左下不能放
    		int left = temp+i-count;
    		if(left>=1&&left<len+1) {
    			can[left]=1;
    		}
    		
    		//右下不能放
    		int right = temp-i+count;
    		if(right>=1&&right<len+1) {
    			can[right]=1;
    		}
    		
    	}
    	
    	//遍历所有可以选择的位置
    	for(int i=1;i<can.length;i++) {
    		if(can[i]==0) {
    			result[count]=i;
    			helper(result, count+1, len);
    		}
    	}
    	
    }
    
    public List<String> transfomer(int[] result,int len){
    	List<String> resList = new ArrayList<>();
    	
    	for(int i=1;i<result.length;i++) {
    		
    		int temp = result[i];
    		StringBuilder str = new StringBuilder();
    		for(int j=1;j<len+1;j++) {
    			if(j==temp) {
    				str.append("Q");
    			}else {
    				str.append(".");
    			}
    		}
    		
    		resList.add(str.toString());
    	}
    	
    	return resList;
    }
}
