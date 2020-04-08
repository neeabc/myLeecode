package no11.no1122;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
 
提示：

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        
        int[] temp = new int[arr1.length];
        int count = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i:arr2) {
        	map.put(i, 0);
        }
        
        for(int i:arr1) {
        	if(map.containsKey(i)) {
        		map.replace(i, map.get(i)+1);
        	}else {
        		temp[count] = i;
        		count++;
        	}
        }
        
        int resCount = 0;
        for(int i:arr2) {
        	for(int j=0;j<map.get(i);j++) {
        		res[resCount] = i;
        		resCount++;
        	}
        }
        
        Arrays.sort(temp, 0, count);
        for(int i:temp) {
        	if(resCount<res.length) {
        		res[resCount] = i;
        		resCount++;
        	}else {
        		break;
        	}
        }
        
        return res;
    }
}
