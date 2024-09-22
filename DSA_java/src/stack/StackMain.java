package stack;

public class StackMain {
	
	
	
    public static void main(String args[]) {
    	
    	
    	
    	Stack st= new Stack(1);
    	st.printStack();
    	st.getHeight();
    	st.getTop();
    	
    	st.push(2);
    	st.push(3);
    	st.push(4);
    	System.out.println("After pushing elements: ");
    	st.printStack();
    	
    	st.pop();
    	System.out.println("After poping element: ");
    	st.printStack();
    }
}
