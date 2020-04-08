package no03.no0321;
/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:

输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
示例 3:

输入:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
输出:
[9, 8, 9]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/create-maximum-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = null;
        for(int i=0;i<=k;i++) {
        	if(i<=nums1.length&&(k-i)<=nums2.length) {
        		int[] n1 = getMax(nums1,i);
            	int[] n2 = getMax(nums2,k-i);
            	
            	int[] temp = merge(n1,n2);
            	
            	if(res==null) {
            		res=temp;
            	}else {
            		res=maxNum(res,temp);
            	}
        	}
        }
        return res;
    }
    
    public int[] getMax(int[] nums,int len) { //获取数组,指定长度,最大子数组
		int[] res = new int[len];
		
		int start = 0;
		for(int i=0;i<len;i++) {
			
			int max = Integer.MIN_VALUE;
			int maxIndex = 0;
			
			for(int j=start;j<nums.length-(len-(i+1));j++) {
				if(nums[j]>max) {
					max = nums[j];
					maxIndex = j;
				}
			}
			res[i] = max;
			start = maxIndex+1;
			
		}

    	return res;
    	
    }
    
    public int[] merge(int[] nums1,int[] nums2) { //合并两个数组
		int[] res = new int[nums1.length+nums2.length];
		
		int s1=0;
		int s2=0;
		for(int i=0;i<res.length;i++) {
			if(compareTo(nums1, s1, nums2, s2)) {
				res[i]=nums1[s1];
				s1++;
			}else {
				res[i]=nums2[s2];
				s2++;
			}
		}
		
    	return res;
    	
    }
    
    public boolean compareTo(int[] nums1,int s1,int[] nums2,int s2) { //返回true,选nums1,返回false,选nums2
		
    	if(s1==nums1.length&&s2==nums2.length) {
    		return true;
    	}else if(s1==nums1.length) {
    		return false;
    	}else if(s2==nums2.length) {
    		return true;
    	}else {
    		if(nums1[s1]==nums2[s2]) {
    			return compareTo(nums1, s1+1, nums2, s2+1);
    		}else if(nums1[s1]>nums2[s2]){
    			return true;
    		}else {
    			return false;
    		}
    	}
    }
    
    public int[] maxNum(int[] nums1,int[] nums2) { //返回true
    	
    	for(int i=0;i<nums1.length;) {
			if(nums1[i]==nums2[i]) {
				i++;
			}else if(nums1[i]>nums2[i]) {
				return nums1;
			}else {
				return nums2;
			}
		}
    	
    	return nums1;
    }
}
