package stack_queue;

import java.util.Stack;

public class MinStackWithTwoStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	/** initialize your data structure here. */
    public MinStackWithTwoStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	if(minStack.isEmpty())
    		minStack.push(x);
    	else if (minStack.peek() >= x) {
			minStack.push(x);
		}
    }
    
    public void pop() {
    	int current = stack.pop();
    	if(current == minStack.peek())
    		minStack.pop();
    	
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {        
        return minStack.peek();
    }
}
