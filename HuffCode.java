// Hrag Bankian (expand comments for answers to theory questions)
// 40245363
// June 16, 2023

/*

Q2) Theory 1
What is the purpose of using a priority queue in Huffman coding, and how does it help to generate an
optimal code?

The purpose of using a priority queue in Huffman coding is to ensure the correct ordering of the nodes is 
already taken care of before we start building the Huffman tree. The purpose of having the nodes ordered 
correctly in Huffman coding is to optimize the space complexity of the program. When building a Huffman tree, 
a proper priority queue ensures that the symbols that appear the most have the shortest encryption code, 
while the symbols that appear the least have the longest encryption code, hence optimizing the space complexity
of the program.


Q3) Theory 2
How does the length of a Huffman code relate to the frequency of the corresponding symbol, and why
is this useful for data compression?

The shorter a Huffman code is, the more frequently the corresponding symbol appears. The longer a Huffman code is,
the less frequently the corresponding symbol appears. This is useful for data compression because it optimizes the
space complexity of the program. Less space will be used this way when encrypting and decrypting since the Huffman 
tree will be optimized in such a way that the most recurring symbols' Huffman code will take the least amount of space.


Q4) Theory 3
What is the time complexity of building a Huffman code, and how can you optimize it?
 
To determine the time complexity, we need to look at the underlying data structures used. The way that I went about 
it has a time complexity of O(n^2). The "enqueue" method of the priority queue, the most demanding part of the program 
time wise, has a for loop that traverses through an array, nested into a while loop that also traverses through an 
array, totaling for a time complexity of O(n^2). This could be better optimized if we were to use heaps instead of 
arrays for the priority queue, because the time complexity would then be O(nlogn) instead of O(n^2).
  
*/

package comp352.assignment.three;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HuffCode {

	public static void main(String[] args) {
		
		HMap map = new HMap();
		
		try {
			Scanner sc = new Scanner(new FileInputStream(args[0]));
			sc.useDelimiter("");
			while (sc.hasNext()) {
				String word = sc.next();
				map.add(word.charAt(0));
			}
			sc.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File Not Found!");
		}
		
		PQueue queue = new PQueue(map);
		HTree tree = new HTree(queue);
		
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		
		if (args[1].equals("decode")) {
			tree.decode(text);
		}
		else if (args[1].equals("encode")) {
				System.out.println(tree.encode(text, tree.getRoot()));
		}
		
		input.close();
	}
	
}
