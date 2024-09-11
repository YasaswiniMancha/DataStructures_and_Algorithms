package stack.arraylist;

public class StackArrayListMain {
	
	   public static String reverseString(String string) {
		   
		    StackArrayList<Character> stackChar = new StackArrayList<>();
	        String reversedString = "";
	 
	        for (char c : string.toCharArray()) {
	            stackChar.push(c);
	        }
	        
	        while (!stackChar.isEmpty()) {
	            reversedString += stackChar.pop();
	        }
	 
	        return reversedString;
	    }
	
	   
	  
	
    public static void main(String args[]) {
    
        String myString = "hello";
        System.out.println("printing string after reverse: ");
        String reversedString = reverseString(myString);
        System.out.println(reversedString);
    
    	 StackArrayList<Integer> stackList = new StackArrayList<Integer>();
         
    	 stackList.push(1);
    	 stackList.push(2);
    	 stackList.push(3);
         
         System.out.println("printing stack using push in arraylist: ");
         stackList.printStack();
         
         System.out.println("printing stack using pop in arraylist: ");
         stackList.pop();
         stackList.pop();
         stackList.printStack();
    }
    
}
