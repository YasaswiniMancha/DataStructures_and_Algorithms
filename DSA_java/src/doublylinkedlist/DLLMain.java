package doublylinkedlist;

public class DLLMain {

	 public static void main(String[] args) {
	
	DoublyLinkedList dll= new DoublyLinkedList(1);
	
	System.out.println("printlist before append: ");
	
	dll.printDList();
	
	dll.appendAtLast1(1);
	dll.appendAtLast1(2);
	dll.appendAtLast1(3);
	dll.appendAtLast(4);
	dll.appendAtLast(5);
	
     System.out.println("printlist after append: ");
	
	dll.printDList();
	
	
	System.out.println("printlist after remove last: ");
	dll.removeLast();	
	dll.printDList();
	
	
	System.out.println("printlist after prepend: ");
	dll.prepend(4);	
	dll.printDList();
	
	

	System.out.println("printlist after removeFirst: ");
	dll.removeFirst();	
	dll.removeFirst();
	dll.printDList();
	
	System.out.println("get node value by giving index: " + dll.get(3).value);
	
	System.out.println("printlist after set: ");
    dll.set(1, 3);
    dll.printDList();
	System.out.println("printlist after set: ");
    dll.set(1, 2);
    dll.printDList();
	 
	System.out.println("printlist after insert index and value: ");
    dll.insert(2, 2);
    dll.insert(3,3);
    dll.printDList();
    
	System.out.println("printlist after remove specific index: ");
    dll.remove(2);
    dll.removeWithIndex(3);
    dll.printDList();
	
	 }
	 
	 
}
