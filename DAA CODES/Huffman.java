import java.util.PriorityQueue;

public class Huffman {

    static class Node implements Comparable<Node> {
        int freq;
        String symbol;
        Node left, right;
        String huff = "";

        Node(int freq, String symbol) {
            this.freq = freq;
            this.symbol = symbol;
        }

        Node(int freq, String symbol, Node left, Node right) {
            this.freq = freq;
            this.symbol = symbol;
            this.left = left;
            this.right = right;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.freq, other.freq);
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    static void printNodes(Node node, String prefix) {
        if (node == null) return;

        String newPrefix = prefix + node.huff;

        if (node.left != null) {
            printNodes(node.left, newPrefix);
        }
        if (node.right != null) {
            printNodes(node.right, newPrefix);
        }

        if (node.isLeaf()) {
            System.out.println(node.symbol + " -> " + newPrefix);
        }
    }

    public static void main(String[] args) {
        String[] chars = {"a", "b", "c", "d", "e", "f"};
        int[] freqs = {5, 9, 12, 13, 16, 45};

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(freqs[i], chars[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            left.huff = "0";
            right.huff = "1";

            Node merged = new Node(left.freq + right.freq, left.symbol + right.symbol, left, right);
            pq.add(merged);
        }

        Node root = pq.peek();
        printNodes(root, "");
    }
}
