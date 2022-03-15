package com.hs.shortestpath;

public class BellmanFordAlgorithm {

	private int noOfVertices, noOfEdges;
	private Edge[] edge;
	private int[] distance;

	// Creates a graph with V vertices and E edges
	BellmanFordAlgorithm(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		distance = new int[noOfVertices];
		edge = new Edge[noOfEdges];
		for (int i = 0; i < noOfEdges; i++) {
			edge[i] = new Edge();
		}
		// Step 1: Initialize distances from src to all other vertices as INFINITE
		for (int i = 0; i < noOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
	}

	// The function also detects negative weight cycle
	private void bellmanFord(int source) {
		distance[source] = 0;

		// Step 2: Relax all edges |V| - 1 times. A simple
		// shortest path from src to any other vertex can
		// have at-most |V| - 1 edges
		for (int i = 0; i < noOfVertices; i++) {
			for (int j = 0; j < noOfEdges; j++) {
				int src = edge[j].source;
				int dest = edge[j].destination;
				int weight = edge[j].weight;
				if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest])
					distance[dest] = distance[src] + weight;
			}
		}

		// Step 3: check for negative-weight cycles. The above
		// step guarantees shortest distances if graph doesn't
		// contain negative weight cycle. If we get a shorter
		// path, then there is a cycle.
		for (int j = 0; j < noOfEdges; j++) {
			int src = edge[j].source;
			int dest = edge[j].destination;
			int weight = edge[j].weight;
			if (distance[src] != Integer.MAX_VALUE && distance[src] + weight < distance[dest]) {
				System.out.println("Graph contains negative weight cycle");
				return;
			}
		}
		printArr(distance, noOfVertices);
	}

	// A utility function used to print the solution
	private void printArr(int dist[], int noOfVertices) {
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < noOfVertices; ++i)
			System.out.println(i + "\t\t" + dist[i]);
	}

	// Driver method to test above function
	public static void main(String[] args) {
		BellmanFordAlgorithm graph = new BellmanFordAlgorithm(5, 8);

		// add edge 0-1
		graph.edge[0].source = 0;
		graph.edge[0].destination = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2
		graph.edge[1].source = 0;
		graph.edge[1].destination = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2
		graph.edge[2].source = 1;
		graph.edge[2].destination = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3
		graph.edge[3].source = 1;
		graph.edge[3].destination = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4
		graph.edge[4].source = 1;
		graph.edge[4].destination = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2
		graph.edge[5].source = 3;
		graph.edge[5].destination = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1
		graph.edge[6].source = 3;
		graph.edge[6].destination = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3
		graph.edge[7].source = 4;
		graph.edge[7].destination = 3;
		graph.edge[7].weight = -3;

		graph.bellmanFord(0);
	}

}