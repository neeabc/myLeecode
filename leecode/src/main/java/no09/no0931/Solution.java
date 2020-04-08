package no09.no0931;
/**
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。

下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。

 

示例：

输入：[[1,2,3],[4,5,6],[7,8,9]]
输出：12
解释：
可能的下降路径有：
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
和最小的下降路径是 [1,4,7]，所以答案是 12。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int minFallingPathSum(int[][] A) {
        int high = A.length;
        int len = A[0].length;
        
        for(int i=1;i<high;i++) {
        	for(int j=0;j<len;j++) {
        		
        		int upMin = Integer.MAX_VALUE;
        		for(int k=j-1;k<=j+1;k++) {
        			if(k>=0&&k<len) {
        				upMin=Math.min(upMin, A[i-1][k]);
        			}
        		}
        		
        		A[i][j] += upMin;
        		
        	}
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<len;i++) {
        	min=Math.min(min, A[high-1][i]);
        }
        return min;
    }
}
