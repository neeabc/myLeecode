package no0695;
/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。

示例 2:

[[0,0,0,0,0,0,0,0]]
对于上面这个给定的矩阵, 返回 0。

注意: 给定的矩阵grid 的长度和宽度都不超过 50。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-area-of-island
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
    	for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[i].length;j++) {
        		if(grid[i][j]==1) {
        			max = Math.max(max, find(grid,i,j));
        		}
        	}
        }
    	return max;
    }
    
    public int find(int[][] grid,int i,int j) {//以[i,j]为起点删除岛屿,返回删除的数量
		grid[i][j]=0;
		int count = 1;
    	
		//上方
		int[][] points = {
				{i-1,j},
				{i,j-1},
				{i+1,j},
				{i,j+1}
		};
		for(int[] point:points) {
			int x=point[0];
			int y=point[1];
			if(x>=0&&x<grid.length
				&&y>=0&&y<grid[0].length
				&&grid[x][y]==1
				) {
				count += find(grid,x,y);
			}
		}
    	return count;
    	
    }
}
