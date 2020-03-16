package algorithms.recursion;

/*Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 
Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.*/


public class SwapPairs {
	
	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairs(ListNode head) {
	    if ((head == null)||(head.next == null))
	        return head;
	    ListNode n = head.next;
	    head.next = swapPairs(head.next.next);
	    n.next = head;
	    return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		
		System.out.println(ln1.val + " -> " + ln1.next.val + " -> " + ln1.next.next.val + " -> " + ln1.next.next.next.val);
		
		SwapPairs s = new SwapPairs();
		s.swapPairs(ln1);
		
		System.out.println(ln2.val + " -> " + ln2.next.val  + " -> " + ln2.next.next.val + " -> "+ ln2.next.next.next.val);
		
	}

}


