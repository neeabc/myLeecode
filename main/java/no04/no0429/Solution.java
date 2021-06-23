package no04.no0429;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
 

说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
    	
        
        List<Node> now = new ArrayList<>();
    	now.add(root);
    	List<Node> future = new ArrayList<>();
    	
    	List<List<Integer>> res = new ArrayList<>();
        
        if(root==null) {
    		return res;
    	}
        
    	List<Integer> temp = new ArrayList<>();
    	while(now.size()>0) {

    		for(Node node:now) {
    			temp.add(node.val);
    			future.addAll(node.children);

    		}
    		
    		res.add(temp);
    		temp = new ArrayList<>();
    		
    		now = future;
    		future = new ArrayList<>();
    		
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
