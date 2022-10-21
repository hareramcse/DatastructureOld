package com.hs.traversal;

import com.hs.tree.Node;

public class BinaryTreeRecursiveTraversal {

	 // Given a binary tree, print its nodes according to the "bottom-up" postorder traversal.
	public void printPostorder(Node root) {
		if (root == null)
			return;

		// first recur on left subtree
		printPostorder(root.left);

		// then recur on right subtree
		printPostorder(root.right);

		// now deal with the node
		System.out.print(root.data + " ");
	}

	// Given a binary tree, print its nodes in inorder
	private void printInorder(Node root) {
		if (root == null)
			return;

		/* first recur on left child */
		printInorder(root.left);

		/* then print the data of node */
		System.out.print(root.data + " ");

		/* now recur on right child */
		printInorder(root.right);
	}

	// Given a binary tree, print its nodes in preorder
	private void printPreorder(Node root) {
		if (root == null)
			return;

		/* first print data of node */
		System.out.print(root.data + " ");

		/* then recur on left subtree */
		printPreorder(root.left);

		/* now recur on right subtree */
		printPreorder(root.right);
	}

	// Driver method
	public static void main(String[] args) {
		BinaryTreeRecursiveTraversal tree = new BinaryTreeRecursiveTraversal();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder(root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder(root);
	}
}
