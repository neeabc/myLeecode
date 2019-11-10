package no1237;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。

给定函数是严格单调的，也就是说：

f(x, y) < f(x + 1, y)
f(x, y) < f(x, y + 1)
函数接口定义如下：

interface CustomFunction {
public:
  // Returns positive integer f(x, y) for any given positive integer x and y.
  int f(int x, int y);
};
如果你想自定义测试，你可以输入整数 function_id 和一个目标结果 z 作为输入，其中 function_id 表示一个隐藏函数列表中的一个函数编号，题目只会告诉你列表中的 2 个函数。  

你可以将满足条件的 结果数对 按任意顺序返回。

 

示例 1：

输入：function_id = 1, z = 5
输出：[[1,4],[2,3],[3,2],[4,1]]
解释：function_id = 1 表示 f(x, y) = x + y
示例 2：

输入：function_id = 2, z = 5
输出：[[1,5],[5,1]]
解释：function_id = 2 表示 f(x, y) = x * y
 

提示：

1 <= function_id <= 9
1 <= z <= 100
题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。
在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
	public LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
    	helper(customfunction, z, 1, 1001, 1, 1001);
		return res;
    }
    
    public void helper(CustomFunction customfunction, int z,int x1,int x2,int y1,int y2) {
    	if(x2>x1&&y2>y1) {
    		int midx = (x2+x1)/2;
    		int midy = (y2+y1)/2;
    		int temp = customfunction.f(midx, midy);

    		if(temp==z) {
    			//找到的点是正确的点
    			List<Integer> tempList = new ArrayList<Integer>();
    			tempList.add(midx);
    			tempList.add(midy);
    			res.addLast(tempList);
    			helper(customfunction, z, midx+1, x2, y1, midy);
    			helper(customfunction, z, x1, midx, midy+1, y2);
    		}else if(temp>z) {
    			helper(customfunction, z, x1, x2, y1, midy);
    			helper(customfunction, z, x1, midx, midy, y2);
    		}else {
    			helper(customfunction, z, x1, x2, midy+1, y2);
    			helper(customfunction, z, midx+1, x2, y1, midy+1);
    		}
    	}
    }
}

class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) {
    	return 0;
    };
};
