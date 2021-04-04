package dcp.DCP26;

public class DCP26 {

  public ListNode removeElements(ListNode head, int k) {
      ListNode slow=head; ListNode dummy=slow; 
      ListNode fast=head;int count=1;
      while(count!=k+1){
    	  if(fast.next != null){
    	     fast=fast.next; System.out.println(fast.val);
    	     count++;  
    	  }else{
    		  return null;
    	  }
      }
      while(fast.next!=null){
    	  slow=slow.next;
    	  fast=fast.next;
    	}
       slow.next=slow.next.next;
         return dummy;
    }
	
	public static void main(String[] args) {
		DCP26 dcp26=new DCP26();
		ListNode head=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node6=new ListNode(6);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		head.next=node2;
		node2.next=node6;
		node6.next=node3;
		node3.next=node4;
		node4.next=node5;
         ListNode ln=dcp26.removeElements(head, 3);
         while(ln.next!=null){
         	
        	  System.out.println("---"+ln.val);
        	  ln=ln.next;
         }
         System.out.println("---"+ln.val);
	}

}
class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
