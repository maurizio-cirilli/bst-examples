package org.buturiuncle.bst;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<Integer, String> t = new BST<>();
        t.put(5, "W");
        t.put(2, "S");
        t.put(10, "CIO");
        t.put(6, "USA");
        System.out.println(t);
        t.inorder();
        System.out.print("\n");
        t.preorder();
        System.out.print("\n");
        t.postorder();

    }
}
