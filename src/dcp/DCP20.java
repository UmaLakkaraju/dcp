package dcp;

import java.util.HashSet;
import java.util.Set;

public class DCP20 {
	 
	
	   
	public static void main(String[] args) {
		  Set<ListNode> nodesInB = new HashSet<ListNode>();
		  ListNode headB=new ListNode(3);
		  headB.next=new ListNode(6);
		  headB.next.next=new ListNode(9);
		  headB.next.next.next=new ListNode(15);
		  headB.next.next.next.next=new ListNode(30);
		  ListNode headA=new ListNode(10);
		  headA.next=new ListNode(15);
		  headA.next.next=new ListNode(30);
	        while (headB != null) {
	        	System.out.println(headB.val);
	            nodesInB.add(headB);
	            headB = headB.next;
	        }

	        while (headA != null) {
	        	System.out.println("----"+headA.val);
	            if (nodesInB.contains(headA)) {
	               System.out.println(headA.val);
	            }
	            headA = headA.next;
	        }

	       
	    }
       
        

}
class ListNode {
    int val;
    ListNode next;
   ListNode(int x) {
        val = x;
       next = null;
    }
}