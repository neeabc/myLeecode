package no0852;
/**
 我们把符合下列属性的数组 A 称作山脉：

A.length >= 3
存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

示例 1：

输入：[0,1,0]
输出：1
示例 2：

输入：[0,2,1,0]
输出：1
 

提示：

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A 是如上定义的山脉

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */

public class Solution {
    public int peakIndexInMountainArray(int[] A) {
    	int small = 1;
    	int big = A.length-2;
    	int middle = small+(big-small)/2;
    	while(small<=big) {
    		if(A[middle]>A[middle+1]&&A[middle]>A[middle-1]) {
    			return middle;
    		}else if(A[middle]<A[middle+1]) {
    			small = middle;
    			middle = big-(big-small)/2;
    		}else {
    			big = middle;
    			middle = small+(big-small)/2;
    		}
    		
    	}
    	
    	
		return 0;
        
    }
}
