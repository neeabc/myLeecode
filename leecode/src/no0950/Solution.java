package no0950;
/**
牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。

最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。

现在，重复执行以下步骤，直到显示所有卡牌为止：

从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
返回能以递增顺序显示卡牌的牌组顺序。

答案中的第一张牌被认为处于牌堆顶部。

 

示例：

输入：[17,13,11,2,3,5,7]
输出：[2,13,3,11,5,17,7]
解释：
我们得到的牌组顺序为 [17,13,11,2,3,5,7]（这个顺序不重要），然后将其重新排序。
重新排序后，牌组以 [2,13,3,11,5,17,7] 开始，其中 2 位于牌组的顶部。
我们显示 2，然后将 13 移到底部。牌组现在是 [3,11,5,17,7,13]。
我们显示 3，并将 11 移到底部。牌组现在是 [5,17,7,13,11]。
我们显示 5，然后将 17 移到底部。牌组现在是 [7,13,11,17]。
我们显示 7，并将 13 移到底部。牌组现在是 [11,17,13]。
我们显示 11，然后将 17 移到底部。牌组现在是 [13,17]。
我们展示 13，然后将 17 移到底部。牌组现在是 [17]。
我们显示 17。
由于所有卡片都是按递增顺序排列显示的，所以答案是正确的。
 

提示：

1 <= A.length <= 1000
1 <= A[i] <= 10^6
对于所有的 i != j，A[i] != A[j]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reveal-cards-in-increasing-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
    	
    	mySort(deck,0,deck.length-1);
    	
    	int[] result = new int[deck.length];
    	
    	int a = 1;
    	int count = 0;
    	
    	result[0] = deck[0];
    	
    	for(int i=1;a<deck.length-1;) {
    		if(result[i]==0) {
    			count++;
    		}
    		
    		if(count==2) {
    			result[i] = deck[a];
    			a++;
    			count = 0;
    		}
    		
    		i++;
    		if(i==deck.length)i=0;
    	}
    	
    	for(int i=0;i<deck.length;i++) {
    		if(result[i]==0) {
    			result[i]=deck[a];
    			break;
    		}
    	}
    	
		return result;
        
    }
    
    //合并排序
    public void mySort(int[] deck,int start,int end) {
    	if(start==end) {
    		return;
    	}
    	
    	int middle = start+(end-start)/2;
    	mySort(deck,start,middle);
    	mySort(deck,middle+1,end);
    	
    	int a = start;
    	int b = middle+1;
    	int[] temp = new int[end+1-start];
    	
    	//合并
    	int i = 0;
    	for(;i<end+1-start&&a<=middle&&b<=end;i++) {
    		if(deck[a]>deck[b]) {
    			temp[i] = deck[b];
    			b++;
    		}else {
    			temp[i] = deck[a];
    			a++;
    		}
    	}
    	
    	while(a<=middle) {
			temp[i] = deck[a];
			i++;
			a++;
    	}
    	
    	while(b<=end) {
			temp[i] = deck[b];
			i++;
			b++;
    	}
    	//复制
    	i = start;
    	int j = 0;
    	for(;i<=end;i++,j++) {
    		deck[i] = temp[j];
    	}
    	
    }

	
}
