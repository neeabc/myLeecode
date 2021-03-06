package no12.no1243;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 首先，给你一个初始数组 arr。然后，每天你都要根据前一天的数组生成一个新的数组。

第 i 天所生成的数组，是由你对第 i-1 天的数组进行如下操作所得的：

假如一个元素小于它的左右邻居，那么该元素自增 1。
假如一个元素大于它的左右邻居，那么该元素自减 1。
首、尾元素 永不 改变。
过些时日，你会发现数组将会不再发生变化，请返回最终所得到的数组。

 

示例 1：

输入：[6,2,3,4]
输出：[6,3,3,4]
解释：
第一天，数组从 [6,2,3,4] 变为 [6,3,3,4]。
无法再对该数组进行更多操作。
示例 2：

输入：[1,6,3,4,3,5]
输出：[1,4,4,4,4,5]
解释：
第一天，数组从 [1,6,3,4,3,5] 变为 [1,5,4,3,4,5]。
第二天，数组从 [1,5,4,3,4,5] 变为 [1,4,4,4,4,5]。
无法再对该数组进行更多操作。
 

提示：

1 <= arr.length <= 100
1 <= arr[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/array-transformation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public List<Integer> transformArray(int[] arr) {
        int[] copy = arr.clone();
        
        for(int i=1;i<arr.length-1;i++) {
        	if(arr[i]<copy[i-1]&&arr[i]<copy[i+1]) {
        		arr[i]++;
        	}else if(arr[i]>copy[i-1]&&arr[i]>copy[i+1]) {
        		arr[i]--;
        	}
        }
        
        
        
        while(!(Arrays.equals(arr, copy))) {
        	copy = arr.clone();
        	for(int i=1;i<arr.length-1;i++) {
            	if(arr[i]<copy[i-1]&&arr[i]<copy[i+1]) {
            		arr[i]++;
            	}else if(arr[i]>copy[i-1]&&arr[i]>copy[i+1]) {
            		arr[i]--;
            	}
            }
        }
        
        LinkedList<Integer> res = new LinkedList<>();
        for(int num:arr) {
        	res.addLast(num);
        }
        return res;
    }
}
