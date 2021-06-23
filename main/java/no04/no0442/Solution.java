package no04.no0442;

import java.util.ArrayList;
import java.util.List;

/**
给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：

输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //第一次遍历,将数值放在正确的位置
    	for(int i=0;i<nums.length;) {
    		int temp = nums[i];
    		//如果这个位置的数是正确的 或者 正确的位置已经有正确的数时 i++
    		if(i+1==temp||nums[temp-1]==temp) {
    			i++;
    		}else {//否则,将这个数送到正确的位置
    			swap(nums,i,temp-1);
    		}
    		
    	}
    	
        //第二次遍历,输出位置不正确的数字
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
        	if(i+1!=nums[i]) {
        		res.add(nums[i]);
        	}
        }
        return res;
    }
    
    public void swap(int[] nums,int a,int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}
