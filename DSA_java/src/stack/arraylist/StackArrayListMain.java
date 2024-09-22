package stack.arraylist;

import java.util.Stack;

public class StackArrayListMain {

	public static String reverseString(String string) {
		Stack<Character> stack = new Stack<>();

		String reversedString = "";
		System.out.println("before reverse: " + string);

		for (char c : string.toCharArray()) {
			stack.push(c);
		}

		while (!stack.isEmpty()) {
			reversedString += stack.pop();
		}
		System.out.println("after reverse: " + reversedString);

		return reversedString;
	}

	public static void sortStack(StackArrayList<Integer> stack) {
		StackArrayList<Integer> additionalStack = new StackArrayList<>();

		while (!stack.isEmpty()) {
			int temp = stack.pop();

			while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
				stack.push(additionalStack.pop());
			}

			additionalStack.push(temp);
		}

		while (!additionalStack.isEmpty()) {
			stack.push(additionalStack.pop());
		}
	}

	public static void main(String[] args) {

		StackArrayList myStack = new StackArrayList();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);

		System.out.println("Stack before pop():");
		myStack.printStack();

		System.out.println("\nPopped node:");
		System.out.println(myStack.pop());

		System.out.println("\nStack after pop():");
		myStack.printStack();
		System.out.println("\n");
		System.out.println("-----------------------------------------------------");

		String myString = "hello";
		reverseString(myString);

		System.out.println("\n");
		System.out.println("-----------------------------------------------------");

		StackArrayList<Integer> sortingStack = new StackArrayList<>();
		sortingStack.push(3);
		sortingStack.push(1);
		sortingStack.push(4);
		sortingStack.push(2);

		System.out.println("Before sorting:");
		sortingStack.printStack();

		sortStack(sortingStack);

		System.out.println("\nAfter sorting:");
		sortingStack.printStack();

	}

}