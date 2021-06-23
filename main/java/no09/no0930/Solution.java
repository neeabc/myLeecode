package no09.no0930;

import java.util.ArrayList;
import java.util.List;

/**在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。

 

示例：

输入：A = [1,0,1,0,1], S = 2
输出：4
解释：
如下面黑体所示，有 4 个满足题目要求的子数组：
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
 

提示：

A.length <= 30000
0 <= S <= A.length
A[i] 为 0 或 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xiao
 *
 */
public class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
    	if(A==null||A.length==0) {
    		return 0;
    	}
        int len = A.length;
        
        //保存所有1的个数,1间隙中0的个数
        int oneCount = 0;
        
        List<Integer> zeroList = new ArrayList<>();
        int zeroSum = 0;
        for(int i=0;i<len;i++) {
        	if(A[i]==1) { //数字为1
        		zeroList.add(zeroSum);
        		zeroSum = 0;
        		
        		oneCount++;
        	}else{ //数字为0
        		zeroSum++;
        	}
        }
        zeroList.add(zeroSum);
        
        if(oneCount==0) { //全零数组
        	if(S==0) { //求的和为0
        		return (len+1)*len/2;
        	}else {
        		return 0;
        	}
        }else { //非全零数组
        	if(S==0) { //求的和为0
        		int sum = 0;
        		for(int i=0;i<zeroList.size();i++) {
        			int count = zeroList.get(i);
        			sum += (count+1)*count/2;
        		}
        		return sum;
        	}else {
        		if(oneCount<S) { //1的数量不够
        			return 0;
        		}else {
        			int sum = 0;
        			for(int i=0,j=S-1;j<oneCount;i++,j++) {
        				int head = zeroList.get(i);
        				int tail = zeroList.get(j+1);
        				sum += (head+1)*(tail+1);
        			}
        			return sum;
        		}
        	}
        }
    }
}
