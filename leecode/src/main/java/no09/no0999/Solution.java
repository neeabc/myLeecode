package no09.no0999;
/**
在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。

车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。

返回车能够在一次移动中捕获到的卒的数量。
 

示例 1：



输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
输出：3
解释：
在本例中，车能够捕获所有的卒。
示例 2：



输入：[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
输出：0
解释：
象阻止了车捕获任何卒。
示例 3：



输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
输出：3
解释： 
车可以捕获位置 b5，d6 和 f5 的卒。
 

提示：

board.length == board[i].length == 8
board[i][j] 可以是 'R'，'.'，'B' 或 'p'
只有一个格子上存在 board[i][j] == 'R'

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/available-captures-for-rook
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int numRookCaptures(char[][] board) {
    	int[] position = null;
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[i].length;j++) {
        		if(board[i][j]=='R') {
        			position = new int[] {i,j};
        			break;
        		}
        	}
        	if(position!=null)break;
        	
        }
        
        int sum = 0;
        //左边
        for(int i=position[1]-1;i>=0;i--) {
        	if(board[position[0]][i]=='B') {
        		break;
        	}else if(board[position[0]][i]=='p') {
        		sum++;
        		break;
        	}
        }
        	
        //右边
        for(int i=position[1]+1;i<board[position[0]].length;i++) {
        	if(board[position[0]][i]=='B') {
        		break;
        	}else if(board[position[0]][i]=='p') {
        		sum++;
        		break;
        	}
        }
        	
        //上边
        for(int i=position[0]-1;i>=0;i--) {
        	if(board[i][position[1]]=='B') {
        		break;
        	}else if(board[i][position[1]]=='p') {
        		sum++;
        		break;
        	}
        }
        	
        	
        //下边
        for(int i=position[0]+1;i<board.length;i++) {
        	if(board[i][position[1]]=='B') {
        		break;
        	}else if(board[i][position[1]]=='p') {
        		sum++;
        		break;
        	}
        }
        	
        return sum;
        	
    }
}
