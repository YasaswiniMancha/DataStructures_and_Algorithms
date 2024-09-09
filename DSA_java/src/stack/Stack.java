package stack;


public class Stack {

	int height;
	Node top;
	
	class Node{
		int value;
		Node next;
		
		Node(int value){
			this.value=value;
		}
		
	}
	
	public Stack(int value) {
		Node newNode =new Node(value);
		top=newNode;
		height=1;
	}

	public void getHeight() {
		System.out.println("Height: "+height);
	}


	public void getTop() {
		System.out.println("Top: "+top.value);
	}

	
	public void printStack() {
		System.out.println("printing stack:");
		Node temp=top;
		while(temp!=null) {
			System.out.println(temp.value);
			temp=temp.next;
		}
	}
	
	
	public void push(int value) {
		Node newNode=new Node(value);
		if(height==0) {
			top=newNode;
		} else {
		   newNode.next=top;
		   top=newNode;
		}
	}
	
	public Node pop() {
		Node temp=top;
        if(height==0) {
        	return null;
        } else {
        top=top.next;
        temp.next=null;
        }
        height--;
        return temp;
	}
	
	
	 public void makeEmpty() {
	        top = null;
	        height = 0;
	    } 
	
}
