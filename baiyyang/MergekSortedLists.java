package baiyyang;

public class MergekSortedLists {
	
	 static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	 
	public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0)
        	return null;        
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
		ListNode current = lists[0];
		for(int i=1;i<lists.length;i++){
			ListNode p = lists[i];			
			while(current!=null && p != null){
				if(current.val > p.val){
					tail.next = p;
					tail = tail.next;
					p = p.next;
				}
				else {
					tail.next = current;
					tail = tail.next;
					current = current.next;
				}
			}
			if(p!=null)
				tail.next = p;
			if(current != null)
				tail.next = current;			
			current = ans.next;
			ans = new ListNode(0);
			tail = ans;
		}
		return current;
		
    }
	
	
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)
			return null;
		return partition(lists, 0, lists.length-1);
	}
	
	public static ListNode partition(ListNode[] nums, int start , int end){
		if(start < end){
			int mid = (start + end)/2;
			ListNode left = partition(nums , start , mid);
			ListNode right = partition(nums , mid+1 , end);
			return merge(left , right);
		} else {
			return nums[start];
		}			
	}
	
	public static ListNode merge(ListNode a , ListNode b){
		if(a==null){
			return b;
		} else if(b==null) {
			return a;
		}
		ListNode ans = null;
		if(a.val < b.val){
			ans = a;
			a = a.next;
		} else {
			ans = b;
			b = b.next;
		}
		ListNode p = ans;
		while(a != null && b != null){
			if(a.val < b.val){
				p.next = a;
				p = p.next;
				a = a.next;
			} else {
				p.next = b;
				p = p.next;
				b = b.next;
			}
		}
		if(a != null)
			p.next = a;
		if(b != null)
			p.next = b;
		return ans;
	}
	
	public static void main(String[] args) {		
		ListNode[] a = new ListNode[3];
		a[0]=new ListNode(2);
		a[1]=new ListNode(-1);
		ListNode ans = mergeKLists(a);
		while(ans != null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

}
