package no1222;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。

「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。

「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。

请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。

 

示例 1：



输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
输出：[[0,1],[1,0],[3,3]]
解释： 
[0,1] 的皇后可以攻击到国王，因为他们在同一行上。 
[1,0] 的皇后可以攻击到国王，因为他们在同一列上。 
[3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。 
[0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。 
[4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。 
[2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
示例 2：



输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
输出：[[2,2],[3,4],[4,4]]
示例 3：



输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 

提示：

1 <= queens.length <= 63
queens[0].length == 2
0 <= queens[i][j] < 8
king.length == 2
0 <= king[0], king[1] < 8
一个棋盘格上最多只能放置一枚棋子。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queens-that-can-attack-the-king
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] can = new int[9][];
        
        for(int i=0;i<queens.length;i++) {
        	int[] queen = queens[i];
        	
        	if(king[0]==queen[0]) { //同行
        		
        		if(queen[1]<king[1]) {//左边
        			can[5]=min(king, can[5], queen);
        		}else {//右边
        			can[1]=min(king, can[1], queen);
        		}
        		
        	}else if(king[1]==queen[1]){ //同列
        		
        		if(queen[0]>king[0]) {//上边
        			can[7]=min(king,can[7],queen);
        		}else {//下边
        			can[3]=min(king,can[3],queen);
        		}
        		
        		
        	}else if((king[0]-king[1])==(queen[0]-queen[1])) { //右下斜线
        		
        		if(queen[1]>king[1]) {//右下
        			can[2]=min(king, can[2], queen);
        		}else {//左上
        			can[6]=min(king, can[6], queen);
        		}
        		
        		
        	}else if((king[0]+king[1])==(queen[0]+queen[1])) { //左下斜线
        		
        		if(queen[1]<king[1]) { //左下
        			can[4]=min(king, can[4], queen);
        		}else { //右上
        			can[8]=min(king, can[8], queen);
        		}
        		
        	}
        	
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
        //遍历数组生成结果
    	for(int i=1;i<can.length;i++) {
    		int[] queen = can[i];
    		if(queen!=null) {
    			List<Integer> temp = new ArrayList<>();
    			temp.add(queen[0]);
    			temp.add(queen[1]);
    			res.add(temp);
    		}
    	}
    	
    	return res;
        
    }
    
    //返回距离King比较近的queen
    public int[] min(int[] king,int[] a,int[] b) {
    	if(a==null&&b==null)return null;
    	if(a==null)return b;
    	if(b==null)return a;
    	
    	int lenA = (int)(Math.pow((king[0]-a[0]),2)+Math.pow((king[1]-a[1]), 2));
    	int lenB = (int)(Math.pow((king[0]-b[0]),2)+Math.pow((king[1]-b[1]), 2));
    	return lenA>lenB? b: a;
    }
}
