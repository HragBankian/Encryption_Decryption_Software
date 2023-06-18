// Hrag Bankian
// 40245363
// June 16, 2023

package comp352.assignment.three;

public class Node {
	
	private char key;
	private int count;
	private Node left;
	private Node right;
	
	public Node(char c, int i) {
		key = c;
		count = i;
		left = null;
		right = null;
	}
	
	public Node(int i, Node l, Node r) {
		key = 0;
		count = i;
		left = l;
		right = r;
	}
	
	public int getCount() {
		return count;
	}
	
	public char getKey() {
		return key;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
}
