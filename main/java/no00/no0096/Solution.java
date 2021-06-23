package no00.no0096;
/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0]=1;
        
        for(int i=1;i<=n;i++) { //i为节点总数,即可选节点[0,i)
        	int temp = 0;
        	
        	for(int j=0;j<i;j++) { //j为选择的root节点
        		//左子树个数 [0,j)
        		int left = G[j];
        		
        		//右子树个数 [j+1,i)
        		int right = G[i-(j+1)];
        		
        		temp += left*right;
        	}
        	
        	G[i] = temp;
        }
        
        return G[n];
    }
}
