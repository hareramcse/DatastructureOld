package com.hs.bst;

public class CommonAncestorInBST {

	// Function to find LCA of n1 and n2. The function assumes that both n1 and n2
	// are present in BST
	private Node lca(Node root, int n1, int n2) {
		if (root == null)
			return null;

		// If both n1 and n2 are smaller than root, then LCA lies in left
		if (root.data > n1 && root.data > n2)
			return lca(root.left, n1, n2);

		// If both n1 and n2 are greater than root, then LCA lies in right
		if (root.data < n1 && root.data < n2)
			return lca(root.right, n1, n2);

		return root;
	}

	public static void main(String args[]) {
		// Let us construct the BST shown in the above figure
		CommonAncestorInBST tree = new CommonAncestorInBST();
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = tree.lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

	}
}