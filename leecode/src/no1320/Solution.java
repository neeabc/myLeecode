package no1320;


/**
 * 
二指输入法定制键盘在 XY 平面上的布局如上图所示，其中每个大写英文字母都位于某个坐标处，例如字母 A 位于坐标 (0,0)，字母 B 位于坐标 (0,1)，字母 P 位于坐标 (2,3) 且字母 Z 位于坐标 (4,1)。

给你一个待输入字符串 word，请你计算并返回在仅使用两根手指的情况下，键入该字符串需要的最小移动总距离。坐标 (x1,y1) 和 (x2,y2) 之间的距离是 |x1 - x2| + |y1 - y2|。 

注意，两根手指的起始位置是零代价的，不计入移动总距离。你的两根手指的起始位置也不必从首字母或者前两个字母开始。


示例 1：

输入：word = "CAKE"
输出：3
解释： 
使用两根手指输入 "CAKE" 的最佳方案之一是： 
手指 1 在字母 'C' 上 -> 移动距离 = 0 
手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'C' 到字母 'A' 的距离 = 2 
手指 2 在字母 'K' 上 -> 移动距离 = 0 
手指 2 在字母 'E' 上 -> 移动距离 = 从字母 'K' 到字母 'E' 的距离  = 1 
总距离 = 3
示例 2：

输入：word = "HAPPY"
输出：6
解释： 
使用两根手指输入 "HAPPY" 的最佳方案之一是：
手指 1 在字母 'H' 上 -> 移动距离 = 0
手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'H' 到字母 'A' 的距离 = 2
手指 2 在字母 'P' 上 -> 移动距离 = 0
手指 2 在字母 'P' 上 -> 移动距离 = 从字母 'P' 到字母 'P' 的距离 = 0
手指 1 在字母 'Y' 上 -> 移动距离 = 从字母 'A' 到字母 'Y' 的距离 = 4
总距离 = 6
示例 3：

输入：word = "NEW"
输出：3
示例 4：

输入：word = "YEAR"
输出：7
 

提示：

2 <= word.length <= 300
每个 word[i] 都是一个大写英文字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-distance-to-type-a-word-using-two-fingers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xiao
 *
 */
public class Solution {
	int[][] places = new int[26][];
	{
		places['A'-'A'] = new int[]{0,0};
		places['B'-'A'] = new int[]{0,1};
		places['C'-'A'] = new int[]{0,2};
		places['D'-'A'] = new int[]{0,3};
		places['E'-'A'] = new int[]{0,4};
		places['F'-'A'] = new int[]{0,5};
		places['G'-'A'] = new int[]{1,0};
		places['H'-'A'] = new int[]{1,1};
		places['I'-'A'] = new int[]{1,2};
		places['J'-'A'] = new int[]{1,3};
		places['K'-'A'] = new int[]{1,4};
		places['L'-'A'] = new int[]{1,5};
		places['M'-'A'] = new int[]{2,0};
		places['N'-'A'] = new int[]{2,1};
		places['O'-'A'] = new int[]{2,2};
		places['P'-'A'] = new int[]{2,3};
		places['Q'-'A'] = new int[]{2,4};
		places['R'-'A'] = new int[]{2,5};
		places['S'-'A'] = new int[]{3,0};
		places['T'-'A'] = new int[]{3,1};
		places['U'-'A'] = new int[]{3,2};
		places['V'-'A'] = new int[]{3,3};
		places['W'-'A'] = new int[]{3,4};
		places['X'-'A'] = new int[]{3,5};
		places['Y'-'A'] = new int[]{4,0};
		places['Z'-'A'] = new int[]{4,1};
	}
	
    public int minimumDistance(String word) {
    	int len = word.length();
    	if(len<3) {
    		return 0;
    	}
    	
    	//将字符串转换成坐标
    	int[][] wordPoint = new int[len][];
    	for(int i=0;i<len;i++) {
    		wordPoint[i] = places[word.charAt(i)-'A'];
    	}
    	
    	//当有一个手指时,填表
    	int[] oneFinger = new int[len];
    	for(int i=1;i<len;i++) {
    		oneFinger[i] += oneFinger[i-1] + pointLen(wordPoint[i], wordPoint[i-1]);
    	}
    	
    	//当有两个手指时,填表
    	int[][] spend = new int[len][len];
    	
    	for(int y=word.length()-2;y>=0;y--) {
    		int x = y-1;
    		for(;x>=0;x--) {
    			
    			//第一种情况,x移动
    			int statusA = pointLen(wordPoint[x], wordPoint[y+1])+spend[y][y+1];
    			//第二种情况,y移动
    			int statusB = pointLen(wordPoint[y], wordPoint[y+1])+spend[x][y+1];
    			spend[x][y] = Math.min(statusA, statusB);
    		}
    	}
    	
    	//找到最小
    	int min = Integer.MAX_VALUE;
    	for(int i=1;i<len;i++) {
    		min = Math.min(min, spend[i-1][i]+oneFinger[i-1]);
    	}
    	
    	return min;
    }

	public int pointLen(int[] a,int[] b) {
		return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
	}
}
