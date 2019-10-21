package no0965;

/**
 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

只有给定的树是单值二叉树时，才返回 true；否则返回 false。

示例 1：

输入：[1,1,1,1,1,null,1]
输出：true
示例 2：

输入：[2,2,2,5,2]
输出：false
 
提示：

给定树的节点数范围是 [1, 100]。
每个节点的值都是整数，范围为 [0, 99] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/univalued-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
    	if(root.left==null&&root.right==null)return true;
    	
    	int temp = root.val;
    	if(root.left!=null) {
    		if(root.left.val!=temp||isUnivalTree(root.left)==false) {
    			return false;
    		}
    	}
    	if(root.right!=null) {
    		if(root.right.val!=temp||isUnivalTree(root.right)==false) {
    			return false;
    		}
    	}
    	
		return true;
        
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
