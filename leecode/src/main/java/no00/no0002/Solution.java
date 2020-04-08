package no00.no0002;

/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwo(l1,l2,0);
    }

    private ListNode addTwo(ListNode l1, ListNode l2, int i) {
        if (l1 == null && l2 == null && i == 0){
            return null;
        }else if (l1 == null){
            return addOne(l2,i);
        }else if (l2 == null){
            return addOne(l1,i);
        }

        int temp = l1.val + l2.val + i;
        i = temp/10;
        temp = temp%10;
        ListNode node = new ListNode(temp);
        node.next = addTwo(l1.next, l2.next, i);

        return node;
    }

    private ListNode addOne(ListNode l1, int i) {
        if (l1 == null && i == 0){
            return null;
        }else {
            int temp = i;
            ListNode next = null;
            if (l1 != null){
                temp += l1.val;
                next = l1.next;
            }

            i = temp/10;
            temp = temp%10;

            ListNode node = new ListNode(temp);
            node.next = addOne(next, i);
            return node;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
