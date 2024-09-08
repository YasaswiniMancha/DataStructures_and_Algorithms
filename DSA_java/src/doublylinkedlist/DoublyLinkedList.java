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

    public Node removeFirst() { //ex:     null<=1=><=>2<=>3<=>4<=>5=>null         head=1
    	
    	Node temp=head;//1
    	if(length==0) {
    		return null;
    	} 
    	if(length==1) {
    		head=null;
    		tail=null;
    	} else
    	head=head.next; //2
    	head.prev=null;
    	temp.next=null;
     
    	length--;
    	return temp;    //removed node 1
    }
	
    
    public Node get(int index) { //ex: null<=1=><=>2<=>3<=>4<=>5=>null         head=1 , index=3(assume)
    	if(index<0 || index>=length) {
    		return null;
    	}
    	Node temp=head;   //1
    	if(index  <  (length/2)) {     //  length/2= 5/2= 3 => cond false 
    	    for(int i=0;i<index;i++) {
    	      temp=temp.next;
    		}
    	} else {           // automatically it executes
    		temp=tail;      //5
    		for(int i= length-1;i>index ;i--) {  //i=5-1 ; 4>3; => true
    			temp=temp.prev;    //4
    		}
    	}
    	return temp; //4
    }
    
    
    public boolean set(int index, int value) {
    	Node temp=get(index);
    	if(temp!=null) {
    		temp.value=value;
    		return true;
    	}
    	return false;
    }
    
    
    public boolean insert(int index, int value) {
    	if(index<0 || index>length) {
    		return false;
    	} 
    	if(index==0) {
    		prepend(value);
    		
    	}
    	if(index==length) {
    		appendAtLast(value);
    		
    	}
    	
    	Node newNode=new Node(value);
    	Node before= get(index-1);
    	Node after=before.next;
    	newNode.prev=before;
    	newNode.next=after;
    	before.next=newNode;
    	after.prev=newNode;
    	length++;
    	return true;
    }
    
    
    public Node remove(int index) {   //  null<=1=><=>2<=>3<=>4<=>5=>null     remove(2) , head=1
    	if(index<0 || index>=length) {
    		return null;
    	} 
    	if(index==0) {
    		return removeFirst();
    	}
    	if(index==length-1) {
    		return removeLast();
    	}
    	
    	Node temp= get(index);      //3
    	temp.next.prev=temp.prev;   //2
    	temp.prev.next=temp.next;    //4
    	temp.next=null;   //null
    	temp.prev=null;    //null
    	length--;
    	return temp;      //   null<=1=><=>2<=>4<=>5=>null
    }
    
    public void removeWithIndex(int index) {
    	  if (index < 0 || index >= length) {
    	        System.out.println("Index out of bounds");
    	        return ;
    	    }

    	    if (index == 0) {
    	        removeFirst();
    	    } else if (index == length - 1) {
    	        removeLast();
    	    } else {
    	        Node current = head;
    	        for (int i = 0; i < index; i++) {
    	            current = current.next;
    	        }

    	        Node prevNode = current.prev;
    	        Node nextNode = current.next;

    	        prevNode.next = nextNode;
    	        nextNode.prev = prevNode;

    	        current.next = null;
    	        current.prev = null;
    	        
    	        length--;
    	    }
    	    
    	}
    
    
    
    public void swapFirstLast() {
        
        // If the list is empty or has only one element, do nothing.
        if (length <= 1) {
            return;
        }

        // Get the first and last nodes
        Node first = get(0);
        System.out.println("first: "+first.value);
        Node last = get(length - 1);
        System.out.println("last: "+last.value);
        
        

        // If for some reason either node is null (though it shouldn't be), do nothing.
        if (first == null || last == null) {
            return;
        }

        // If the first and last nodes are the same, no swap is needed.
        if (first == last) {
            return;
        }

        // Swap the first and last nodes' data (simple data swap)
        int tempValue = first.value;
        first.value = last.value;
        last.value = tempValue;
            
            
        }

    
    
    public void reverse(){ //1-2-3-4
        
        Node current=head; //1
        Node temp=null;
        
        while(current!=null){
            
            temp = current.prev;   //null //1  //2 
            current.prev=current.next;  //2   //3  //4
            current.next=temp;  //null //1 //2  
            current= current.prev; //2 //3  //4
        }
            temp = head;
            head=tail;
            tail=temp;
      }
    
    public boolean isPalindrome() {
        if(length<=1) return true;
        Node forwardNode=head;
        Node backwardNode=tail;
        for(int i=0;i<length/2;i++){
            if(forwardNode.value!=backwardNode.value){
                return false;
            }
            forwardNode=forwardNode.next;
            backwardNode=backwardNode.prev;
        }
        return true;
    }
    
    
    
    public void swapPairs(){
        if (head == null || head.next == null) {
          return;
           }
      Node temp=head;
      int tempData=head.value;
      while(temp!=null && temp.next!=null){
          tempData=temp.value;
          temp.value=temp.next.value;
          temp.next.value=tempData;
          temp=temp.next.next;
      }
     
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
