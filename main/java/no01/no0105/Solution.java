package no01.no0105;
/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    public TreeNode build(int[] preorder,int pstart,int pend,int[] inorder,int istart,int iend) {
		
    	if(pend-pstart==0) {
    		return null;
    	}
    	
    	if(pend-pstart==1) {
    		return new TreeNode(preorder[pstart]);
    	}
    	
    	int rootVal = preorder[pstart];
    	
		int position = 0;
		for(int i=istart;i<iend;i++) {
			if(inorder[i]==rootVal) {
				position = i;
				break;
			}
		}
		
		//inorder
		//左子树 [istart,position)
		//右子树 [position+1,iend)
		
		//preorder
		//左子树 [pstart+1,pstart+1+(position-istart))
		//右子树 [pstart+1+(position-istart),pend)
		
		TreeNode root = new TreeNode(rootVal);
		
		root.left = build(preorder, pstart+1, pstart+1+(position-istart), inorder, istart, position);
		root.right = build(preorder, pstart+1+(position-istart), pend, inorder, position+1, iend);
    	
    	return root;
    	
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
