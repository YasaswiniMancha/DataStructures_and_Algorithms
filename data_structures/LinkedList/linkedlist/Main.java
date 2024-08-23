package linkedlist;


public class Main{
	
     public static void main(String args[]) {
    	 
     LinkedList myLinkedList = new LinkedList(4);
     
//     myLinkedList.getHead();
//     myLinkedList.getTail();
//     myLinkedList.getLength();
          
     myLinkedList.append(54);
     myLinkedList.append(3);
     myLinkedList.append(5);
     myLinkedList.append(45);
     myLinkedList.append(8);
     
     
     System.out.print("printlist after append: ");
     myLinkedList.printList();
     
     myLinkedList.prepend(23);
     System.out.print("printlist after prepend: ");
     myLinkedList.printList();
     
     myLinkedList.removeFirst();
     System.out.print("printlist after removing first element: ");
     myLinkedList.printList();
     
     myLinkedList.removeLast();
     System.out.print("printlist after removing last element: ");
     myLinkedList.printList();
     
     System.out.print("\n");
     System.out.print("To find/get a particular index: ");     
     System.out.print(myLinkedList.get(3) + "\n" );
     
     System.out.print("\n");
     System.out.print("setting 48 value at node 1: ");
     myLinkedList.set(1,48);
     myLinkedList.printList();
     
     System.out.print("\n");
     System.out.print("insert 89 value at node 4: ");
     myLinkedList.insert(4,89);
     myLinkedList.printList();
     
     System.out.print("\n");
     System.out.print("after removing a particular index element: ");
     myLinkedList.remove(3);
     myLinkedList.printList();
     
     System.out.print("\n");
     System.out.print("after reversal of the linked list: ");
     myLinkedList.reverse();
     myLinkedList.printList();
     
     System.out.print("\n");
     System.out.println("printing all: ");
     myLinkedList.printAll();
     
     System.out.print("\n");
     System.out.println("emptying the linkedlist: ");
     myLinkedList.makeEmpty();
     myLinkedList.printAll();
     

    }
     
}