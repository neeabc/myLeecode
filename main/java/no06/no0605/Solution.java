package no06.no0605;
/**
假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:

输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
示例 2:

输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
注意:

数组内已种好的花不会违反种植规则。
输入的数组长度范围为 [1, 20000]。
n 是非负整数，且不会超过输入数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/can-place-flowers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
    	
    	//数出开始的空位
    	int startCount = 0;
    	for(int i=0;i<flowerbed.length;i++) {
    		if(flowerbed[i]==0) {
    			startCount++;
    		}else {
    			break;
    		}
    	}
    	
    	//全为0
    	if(startCount==flowerbed.length) {
    		if(startCount%2==0) {
        		sum += startCount/2;
        	}else {
        		sum += (startCount+1)/2;
        	}
    		
    		if(sum>=n) {
    			return true;
    		}else {
    			return false;
    		}
    	}
    	
    	//计算开始可种花数
    	if(startCount%2==0) {
    		sum += startCount/2;
    	}else {
    		sum += (startCount-1)/2;
    	}
    	if(sum>=n)return true;
    	
    	
    	//数出结尾的空位
    	int endCount = 0;
    	for(int i=flowerbed.length-1;i>startCount;i--) {
    		if(flowerbed[i]==0) {
    			endCount++;
    		}else {
    			break;
    		}
    	}
    	//计算结尾可种花数
    	if(endCount%2==0) {
    		sum += endCount/2;
    	}else {
    		sum += (endCount-1)/2;
    	}
    	if(sum>=n)return true;
    	
    	
    	int a=startCount;
    	int b=startCount;
    	//遍历中间空位
    	int len;
    	for(int i=startCount;i<flowerbed.length-endCount;i++) {
    		if(flowerbed[i]==0) {
    			b++;
    		}else {
    			len = b-a;
    			if(len>0) {
    				if(len%2==0) {
    					sum += (len-2)/2;
    				}else {
    					sum += (len-1)/2;
    				}
    			}
    			if(sum>=n)return true;
    			a = i+1;
    			b = i+1;
    		}
    	}
    	
    	if(sum>=n) {
    		return true;
    	}else{
    		return false;
    	}
    }
}
