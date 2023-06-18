// Hrag Bankian
// 40245363
// June 16, 2023

package comp352.assignment.three;

public class HMap {
	
	private char[] key;
	private int[] count;
	private int length;
 	private static final int MAX_ASCII = 128;

	public HMap() {
		key = new char[MAX_ASCII];
		count = new int[MAX_ASCII];
		length = 0;
		for (int i = 0; i < MAX_ASCII; i++) {
			count[i] = 0;
		}
	}
	
	public void add(char c) {
		int i = 0;
		boolean charFound = false;
		while (key[i] != 0) {
			if (key[i] == c) {
				charFound = true;
				count[i]++;
				break;
			}
			i++;
		}
		if (!charFound) {
			key[i] = c;
			count[i]++;
			length = i+1;
		}
	}
	
	public char getKeyAt(int i) {
		return key[i];
	}
	
	public int getCountAt(int i) {
		return count[i]; 
	}
	
	public int getLength() {
		return length;
	}
	
}
