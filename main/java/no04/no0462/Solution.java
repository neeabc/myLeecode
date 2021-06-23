package no04.no0462;
/**
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。

例如:

输入:
[1,2,3]

输出:
2

说明：
只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）： 

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
	int[] nums;
	int mid;
    public int minMoves2(int[] nums) {
        this.nums=nums;
        this.mid = nums.length/2;
        helper(0,this.nums.length);
        
        int sum = 0;
        int leftSum = 0;
        for(int i=0;i<mid;i++) {
        	leftSum += this.nums[i];
        }
        sum += this.nums[mid]*mid-leftSum;
        
        
        int rightSum = 0;
        for(int i=mid+1;i<this.nums.length;i++) {
        	rightSum += this.nums[i];
        }
        sum += rightSum-this.nums[mid]*(this.nums.length-mid-1);
        
        return sum;
        
    }
    
    //寻找中间值,并快速排序
    public void helper(int start,int end) {
    	//挑选值,并替换至开始    (随机化)
    	swap(start,(end+start)/2);
    	int select = nums[start];
    	
    	
    	//比值大的放在结尾,比值小的放在中间,等于值的放在开始
    	int i=start+1; //指向比值小的;
    	int j=end-1; //指向比值大的;
    	int k=start+1; //指向等于值的;
    	int temp;
    	while(i<=j) {
    		temp=nums[i];
    		
    		if(temp==select) { //相等
    			swap(k, i);
    			k++;
    			if(i<k) {
    				i=k;
    			}
    		}else if(temp<select) { //小于
    			i++;
    		}else { //大于
    			swap(j, i);
    			j--;
    		}
    	}
    	
    	//将挑选的值换回去
    	for(int m=start,n=i-1;m<k;m++,n--) {
    		swap(m, n);
    	}
    	
    	//数组分成了三个部分
    	int x = start-k+i;
    	//start-x 小于
    	//x-i 等于
    	//i-end 大于
    	if(mid<x) {
    		helper(start, x);
    	}else if(mid<i) {
    		return;
    	}else {
    		helper(i, end);
    	}
    	
    }
    
    public void swap(int a,int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}
