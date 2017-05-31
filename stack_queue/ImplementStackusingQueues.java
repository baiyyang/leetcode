package stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ImplementStackusingQueues {
	
	/*private List<Integer> list;
	
	*//** Initialize your data structure here. *//*
    public ImplementStackusingQueues() {
        list = new ArrayList<Integer>();
    }
    
    *//** Push element x onto stack. *//*
    public void push(int x) {
        list.add(x);
    }
    
    *//** Removes the element on top of the stack and returns that element. *//*
    public int pop() {
        int ans = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return ans;
    }
    
    *//** Get the top element. *//*
    public int top() {
    	int ans = list.get(list.size() - 1);
        return ans;
    }
    
    *//** Returns whether the stack is empty. *//*
    public boolean empty() {
        if(list.isEmpty())
        	return true;
        else
        	return false;
    }*/
	
	Queue<Integer> queue;
    
    public ImplementStackusingQueues()
    {
        this.queue=new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) 
    {
       queue.add(x);
       for(int i=0;i<queue.size()-1;i++)
       {
           queue.add(queue.poll());
       }
    }

    // Removes the element on top of the stack.
    public void pop() 
    {
        queue.poll();
    }

    // Get the top element.
    public int top() 
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() 
    {
        return queue.isEmpty();
    }
    
    public static void main(String[] args) {
		ImplementStackusingQueues queues = new ImplementStackusingQueues();
		queues.push(1);
		queues.push(2);
		System.out.println(queues.top());
	}
}
