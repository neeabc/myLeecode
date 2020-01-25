package no0329;

/**给定一个整数矩阵，找出最长递增路径的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。

示例 1:

输入: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
输出: 4 
解释: 最长递增路径为 [1, 2, 6, 9]。
示例 2:

输入: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
输出: 4 
解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xiao
 *
 */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int line = matrix.length;
        if(line==0) {
        	return 0;
        }
        int len = matrix[0].length;
        if(len==0) {
        	return 0;
        }
        
        int[][] memory = new int[line][len];
        
        for(int i=0;i<line;i++) {
        	for(int j=0;j<len;j++) {
        		max = Math.max(max, getLong(i, j, memory, matrix,line,len));
        	}
        }
        return max;
    }
    
    public int getLong(int i,int j,int[][] memory,int[][] matrix,int line,int len) {
    	if(memory[i][j]!=0) { //已经以此点开始计算过了
    		return memory[i][j];
    	}else {
    		int aroundMax = 0;
    		//上方,先判断是否存在,是否值小于
    		if((i-1)>=0&&matrix[i][j]>matrix[i-1][j]) { //存在
    			aroundMax = Math.max(aroundMax, getLong(i-1, j, memory, matrix,line,len));
    		}
    		//下
    		if((i+1)<line&&matrix[i][j]>matrix[i+1][j]) { //存在
    			aroundMax = Math.max(aroundMax, getLong(i+1, j, memory, matrix,line,len));
    		}
    		
    		//左
    		if((j-1)>=0&&matrix[i][j]>matrix[i][j-1]) { //存在
    			aroundMax = Math.max(aroundMax, getLong(i, j-1, memory, matrix,line,len));
    		}
    		//右
    		if((j+1)<len&&matrix[i][j]>matrix[i][j+1]) { //存在
    			aroundMax = Math.max(aroundMax, getLong(i, j+1, memory, matrix,line,len));
    		}
    		
    		int res = aroundMax + 1;
    		//保存到memory
    		memory[i][j] = res;
    		return res;
    	}
    }
}
