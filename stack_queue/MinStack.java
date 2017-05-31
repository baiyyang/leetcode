package stack_queue;

import java.util.Stack;

public class MinStack {
	
	private Stack<Integer> stack;
	private int min = Integer.MAX_VALUE;

	/** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	if(min >= x){
    		stack.push(min);
    		min = x;
    	}
        stack.push(x);
    }
    
    public void pop() {
    	if(stack.pop() == min)
    		min = stack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {        
        return min;
    }
    
    public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}
