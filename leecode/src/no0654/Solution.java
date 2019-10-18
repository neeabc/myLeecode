package no0654;
/**
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。

 

示例 ：

输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
 

提示：

给定的数组的大小在 [1, 1000] 之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode head;
		TreeNode nowPoint;
		TreeNode temp;
		
		TreeNode a;
		TreeNode b;
		
		head = nowPoint = new TreeNode(nums[0]);
		
		for(int i=1;i<nums.length;i++) {
			//新建节点
			temp = new TreeNode(nums[i]);
			
			//判断插入
			//大于当前最大值
			if(nums[i]>head.val) {
				temp.left = head;
				head = nowPoint = temp;
				
			//大于最新值 小于最大值
			}else if(nums[i]>nowPoint.val){
				a = head;
				b = head.right;
				while(b.val>nums[i]) {
					if(b.right!=null) {
						a = b;
						b = b.right;
					}else {
						a = b;
						b = b.left;
					}
				}
				
				if(a.right==b) {
					a.right = temp;
					temp.left = b;
				}else {
					a.right = temp;
				}
				
				nowPoint = temp;
				
			}else {
				nowPoint.right = temp;
				nowPoint = temp;
			}
			
			
			
		}
		
    	return head;
        
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
