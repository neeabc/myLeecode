package no0969;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。

返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。

 

示例 1：

输入：[3,2,4,1]
输出：[4,2,4,3]
解释：
我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
初始状态 A = [3, 2, 4, 1]
第一次翻转后 (k=4): A = [1, 4, 2, 3]
第二次翻转后 (k=2): A = [4, 1, 2, 3]
第三次翻转后 (k=4): A = [3, 2, 1, 4]
第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。 
示例 2：

输入：[1,2,3]
输出：[]
解释：
输入已经排序，因此不需要翻转任何内容。
请注意，其他可能的答案，如[3，3]，也将被接受。
 

提示：

1 <= A.length <= 100
A[i] 是 [1, 2, ..., A.length] 的排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pancake-sorting
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
	
	public List<Integer> res = new ArrayList<>();
    public List<Integer> pancakeSort(int[] A) {
		for(int i=A.length;i>0;i--) {
			
			//获取当前最大值的序号
			int index = getIndex(A,i);
			
			if(index!=0) {
				//将当前最大值翻转至最前面
				swap(A,index);
				
				//将当前最大值翻转至最后面
				swap(A,i);
			}
			
		}
		return res;
    }
    
    //根据序号对数组进行翻转,并记录翻转至结果,如果序号0,不做任何事
    public void swap(int[] A,int index) {
    	
		res.add(index);
		for(int i=0,j=index-1;i<j;i++,j--) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}

    }
    
    //返回范围内的最大值的索引,如果这个最大值在正确的位置,返回0 序号以一开始
    public int getIndex(int[] A,int maxLen) {
    	int max = Integer.MIN_VALUE;
    	int maxIndex = 0;
    	
    	for(int i=maxLen-1;i>=0;i--) {
    		if(A[i]>max) {
    			max = A[i];
    			maxIndex = i;
    		}
    	}

    	if(maxIndex+1==maxLen) {
    		return 0;
    	}else {
    		return maxIndex+1;
    	}
    }
}
