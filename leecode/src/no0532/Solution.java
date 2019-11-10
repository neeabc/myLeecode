package no0532;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums.length<=1||k<0)return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        Set<Line> line = new HashSet<Line>();
        
        set.add(nums[nums.length-1]);
        
        int temp;
        for(int i=nums.length-2;i>=0;i--) {
        	temp=nums[i];
        	if(set.contains(temp+k)) {
        		line.add(new Line(temp, temp+k));
        	}
        	if(set.contains(temp-k)) {
        		line.add(new Line(temp-k, temp));
        	}
        	set.add(temp);
        }
        
        return line.size();
        
    }
    class Line{
    	public Integer a;
    	public Integer b;
    	public Line(Integer a,Integer b) {
    		this.a=a;
    		this.b=b;
    	}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return a.hashCode()+b.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Line temp = (Line)obj;
			if(a.equals(temp.a)&&b.equals(temp.b)) {
				return true;
			}
			return false;
		}
    	
    }
}
