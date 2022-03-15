package com.hs.shortestpath;

public class DijkstrasShortestPath {
	private int noOfVertices;
	private int[] dist;
	private boolean[] visited;

	private DijkstrasShortestPath(int graph[][]) {
		this.noOfVertices = graph.length;
		// dist[i] will hold the shortest distance from src to i
		dist = new int[noOfVertices];

		// Initialize all distances as INFINITE
		for (int i = 0; i < noOfVertices; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		// visited[i] will be true if vertex i is included in shortest path tree
		visited = new boolean[noOfVertices];
	}

	private void dijkstra(int graph[][], int src) {

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < noOfVertices - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minDistance(dist, visited);

			// Mark the picked vertex as visited
			visited[u] = true;

			// Update dist value of the adjacent vertices of the picked vertex.
			for (int v = 0; v < noOfVertices; v++)

				// Update dist[v] only if
				// vertex is not visited
				// there is an edge from u to v
				// and total weight of path from src to v through u is smaller than current
				// value of dist[v]
				if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		printSolution(dist);
	}

	private int minDistance(int distance[], boolean visited[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int i = 0; i < noOfVertices; i++)
			if (visited[i] == false && distance[i] <= min) {
				min = distance[i];
				minIndex = i;
			}

		return minIndex;
	}

	// A utility function to print the constructed distance array
	private void printSolution(int dist[]) {
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < noOfVertices; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	// Driver method
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		DijkstrasShortestPath dij = new DijkstrasShortestPath(graph);
		dij.dijkstra(graph, 0);
	}

}