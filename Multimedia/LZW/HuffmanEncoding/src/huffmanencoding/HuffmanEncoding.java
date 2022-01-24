package huffmanencoding;

/**
 *
 * @author M A mazedul Islam
 */
// Huffman Coding in Java

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class HuffmanNode {
  int item;
  char c;
  HuffmanNode left;
  HuffmanNode right;
}

// For comparing the nodes
class ImplementComparator implements Comparator<HuffmanNode> {
  public int compare(HuffmanNode x, HuffmanNode y) {
    return x.item - y.item;
  }
}

// IMplementing the huffman algorithm
public class HuffmanEncoding {
  public static void printCode(HuffmanNode root, String s) {
    if (root.left == null && root.right == null && Character.isLetter(root.c)) {

      System.out.println(root.c + "   |  " + s);

      return;
    }
    printCode(root.left, s + "0");
    printCode(root.right, s + "1");
  }

  public static void main(String[] args) {

    int n;
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter your number of character : ");
    n = input.nextInt();
    char[] charArray = new char[n];
    int[] charfreq = new int[n];
    
      for (int i = 0 ; i < n; i++) {
          System.out.print((i+1)+ " : char , frequence : ");
          charArray[i] = input.next().charAt(0);
          charfreq[i] = input.nextInt();
      }

    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

    for (int i = 0; i < n; i++) {
      HuffmanNode hn = new HuffmanNode();

      hn.c = charArray[i];
      hn.item = charfreq[i];

      hn.left = null;
      hn.right = null;

      q.add(hn);
    }

    HuffmanNode root = null;

    while (q.size() > 1) {

      HuffmanNode x = q.peek();
      q.poll();

      HuffmanNode y = q.peek();
      q.poll();

      HuffmanNode f = new HuffmanNode();

      f.item = x.item + y.item;
      f.c = '-';
      f.left = x;
      f.right = y;
      root = f;

      q.add(f);
    }
    System.out.println("\n Char | Huffman code ");
    System.out.println("--------------------");
    printCode(root, "");
  }
}
