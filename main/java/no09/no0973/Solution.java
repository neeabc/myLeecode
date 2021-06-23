package no09.no0973;

/*
973. 最接近原点的 K 个点
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

 

示例 1：

输入：points = [[1,3],[-2,2]], K = 1
输出：[[-2,2]]
解释：
(1, 3) 和原点之间的距离为 sqrt(10)，
(-2, 2) 和原点之间的距离为 sqrt(8)，
由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
示例 2：

输入：points = [[3,3],[5,-1],[-2,4]], K = 2
输出：[[3,3],[-2,4]]
（答案 [[-2,4],[3,3]] 也会被接受。）
 

提示：

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class Solution {
    public int[][] kClosest(int[][] points, int K) {

        //将距离计算出来
        int[][] lens = new int[points.length][];
        for (int i = 0; i < points.length; i++) {
            int pointLen = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            lens[i] = new int[]{pointLen, i};
        }

        //将K个距离短的点移到前面
        moveK(lens, K);

        //new int,填入计算的值
        int[][] result = new int[K][];
        for (int i = 0; i < K; i++) {
            int i1 = lens[i][1];
            result[i] = points[i1];
        }

        return result;
    }

    private void moveK(int[][] lens, int k) {
        int start = 0;
        int end = lens.length;

        int mid = split(lens, start, end);
        while(true){
            if (k == mid || k == mid - 1){ //完成
                return;
            }
            if (k > mid){
                start = mid;
                mid = split(lens, start, end);
            }else{
                end = mid - 1;
                mid = split(lens, start, end);
            }
        }
    }

    //返回数字mid,将范围分成3部分,小于 等于 大于
    private int split(int[][] lens, int start, int end){
        int len = lens[start][0];
        int tStart = start;
        start++;
        while(start < end){
            if (lens[start][0] > len){
                swap(lens, start, end-1);
                end--;
            }else{
                start++;
            }
        }
        swap(lens, tStart, start-1);
        return start;
    }

    private void swap(int[][] lens, int a, int b){
        int[] temp = lens[a];
        lens[a] = lens[b];
        lens[b] = temp;
    }
}
