package no05.no0589;

import java.util.LinkedList;
import java.util.List;
/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

返回其前序遍历: [1,3,5,6,2,4]。

说明: 递归法很简单，你可以使用迭代法完成此题吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<Integer> preorder(Node root) {
    	List<Node> queen = new LinkedList<>();
    	List<Integer> res = new LinkedList<>();
        
        if(root!=null)queen.add(0, root);
    	
    	Node temp = null;
    	
    	while(queen.size()>0) {
    		temp = queen.get(0);
    		queen.remove(0);
    		res.add(res.size(), temp.val);
    		
    		if(temp.children!=null) {
    			for(int i=temp.children.size()-1;i>=0;i--) {
    				queen.add(0, temp.children.get(i));
    			}
    		}
    		
    	}
    	
		return res;

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};