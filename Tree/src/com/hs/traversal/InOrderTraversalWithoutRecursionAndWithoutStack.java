package com.hs.traversal;

public class InOrderTraversalWithoutRecursionAndWithoutStack {
	Node root;

	/*
	 * Function to traverse binary tree without recursion and without stack
	 */
	void MorrisTraversal(Node root) {
		Node current, pre;

		if (root == null)
			return;

		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in if part to restore the original tree i.e., fix the
				 * right child of predecssor
				 */
				else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				} /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL */

		} /* End of while */
	}

	public static void main(String args[]) {
		/*
		 * Constructed binary tree is 1 / \ 2 3 / \ 4 5
		 */
		InOrderTraversalWithoutRecursionAndWithoutStack tree = new InOrderTraversalWithoutRecursionAndWithoutStack();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.MorrisTraversal(tree.root);
	}
}