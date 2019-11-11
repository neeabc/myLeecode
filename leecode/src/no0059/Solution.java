package no0059;
/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int[][] directs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int count = 0;
        int[] point = new int[] {0,0};
        int[] chance1 = new int[2];
        int[] chance2 = new int[2];
        for(int i=1;i<=n*n;i++) {
        	res[point[0]][point[1]]=i;
        	
        	chance1[0]=point[0]+directs[count][0];
        	chance1[1]=point[1]+directs[count][1];
        	
        	chance2[0]=point[0]+directs[(count+1)%4][0];
        	chance2[1]=point[1]+directs[(count+1)%4][1];
        	
        	if(chance1[0]>=0
        			&&chance1[0]<n
        			&&chance1[1]>=0
        			&&chance1[1]<n
        			&&res[chance1[0]][chance1[1]]==0) {
        		point[0]=chance1[0];
        		point[1]=chance1[1];
        	}else if(chance2[0]>=0
        			&&chance2[0]<n
        			&&chance2[1]>=0
        			&&chance2[1]<n
        			&&res[chance2[0]][chance2[1]]==0) {
        		point[0]=chance2[0];
        		point[1]=chance2[1];
        		count = (count+1)%4;
        	}else {
        		break;
        	}

        }
        return res;
    }
}
