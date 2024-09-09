package queue;

public class QueueMain {

	public static void main(String[] args) {

		Queue qu=new Queue(1);
		qu.printQueue();
		
		System.out.println("After enqueue ");
		qu.enQueue(2);
		qu.enQueue(3);
		qu.enQueue(4);
		qu.printQueue();
		
		
		System.out.println("After dequeue ");
        qu.deQueue();
		qu.printQueue();
		
	}

}
