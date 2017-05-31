package linked;

public class ReverseLinkedListII {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	 }
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
        	return null;
        int start = 1;
        int end = 1;
        ListNode h = null;
        ListNode sh = null;
        ListNode st = null;
        ListNode t = null;
        ListNode s = head;
        int flag = 0;
        while(s != null){     
        	if(flag == 0 && m == 1){
        		h = s;
        		sh = h;
        		flag = 1;
        	}
        	if(start == m-1){
        		h = s;        		
				sh = h.next;
				
        	}
        	if(end == n){
        		st = s;
        		t = st.next;
        	}
        	start ++;
        	end ++;
        	s= s.next;
        }
        if(sh == null)
        	return head;
        ListNode ans = null;
    	ans = sh;
    	ListNode q = ans.next;
    	ans.next = null;
    	while(q != null && q != t){
    		ListNode p = q.next;
    		q.next = ans;
    		ans = q;
    		q = p;
    	}
        if(h == sh){        	
        	sh.next = t;
        	return ans;
        }else {
        	h.next = ans;
        	sh.next = t;
			return head;
		}
        
    }
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		//b.next = c;
		//c.next = d;
		ListNode ans = reverseBetween(a, 1, 2);
		while(ans != null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}
