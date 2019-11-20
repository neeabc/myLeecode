package no0257;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        LinkedList<Integer> line = new LinkedList<>();
        helper(res,line,root);
        return res;
    }
    
    public void helper(List<String> res,LinkedList<Integer> line,TreeNode root) {
    	if(root==null)return;
    	
    	line.addLast(root.val);
    	
    	if(root.left!=null) {
    		helper(res, line, root.left);
    		line.removeLast();
    	}
    	
    	if(root.right!=null) {
    		helper(res, line, root.right);
    		line.removeLast();
    	}
    	
    	if(root.left==null&&root.right==null) {
    		StringBuilder temp = new StringBuilder();
    		Iterator<Integer> iter = line.iterator();
    		temp.append(iter.next());
    		for(int i=1;i<line.size();i++) {
    			temp.append("->").append(iter.next());
    		}
    		
    		res.add(temp.toString());
    		return;
    	}
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}