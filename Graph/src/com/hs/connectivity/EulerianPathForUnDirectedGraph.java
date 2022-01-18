package com.hs.connectivity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class EulerianPathForUnDirectedGraph {

	private int noOfVertices;
	private Queue<Integer> adj[];

	@SuppressWarnings("unchecked")
	EulerianPathForUnDirectedGraph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adj = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; ++i)
			adj[i] = new LinkedList<>();
	}

	private void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	// A function used by DFS
	private void DFSUtil(int source, boolean visited[]) {
		// Mark the current node as visited
		visited[source] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[source].iterator();
		while (it.hasNext()) {
			int currentAdj = it.next();
			if (!visited[currentAdj])
				DFSUtil(currentAdj, visited);
		}
	}

	// Method to check if all non-zero degree vertices are
	// connected. It mainly does DFS traversal starting from
	private boolean isConnected() {
		// Mark all the vertices as not visited
		boolean visited[] = new boolean[noOfVertices];
		int i;

		// Find a vertex with non-zero degree
		for (i = 0; i < noOfVertices; i++)
			if (adj[i].size() != 0)
				break;

		// If there are no edges in the graph, return true
		if (i == noOfVertices)
			return true;

		// Start DFS traversal from a vertex with non-zero degree
		DFSUtil(i, visited);

		// Check if all non-zero degree vertices are visited
		for (i = 0; i < noOfVertices; i++)
			if (visited[i] == false && adj[i].size() > 0)
				return false;

		return true;
	}

	/*
	 * The function returns one of the following values 0 --> If graph is not
	 * Eulerian 1 --> If graph has an Euler path (Semi-Eulerian) 2 --> If graph has
	 * an Euler Circuit (Eulerian)
	 */
	private int isEulerian() {
		// Check if all non-zero degree vertices are connected
		if (isConnected() == false)
			return 0;

		// Count vertices with odd degree
		int odd = 0;
		for (int i = 0; i < noOfVertices; i++)
			if (adj[i].size() % 2 != 0)
				odd++;

		// If count is more than 2, then graph is not Eulerian
		if (odd > 2)
			return 0;

		// If odd count is 2, then semi-eulerian.
		// If odd count is 0, then eulerian
		// Note that odd count can never be 1 for undirected graph
		return (odd == 2) ? 1 : 2;
	}

	// Function to run test cases
	private void test() {
		int res = isEulerian();
		if (res == 0)
			System.out.println("graph is not Eulerian");
		else if (res == 1)
			System.out.println("graph has a Euler path");
		else
			System.out.println("graph has a Euler cycle");
	}

	// Driver method
	public static void main(String args[]) {
		// Let us create and test graphs shown in above figures
		EulerianPathForUnDirectedGraph g1 = new EulerianPathForUnDirectedGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.test();

		EulerianPathForUnDirectedGraph g2 = new EulerianPathForUnDirectedGraph(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(3, 4);
		g2.addEdge(4, 0);
		g2.test();

		EulerianPathForUnDirectedGraph g3 = new EulerianPathForUnDirectedGraph(5);
		g3.addEdge(1, 0);
		g3.addEdge(0, 2);
		g3.addEdge(2, 1);
		g3.addEdge(0, 3);
		g3.addEdge(3, 4);
		g3.addEdge(1, 3);
		g3.test();

		// Let us create a graph with 3 vertices
		// connected in the form of cycle
		EulerianPathForUnDirectedGraph g4 = new EulerianPathForUnDirectedGraph(3);
		g4.addEdge(0, 1);
		g4.addEdge(1, 2);
		g4.addEdge(2, 0);
		g4.test();

		// Let us create a graph with all vertices
		// with zero degree
		EulerianPathForUnDirectedGraph g5 = new EulerianPathForUnDirectedGraph(3);
		g5.test();
	}

}