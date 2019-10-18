package exercise.algorithms;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Graph {
    private int V;             // No. of vertices
    private LinkedList[] adj;  // Adjacency List - array of LinkedList

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }

    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void DFS(int v) {
        // array of visited vertices
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[v] = true;
        System.out.println("Starting at " + v);
        queue.add(v);

        // loop while queue is not empty
        // Get all adjacent vertices of the de-queued vertex s
        // If a adjacent has not been visited, then mark it
        // visited and enqueue it
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            v = queue.poll();
            System.out.println("De-queueing " + v);
            Iterator<Integer> iterator = adj[v].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    System.out.println("queuing " + n);
                    queue.add(n);
                }

            }
        }

    }


}
