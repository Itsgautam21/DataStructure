package dsa.graphs;

import java.util.*;

/*
            0 ---- 1 ---- 2
            |   /  |    /
            | /    |  /
            4 ----- 3
 */

public class Graphs {

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    private static void printGraph(ArrayList<ArrayList<Integer> > adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++)
                System.out.print(" -> "+adj.get(i).get(j));
            System.out.println();
        }
    }
    private static void BFSTraversal(ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.size()];
        queue.add(graph.get(0).get(0));
        isVisited[graph.get(0).get(0)] = true;
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            bfsTraversal.add(temp);
            for (int i = 0; i < graph.get(temp).size(); i++) {
                if (!isVisited[graph.get(temp).get(i)]) {
                    queue.add(graph.get(temp).get(i));
                    isVisited[graph.get(temp).get(i)] = true;
                }
            }
        }
        System.out.println(bfsTraversal);
    }

    public static void main(String[] args) {

        int V = 5;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
        BFSTraversal(adj);
    }
}
