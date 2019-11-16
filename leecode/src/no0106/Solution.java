package no0106;
/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	return build(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    
    public TreeNode build(int[] inorder,int istart,int iend,int[] postorder,int pstart,int pend) {
    	
    	//结束条件
    	if((iend-istart)==0) {
    		return null;
    	}
    	
    	if((iend-istart)==1) {
    		return new TreeNode(inorder[istart]);
    	}
    	
    	
    	int rootVal = postorder[pend-1]; //根节点的值
    	
    	int position=0;
    	for(int i=istart;i<iend;i++) {
    		if(rootVal==inorder[i]) {
    			position=i;
    			break;
    		}
    	}
    	
    	//数组inorder
    	//[istart,position) 左子树 
    	//[position+1,iend) 右子树
    	
    	//数组postorder
    	//[pstart,pstart+(position-istart)) 左子树
    	//[pstart+(position-istart),pend-1) 右子树
    	
    	TreeNode root = new TreeNode(rootVal);
    	root.left = build(inorder, istart, position, postorder, pstart, pstart+(position-istart));
    	root.right = build(inorder, position+1, iend, postorder, pstart+(position-istart), pend-1);
    	
		return root;
    	
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
