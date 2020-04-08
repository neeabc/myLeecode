package no00.no0092;
/**
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Administrator
 *
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode resNode = new ListNode(0);
        resNode.next = head;
        ListNode s = resNode;
        ListNode tail = head;
        
        int count = 1;
        while(count < m) {
        	s=tail;
        	tail=tail.next;
        	count++;
        }
        ListNode temp1;
        ListNode temp2;
        temp1 = tail.next;
        while(count < n) {
        	temp2=temp1.next;//备份
        	temp1.next = s.next;
        	s.next = temp1;
        	temp1=temp2;
        	count++;
        }
        tail.next=temp1;
        return resNode.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}