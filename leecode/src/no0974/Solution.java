package no0974;
/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

 

示例：

输入：A = [4,5,0,-2,-3,1], K = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 K = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 

提示：

1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        
    	int[] sums = new int[A.length+1];
    	for(int i=1;i<sums.length;i++) {
    		sums[i] += sums[i-1]+A[i-1];
    	}
    	
    	int[] counts = new int[K];
    	for(int i=0;i<sums.length;i++) {
    		counts[(sums[i]%K+K)%K]++;
    	}
    	
    	int count = 0;
    	for(int i=0;i<counts.length;i++) {
    		count += counts[i]*(counts[i]-1)/2;
    	}
    	return count;
    }
}
