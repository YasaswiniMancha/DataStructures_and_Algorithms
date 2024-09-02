package doublylinkedlist;

public class DoublyLinkedList {
	
	int length;
	Node head;
	Node tail;
	
	class Node{
		
		Node prev;
		Node next; 
		int value;
		
		Node(int value){
			this.value=value;
		}
		
	}
	
	public DoublyLinkedList(int value) {
		Node newNode= new Node(value);
		head=newNode;
		tail=newNode;
		length=1;
	}


	
	
	
	public void printDList() { //without temp
		Node temp= head;
		while(temp!=null) {
			System.out.println(temp.value);
			temp= temp.next;
		}
	}
	
	

    public void appendAtLast(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail; 
            tail = newNode;
        }
        length++;
    }

    public void appendAtLast1(int value) { //with temp
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = tail;
            temp.next = newNode;
            newNode.prev = temp; 
            tail = newNode;
        }
        length++;
    }

    
    public Node removeLast() {
    	Node temp = tail;
        if(length == 0) {
            return null;  // No element to remove
        }
        if(length == 1) {
            head = null;
            tail = null;  // List becomes empty
        }
        else {
            tail = tail.prev;
            tail.next = null;  
            temp.prev = null;
        }
        
        if(length==0) {
        	head=null;
        	tail=null;
        }
        
        length--;
        return temp;
    }
    
    public void prepend(int value) {  //ex:     null<=1=>null    null<=2<=>3<=>4<=>5=>null         head=2
    	Node newNode=new Node(value);
    	Node temp=head;   //2
    	if(length==0) {
    		head=newNode;
    		tail=newNode;
    	}else {
    		newNode.next=temp;  //2
    		head.prev=newNode;  //1
    		head=newNode;       //1
    	}
    	length++;
    }

	
	public int getLength() {
		return length;
	}

	
	public Node getHead() {
		return head;
	}

	
	public Node getTail() {
		return tail;
	}


}
