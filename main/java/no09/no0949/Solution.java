package no09.no0949;
/**
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。

最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。

以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。

 

示例 1：

输入：[1,2,3,4]
输出："23:41"

示例 2：

输入：[5,5,5,5]
输出：""

 

提示：

    A.length == 4
    0 <= A[i] <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-time-for-given-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public String largestTimeFromDigits(int[] A) {
        int max = -1;
    	String res="";
    	for(int i=0;i<4;i++) {
        	swap(A,0,i);
        	
        	for(int j=1;j<4;j++) {
        		swap(A,1,j);
        		
        		for(int k=2;k<4;k++) {
        			swap(A,2,k);
        			
        			int temp = count(A);
        			if(temp>max) {
        				res = ""+A[0]+A[1]+":"+A[2]+A[3];
        				max = temp;
        			}
        			
        			swap(A,2,k);
        		}
        		
        		swap(A,1,j);
        	}
        	
        	swap(A,0,i);
        }
    	return res;
    }
    
    public void swap(int[] A,int a,int b) {
    	if(a==b)return;
    	
    	int temp = A[a];
    	A[a] = A[b];
    	A[b] = temp;
    }
    
    public int count(int[] A) {
    	int hour = A[0]*10+A[1];
    	int min = A[2]*10+A[3];
    	if(hour<0||hour>23) {
    		return -1;
    	}
    	if(min<0||min>=60) {
    		return -1;
    	}
    	
		return hour*60+min;
    }
}
