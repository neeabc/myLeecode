package no00.no0052;
/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
	public int num = 0;
    public int totalNQueens(int n) {
        helper(new int[n],0);
        return num;
    }
    
    public void helper(int[] res,int count){
    	//结束条件
    	if(count==res.length) {
    		num++;
    		return;
    	}
    	
    	//下一行可以放置皇后的位置,0可放,1不可放
    	int[] can = new int[res.length];
    	for(int i=0;i<count;i++) {
    		int temp = res[i];
    		
    		//下方不能放
    		can[temp]=1;
    		
    		//左下不能放
    		int left = temp+i-count;
    		if(left>=0&&left<can.length) {
    			can[left]=1;
    		}
    		
    		//右下不能放
    		int right = temp-i+count;
    		if(right>=0&&right<can.length) {
    			can[right]=1;
    		}
    	}
    	
    	//遍历能放的情况
    	for(int i=0;i<can.length;i++) {
    		if(can[i]==0) {
    			res[count]=i;
    			helper(res, count+1);
    		}
    	}
    }
}
