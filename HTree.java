// Hrag Bankian
// 40245363
// June 16, 2023

package comp352.assignment.three;

public class HTree {
	
	private Node root;
	
	public HTree(PQueue queue) {
		while (queue.getLength() > 2) {
			Node node1 = queue.dequeue();
			Node node2 = queue.dequeue();
			queue.enqueue(node1, node2);
		}
		Node node1 = queue.getNode(0);
		Node node2 = queue.getNode(1);
		int a = node1.getCount();
		int b = node2.getCount();
		root = new Node(a+b, node1, node2);
	}
	
	public void decode(String text) {
		Node temp = root;
		for (int i = 0; i < text.length(); i++) {
			if (temp.getLeft() == null) {
				System.out.print(temp.getKey());
				temp = root;
			}
			if (text.charAt(i) == '0') {
				temp = temp.getRight();
			} 
			else if (text.charAt(i) == '1') {
				temp = temp.getLeft();
			}
		}
		System.out.print(temp.getKey());
	}
	
	public Node getRoot() {
		return root;
	}
	
	public String encode(String text, Node n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			String code = codeBuilder(text.charAt(i), n);
			if (code != null) {
				sb.append(code);
			}
		}
		return sb.toString();
	}
	
	private String codeBuilder(char c, Node n) {
		if (n.getLeft() == null) {
			if (n.getKey() == c) {
				return "";
			}
			return null;
		}
		String codeL = codeBuilder(c, n.getLeft());
		if (codeL != null) {
			return "1" + codeL;
		}
		String codeR = codeBuilder(c, n.getRight());
		if (codeR != null) {
			return "0" + codeR;
		}
		return null;
	}
}
