package no05.no0561;
/**
给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。

示例 1:

输入: [1,4,3,2]

输出: 4
解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
提示:

n 是正整数,范围在 [1, 10000].
数组中的元素范围在 [-10000, 10000].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/array-partition-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
		mySort(nums,0,nums.length-1);
		int sum=0;
		for(int i=0;i<nums.length;i += 2) {
			sum += nums[i];
		}
		return sum;
		
        
    }
    
    public void mySort(int[] nums,int start,int end) {
		if(end-start<1) {
			return ;
		}
		
		int middle = (end+start)/2;
		int[] res = new int[end+1-start];
		
		int tempA = start;
		int tempB = middle+1;
		
		mySort(nums,start,middle);
		mySort(nums,middle+1,end);
		
		int i=0;
		while(tempA<=middle&&tempB<=end) {
			if(nums[tempA]>nums[tempB]) {
				res[i] = nums[tempB];
				i++;
				tempB++;
			}else {
				res[i] = nums[tempA];
				i++;
				tempA++;
			}
		}
		
		while(tempA<=middle) {
			res[i] = nums[tempA];
			i++;
			tempA++;
		}
		while(tempB<=end) {
			res[i] = nums[tempB];
			i++;
			tempB++;
		}
    	
		i=0;
    	for(int j=start;j<=end;j++) {
    		nums[j] = res[i];
    		
    		i++;
    	}
    	
    	return ;
    	
    }
}
