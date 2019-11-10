package no0581;
/**
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :

输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] maxs = new int[nums.length];
        maxs[0]=nums[0]; 
        for(int i=1;i<nums.length;i++) {
        	maxs[i]=Math.max(maxs[i-1], nums[i]);
        }
        
        int[] mins = new int[nums.length];
        mins[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--) {
        	mins[i]=Math.min(mins[i+1], nums[i]);
        }
        
        int maxCount = 0;
        for(int i=nums.length-1;i>=0;i--) {
        	if(maxs[i]==nums[i]) {
        		maxCount++;
        	}else {
        		break;
        	}
        }
        
        int minCount = 0;
        for(int i=0;i<nums.length-maxCount;i++) {
        	if(mins[i]==nums[i]) {
        		minCount++;
        	}else{
        		break;
        	}
        }
        
        return nums.length-maxCount-minCount;
    }
}
