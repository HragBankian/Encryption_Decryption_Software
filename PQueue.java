// Hrag Bankian
// 40245363
// June 16, 2023

package comp352.assignment.three;

public class PQueue {

	private Node[] queue;
	
	public PQueue(HMap map) {
		int length = map.getLength();
		queue = new Node[length];
		int min = Integer.MAX_VALUE;
		int previousMin = 0;
		int currentIndex = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (map.getCountAt(j) < min && map.getCountAt(j) > previousMin) {
					min = map.getCountAt(j);
				}
			}
			previousMin = min;
			for (int j = 0; j < length; j++) {
				if (map.getCountAt(j) == min) {
					queue[currentIndex] = new Node(map.getKeyAt(j), map.getCountAt(j));
					currentIndex++;
				}
			}
			min = Integer.MAX_VALUE;
			if (currentIndex == length) {
				break;
			}
		}
	}
	
	public Node dequeue() {
		Node nodeOut = queue[0];
		Node[] temp =  new Node[queue.length-1];
		for (int i = 0; i < queue.length-1; i++) {
			temp[i] = queue[i+1];
		}
		queue = new Node[temp.length];
		for (int i = 0; i < queue.length; i++) {
			queue[i] = temp[i];
		}
		return nodeOut;
	}
	
	public void enqueue(Node n1, Node n2) {
		int sum = n1.getCount() + n2.getCount();
			int index = 0;
			Node[] temp = new Node[queue.length+1];
			while (queue[index].getCount() <= sum && index != queue.length-1) {
				index++;
			}
			if (index == queue.length-1 && sum >= queue[index].getCount()) {
				for (int i = 0; i < index+1; i++) {
					temp[i] = queue[i];
				}
				temp[index+1] = new Node(sum, n1, n2);
			} 
			else {
				for (int i = 0; i < index; i++) {
					temp[i] = queue[i];
				}
				temp[index] = new Node(sum, n1, n2);
				for (int i = index+1; i < temp.length; i++) {
					temp[i] = queue[i-1];
				}
			}
			queue = new Node[temp.length];
			for (int i = 0; i < queue.length; i++) {
				queue[i] = temp[i];
			}
//		}
	}

	public int getLength() {
		return queue.length;
	}
	
	public Node getNode(int i) {
		return queue[i];
	}
	
}

