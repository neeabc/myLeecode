package no00.no0048;
/**
 * 给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
    	for(int start=0,end=n;end>start+1;start++,end--) {
        	turnRound(matrix, start, end);
        }
    }
    
    public void turnRound(int[][] matrix,int start,int end) { //将一圈数字旋转
    	for(int i=0;i<end-start-1;i++) {
    		turn4(matrix,start,end,i);
    	}
    }
    
    public void turn4(int[][] matrix,int start,int end,int len) { //旋转圆心对称的四个数
    	int temp = matrix[start][start+len];
    	matrix[start][start+len] = matrix[end-1-len][start];
    	matrix[end-1-len][start] = matrix[end-1][end-1-len];
    	matrix[end-1][end-1-len] = matrix[start+len][end-1];
    	matrix[start+len][end-1] = temp;
    }
}
