package queue;

public class Queue {
	Node first;
	Node last;
	int length;

	class Node {

		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public Queue(int value) {
		Node newNode = new Node(value);
		first = newNode;
		last = newNode;
		length = 1;
	}

	public void printQueue() {
		System.out.println("printing queue: ");
		Node temp = first;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}

	}

	public void getFirst() {
		System.out.println("first: " + first.value);
	}

	public void getLast() {
		System.out.println("last: " + last.value);
	}

	public void getLength() {
		System.out.println("length: " + length);
	}

	public void enQueue(int value) {
		Node newNode = new Node(value);
		Node temp = last;
		if (length == 0) {
			first = newNode;
			last = newNode;
		} else {
			temp.next = newNode;
			last = newNode;
		} // appends at last

	}
	
	public Node deQueue() {
		
		Node temp= first;
		if(length==0) {
			return null;
		}
		if(length==1) {
			first=null;
			last=null;
		}
        first=temp.next;
        temp=null;
		length--;
		return temp;
		
	}
	
	  public void makeEmpty() {
	        first = null;
	        last=null;
	        length = 0;
	    }

}
