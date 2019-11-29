package no0092;

import org.junit.jupiter.api.Test;

public class Test0092 {
	@Test
	public void startTest() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		int m=1;
		int n=4;
		
		Solution so = new Solution();
		so.reverseBetween(a, m, n);

	}
}
