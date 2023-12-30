package course.queue_and_stack;

public class QueueStackDemo {

	public static void main(String[] args) {
		int myData[] = {1, 2, 3, 4, 5, 6};
		Queue queue = new LukasQueue(10);
		System.out.println("Adding data to queue (first time) ...");
		for (int d : myData) {
			boolean b = queue.putBack(d);
			System.out.printf("Adding data %d to queue ... ", d);
			System.out.println(b ? "Succeeded" : "Failed");
		}
		
		Integer dd = queue.getFront();
		while(dd != null) {
			System.out.println("Data from queue: " + dd);
			dd = queue.getFront();
		}

		System.out.println("Adding data to queue (second time) ...");
		for (int d : myData) {
			boolean b = queue.putBack(d);
			System.out.printf("Adding data %d to queue ... ", d);
			System.out.println(b ? "Succeeded" : "Failed");
		}

		dd = queue.getFront();
		while(dd != null) {
			System.out.println("Data from queue: " + dd);
			dd = queue.getFront();
		}		for (int d : myData) {
			queue.putBack(d);
		}

		System.out.println("------------------");
		Stack stack = new LukasStack(10);
		for (int d : myData) {
			if (d == 3) {
				stack.pop();
				stack.push(100);
			}
			stack.push(d);
		}
		
		dd = stack.pop();
		while(dd != null) {
			System.out.println("Data from stack: " + dd);
			dd = stack.pop();
		}
	}

}
