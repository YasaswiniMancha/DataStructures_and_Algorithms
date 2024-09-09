package stack;

public class StackArrayListMain {
    public static void main(String args[]) {
    	
    	 StackArrayList<Integer> myStack = new StackArrayList<Integer>();
         
         myStack.push(1);
         myStack.push(2);
         myStack.push(3);
         
         System.out.println("printing stack using arraylist: ");
         myStack.printStack();
    }
}
