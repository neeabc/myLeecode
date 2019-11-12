package no0846;

import java.util.Arrays;

/**
爱丽丝有一手（hand）由整数数组给定的牌。 

现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。

如果她可以完成分组就返回 true，否则返回 false。

 

示例 1：

输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
输出：true
解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
示例 2：

输入：hand = [1,2,3,4,5], W = 4
输出：false
解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 

提示：

1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hand-of-straights
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length%W==0) {
        	if(W==1)return true;

        	//进行排序排序
        	Arrays.sort(hand);
        	
        	int start = 0;
        	for(int i=0;i<hand.length/W;i ++) { //分段删除
        		int temp = check(hand,start, W);
        		if(temp==-1) {
        			return false;
        		}else {
        			start = temp;
        		}
        	}
        	return true;
        	
        }else { //不能被整除
        	return false;
        }
    }
    
    public int check(int[] hand,int start,int len) { //-1 删除失败 	 int 下一次开始删除的位置 
    	
    	int base = hand[start];
    	int next = -1;
    	int i=base;
    	int j=start;
    	for(;i<base+len&&j<hand.length;) {
    		if(i==hand[j]) {
    			hand[j]=-1;
    			i++;
    			j++;
    		}else if(hand[j]==-1){
    			j++;
    		}else {
    			if(next==-1) {
    				next=j;
    			}
    			j++;
    		}
    	}
    	
    	if(i==base+len){
    		if(next==-1) {
    			return j;
    		}
    		return next;
    	}else {
    		return -1;
    	}

    }
}
