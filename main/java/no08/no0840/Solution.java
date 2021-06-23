package no08.no0840;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Administrator
 *
 */
public class Solution {
    public int numMagicSquaresInside(int[][] grid) {
    	int count = 0;
        for(int i=0;i<grid.length-2;i++) {
        	for(int j=0;j<grid[j].length-2;j++) {
        		int i1=0,i2=0,i3=0;
        		int j1=0,j2=0,j3=0;
        		int left=0,right=0;
        		Set<Integer> set = new HashSet<Integer>();
        		
        		int temp;
        		int flag = 0;
        		for(int m=0;m<3;m++) {
        			for(int n=0;n<3;n++) {
        				
        				temp = grid[i+m][j+n];
        				
        				if(set.contains(temp)||temp>9||temp<1) {
        					flag=1;
        					break;
        				}else {
        					set.add(temp);
        				}
        				
        				if(m==0) {
        					i1 += temp;
        				}else if(m==1) {
        					i2 += temp;
        				}else if(m==2) {
        					i3 += temp;
        				}
        				
        				if(n==0) {
        					j1 += temp;
        				}else if(n==1) {
        					j2 += temp;
        				}else if(n==2) {
        					j3 += temp;
        				}
        				
        				if(m-n==0) {
        					right += temp;
        				}
        				
        				if(m+n==2) {
        					left += temp;
        				}
        			}
        			if(flag==1) {
        				break;
        			}
        		}
        		if(flag==1) {
        			flag=0;
        			continue;
        		}
        		
        		//验证
        		if(i1==i2&&i1==i3&&i1==j1&&i1==j2&&i1==j3&&i1==left&&i1==right) {
        			count++;
        		}
        		
        	}
        }
        return count;
    }
}
