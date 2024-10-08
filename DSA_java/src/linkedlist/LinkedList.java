package linkedlist;

import java.util.HashSet;

public class LinkedList {
     
	 Node head;
	 Node tail;
	private int length;
	
	class Node{
		
		int value; //Stores the value of the node.
		Node next;  //A reference to the next node in the list. If this is the last node, next will be null.
		
		Node(int value){
			this.value=value;  //Constructor Initializes the value of the node when it is created.
		}
	}
	
	//The Node class is an inner-class or sub-class of LinkedList that represents the individual elements (nodes) of the linked list.
	
	
	public LinkedList(int value) {
		Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1; 
	}
	//This constructor initializes the linked list with a single node.
	//A new Node object is created with the given value.3
	//Both head and tail attributes are set to this new node since it's the only node in the list.
	//The length is set to 1, reflecting that there is one node in the list.
	
	
	
	public void printList() {
		Node temp= head;
		while(temp!=null) {
			System.out.println(temp.value);
			temp=temp.next;
		}
	}
	//This method traverses the entire linked list and prints the value of each node.
	//A temporary node temp is initialized to point to the head.
	//The method enters a loop that continues until temp is null (indicating the end of the list).
	//Inside the loop, it prints the value of the current node (temp.value).
	//temp is then updated to point to the next node (temp.next).
	//When temp becomes null, the loop ends, and all the node values have been printed.
	
	
	 public void printAll() {
	        if (length == 0) {
	            System.out.println("Head: null");
	            System.out.println("Tail: null");
	        } else {
	            System.out.println("Head: " + head.value);
	            System.out.println("Tail: " + tail.value);
	        }
	        System.out.println("Length:" + length);
	        System.out.println("\nLinked List:");
	        if (length == 0) {
	            System.out.println("empty");
	        } else {
	            printList();
	        }
	    }
	 //This method provides a summary of the linked list by printing the head, tail, and length attributes, followed by the values of all the nodes in the list.
	 //If the list is empty, it prints "Head: null" and "Tail: null" since there are no nodes in the list.
	 //If the list is not empty, it prints the value of the head and tail nodes.
	 //The current length of the list is printed.
	 //The method checks if the list is empty again:
	// If empty, it prints "empty".
	 //If not empty, it calls the printList() method to print all the values in the list.
	 
	
	
	
	
	
	
	public Node getHead() {
		System.out.println("Head: "+ head.value);
		return head;
	}
    public Node getTail() {
    	System.out.println("Tail: "+ tail.value);
    	return tail;
	}
	public int getLength() {
		System.out.println("Length: "+ length);
		return length;
	}
	
	
	
	public void append(int value) {
		Node newNode = new Node(value);
		if(length==0) {
			head= newNode;
			tail=newNode;
		} else {
			tail.next=newNode;
			tail=newNode;
		}
		length++;
	}
	//The append method adds a new node with the specified value to the end of the linked list.
	//A new node is created using the provided value. This node's next reference is null because it's being added to the end of the list.
	//If the list is empty (length is 0), both head and tail are set to this new node because it's the only node in the list.
	//If the list is not empty, the next pointer of the current tail node is set to the new node.
	//The tail is then updated to point to this new node, making it the last node in the list.
	//The length of the list is increased by 1 to reflect the addition of the new node.
	
	
	
	public Node removeLast() {		
		if(length ==0) {
			return null;
		}
		
		Node temp = head;
		Node pre = head;
		while(temp.next!=null) {
			pre=temp;
			temp=temp.next;
		}
		
		tail = pre;
		tail.next=null;
		
		length--;
		
		if(length==0) {
			head=null;
			tail=null;
		}
		return temp;
	}
	//If the linked list is empty, the method returns null, as there's no node to remove.
	//temp is used to traverse the list.
	//pre is used to keep track of the node just before temp (i.e., the second-last node).
    //A while loop runs as long as temp.next is not null. This means temp keeps moving to the next node until it reaches the last node.
	//pre follows temp, so when temp is at the last node, pre is at the second-to-last node.
	//A while loop runs as long as temp.next is not null. This loop will stop when temp points to the last node in the list.
	//Inside the loop, pre is updated to the current temp, and temp is moved to the next node (temp = temp.next).
	//After the loop, temp points to the last node, and pre points to the second-to-last node.
	//The tail is updated to point to pre, which is now the new last node in the list.
	//The next pointer of the new tail is set to null to break the link to the removed node.
	//The length of the list is decremented by 1.
	//If the list had only one node before the removal, it becomes empty after this operation.In this case, both head and tail are set to null.
	//The method returns the node that was removed (temp).
	
	
	
	public void prepend(int value) {
		Node newNode= new Node(value);
		if(length==0) {
			head=newNode;
			tail=newNode;
		} else {
			newNode.next=head;
			head= newNode;
		}
		length++;
	}
	//The prepend method adds a new node with the given value to the beginning of the linked list.
	//A new Node(newNode) is created using the provided value. This node will be added to the beginning of the list.
    //If the linked list is empty, both head and tail are set to this newNode. Since it's the only node in the list, it serves as both the first and last node.
	//If the list is not empty, the next pointer of the newNode is set to the current head node.
	//The head is then updated to point to this new node, making it the first node in the list.
	//The length of the linked list is incremented by 1, reflecting the addition of a new node.
	
	
	public Node removeFirst() {
		if(length==0) {
			return null;
		}
		
		Node temp=head;
		head=head.next;
		temp.next=null;
		length--;
		if(length==0) {
			tail=null;
		}
		return temp;	
	}
	//If the linked list is empty, the method returns null immediately since there's nothing to remove.
	//A temporary node temp is created to store the current head node. This node will be returned after it is removed from the list.
	//The head is updated to point to the next node in the list (head.next), effectively removing the first node from the linked list.
	//The next pointer of temp (the removed node) is set to null to completely detach it from the list.
	//The length of the linked list is decremented by 1.
	//If the list had only one node before the removal, it becomes empty after this operation.
	//In this case, the tail is also set to null.
	//The method returns the node that was removed (temp).
	
	
	public Node get(int index) {
		if(index<0 || index>=length) {
			return null;
		}
		Node temp= head;
		for(int i=0; i<index; i++) {
			temp =temp.next;
		}
		return temp;
	}
	//The get method retrieves the node at a specified index in the linked list.
	//If the provided index is out of bounds (less than 0 or greater than or equal to the length of the list), the method returns null, indicating that the index is invalid.
	//A temporary node temp is created and initialized to the head of the list. This node will be used to traverse the list to find the node at the specified index.
	//A for loop runs from 0 to index - 1, moving the temp node to the next node in the list at each iteration (temp = temp.next).
	//After the loop, temp will point to the node at the specified index.
	//The method returns the temp node, which now points to the node at the specified index.
	
	
	
	public boolean set(int index, int value) {
		Node temp= get(index);
		if(temp!=null) {
			temp.value=value;
			return true;
		}
		return false;
	}
	//The set method updates the value of the node at the specified index with a new value.
	//The get method is called to retrieve the node at the specified index. This node is stored in the temp variable.
	//If the node at the specified index exists (i.e., temp is not null), the method proceeds to update its value.
	//If the node does not exist (i.e., temp is null), the method returns false, indicating that the operation failed.
	//If the node exists, its value is updated to the new value provided as a parameter.
    //The method returns true, indicating that the node's value was successfully updated.
	
	
	
	
	public boolean insert(int index, int value) {
		if(index<0 || index>length)
			return false;
		if(index==0) {
			prepend(value);
			return true;
		}
		
		if(index==length) {
			append(value);
			return true;
		}
		
		Node newNode= new Node(value);
		Node temp= get(index-1);
		newNode.next= temp.next;
		temp.next=newNode;
		length++;
		return true;
	}
	//The insert method inserts a new node with the given value at the specified index in the linked list.
	//If the index is out of bounds (less than 0 or greater than the length of the list), the method returns false, indicating that the insertion failed.
	//If the index is 0, the method calls the prepend method to add the new node at the beginning of the list.
	//After prepending, the method returns true to indicate success.
	//If the index is equal to the current length of the list, the method calls the append method to add the new node at the end of the list.
	//After appending, the method returns true to indicate success.
	//For any other valid index, the method first creates a new Node with the given value.
	//The method then retrieves the node that is currently at the position just before the specified index using the get(index - 1) method. This node is stored in the temp variable.
	//The next pointer of the new node is set to the next node of temp, linking the new node to the rest of the list.
	//The next pointer of temp is then updated to point to the new node, effectively inserting it at the desired position.
	//The length of the linked list is incremented by 1, reflecting the addition of the new node.
	//The method returns true, indicating that the insertion was successful.
	
	
	public Node remove(int index) {
		if(index<0 || index>= length)
			return null;
		if(index==0)
			return removeFirst();
		if(index==length-1)
			return removeLast();
		
		Node prev= get(index-1);
		Node temp= prev.next;
		
		prev.next= temp.next;
		temp.next=null;
		length--;
		return temp;
	}
	//The remove method removes the node at the specified index from the linked list and returns it.
	//If the index is out of bounds (less than 0 or greater than or equal to the length of the list), the method returns null, indicating that the removal failed.
	//If the index is 0, the method calls removeFirst to remove and return the first node.
	//If the index is equal to length - 1 (the last node), the method calls removeLast to remove and return the last node.
	//get previous node- The method retrieves the node just before the one to be removed using get(index - 1). This node is stored in the prev variable.
	//The node that needs to be removed is stored in the temp variable (temp = prev.next).
	//The next pointer of prev is updated to skip the node being removed and point to the node after it (prev.next = temp.next).
	//The next pointer of temp is set to null to fully detach it from the list.
	//The length of the linked list is decremented by 1, reflecting the removal of the node.
    //The method returns the node that was removed (temp).
	
	
	
	public void reverse() {
		Node temp= head;
		head= tail;
		tail=temp;
		Node after =temp.next;
		Node before= null;
		for(int i =0; i<length; i++) {
			after = temp.next;
			temp.next= before;
			before=temp;
			temp=after;
		}
	}
	//The reverse method reverses the order of the nodes in the linked list, making the tail the new head and the head the new tail.
	//The method starts by swapping the head and tail of the linked list.
	//temp is assigned the original head, so that it can be used to traverse the list.
	//after is initialized to temp.next (the node after the current node) to keep track of the next node in the original order.
	//before is initialized to null. It will keep track of the previous node as the list is being reversed.
	//The method enters a loop that iterates length times (once for each node in the list):
	//after is updated to the node after the current temp node (temp.next), preserving the next node in the original list.
    //The next pointer of the temp node is set to point to before (the previous node). This effectively reverses the direction of the link between temp and before.
	//before is updated to temp (current node) and temp is updated to after (the original next node). This advances the traversal to the next node in the original list.
    //By the end of the loop, all the next pointers of the nodes in the linked list will have been reversed. The head now points to the original last node, and the tail points to the original first node.
	
	
	  public void makeEmpty() {
	        head = null;
	        tail = null;
	        length = 0;
	    }



	public Node findMiddleNode() {
		// Initialize two pointers, slow and fast, both starting at the head of the linked list.
		Node slow = head;
		Node fast = head;

		// Loop until fast reaches the end of the list.
		// The loop runs while fast is not null and fast.next is also not null.
		// This ensures that fast can advance two steps in each iteration.
		while (fast != null && fast.next != null) {
			// Move the slow pointer one step forward.
			slow = slow.next;

			// Move the fast pointer two steps forward.
			fast = fast.next.next;
		}

		// When the loop ends, the slow pointer will be at the middle node of the list.
		// Return the node where slow is currently pointing.
		return slow;
	}



	public boolean hasLoop() {
	    // Initialize two pointers, slow and fast, both starting at the head of the linked list.
	    Node slow = head;
	    Node fast = head;

	    // Loop until fast reaches the end of the list.
	    // The loop runs while fast is not null and fast.next is also not null.
	    // This ensures that fast can safely move two steps forward.
	    while (fast != null && fast.next != null) {
	        // Move the slow pointer one step forward.
	        slow = slow.next;

	        // Move the fast pointer two steps forward.
	        fast = fast.next.next;

	        // Check if the slow and fast pointers have met.
	        // If they point to the same node, a loop exists in the list.
	        if (slow == fast) {
	            return true; // Loop detected.
	        }
	    }

	    // If the loop exits without slow and fast meeting, there is no loop.
	    return false;
	}
	//this hasLoop method is used to find out that there is loop in the linked list or not,using below algorithm
	//Floyd's Cycle-Finding Algorithm , also known as the "tortoise and the hare" algorithm


	public Node findKthFromEnd(int k){
		// Initialize two pointers, slow and fast, both pointing to the head of the linked list.
		Node slow = head;
		Node fast = head;

		// Move the fast pointer k steps ahead.
		for (int i = 0; i < k; i++) {
			// If fast becomes null, the list has fewer than k nodes.
			if (fast == null) {
				return null; // k is larger than the length of the list.
			}
			fast = fast.next;
		}

		// Traverse the list with both pointers until fast reaches the end.
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		// When the loop ends, slow will be pointing to the k-th node from the end.
		return slow;
	}

//it returns the k-th node from the end of the list.

	
	
	

    public void partitionList(int x) {
        if (head == null) {
            return; // If the list is empty, do nothing.
        }

        // Create two dummy nodes to act as the start of the less and greater/equal partitions.
        //Two dummy nodes are created with value 0. These act as temporary placeholders and make it easier to manage the two new lists being formed—one for nodes less than x and another for nodes greater than or equal to x.
        Node lessDummy = new Node(0); 
        Node greaterDummy = new Node(0); 
                

        // These pointers will be used to build the two lists.
        Node less = lessDummy;
        Node greater = greaterDummy;

        // Start traversing the list.
        Node current = head;
        while (current != null) {
            if (current.value < x) {
                // Add the node to the end of the 'less' list.
                less.next = current;
                less = less.next;
            } else {
                // Add the node to the end of the 'greater' list.
                greater.next = current;
                greater = greater.next;
            }
            // Move to the next node in the original list.
            current = current.next;
        }

        // At the end of the loop, 'greater' is at the last node of the greater/equal list.
        // Terminate the 'greater' list to avoid any potential cycles.
        greater.next = null;

        // Connect the 'less' list to the 'greater' list.
        less.next = greaterDummy.next;

        // Update the head to the start of the 'less' list.
        head = lessDummy.next;
    }
    
    
    
    public void removeDuplicatesWithSet(){   //time complexity: O(n) so, more efficient
        HashSet<Integer> values = new HashSet<>();
        Node prev= null;
        Node current=head;
        while(current!=null){
            if(values.contains(current.value)){
                prev.next=current.next;
                length--;
            }else{
                values.add(current.value);
                prev=current;
            }
             current = current.next;
        }
    }
    //Using hashset ,This approach will have a time complexity of O(n), where n is the number of nodes in the linked list. 
    //You are allowed to use the provided Set data structure in your implementation.

    

    public void removeDuplicates() {    //time complexity: O(n^2) less efficiency
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                    length -= 1;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
    
    //Without using a Set - This approach will have a time complexity of O(n^2), where n is the number of nodes in the linked list. 
    //You are not allowed to use any additional data structures for this implementation.
    
    
    

    public int binaryToDecimal(){
        int num=0;
        Node current=head;
        while(current!=null){
            num=num*2+current.value;
            current=current.next;
        }
        return num;
     }
 }
//The method binaryToDecimal converts a binary number, represented as a linked list, into its decimal equivalent.
//An integer variable num is initialized to 0. This variable will hold the cumulative decimal value as the binary number is processed.
//A variable current is initialized to point to the head of the linked list. The head is typically the first node in the linked list.
//Node is likely a custom class representing a node in the linked list. Each Node object contains a value (either 0 or 1 for binary) and a next pointer/reference to the next node in the list.
//A while loop is used to traverse the linked list. The loop continues as long as current is not null. When current is null, it means you've reached the end of the list.
//Inside the loop, the decimal number num is updated by multiplying the current value of num by 2 and adding the value of the current node (current.value).
//This operation effectively shifts the binary number to the left by one bit (multiplication by 2) and adds the current binary digit to the least significant bit position.
//The current pointer is moved to the next node in the linked list using current.next.
//After the loop has processed all the nodes in the linked list, the method returns the final value of num, which is the decimal equivalent of the binary number represented by the linked list.


//tip: while inserting some value , we use void  and create Node instance with parameter;
//while deleteing some node, we return Node  
