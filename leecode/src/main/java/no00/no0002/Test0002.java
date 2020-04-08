package no00.no0002;

import org.junit.Test;

public class Test0002 {
    @Test
    public void test01(){
        Solution so = new Solution();

        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(9);
        ListNode m4 = new ListNode(9);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        ListNode listNode = so.addTwoNumbers(n1, m1);
    }
}
