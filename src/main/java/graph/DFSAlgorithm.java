package graph;

import java.util.ArrayList;
import java.util.List;

public class DFSAlgorithm {
    public static List<Integer> dfsList = new ArrayList<>();
    public static boolean[] visited = new boolean[8];
    public static int numberOfNodes = 7;
    public static List<List<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args){
        // create adjacency list for all the components of graph
        adjList = createAdjList();

        //call dfs method for each component which are not visited
        for (int node = 1;node <= numberOfNodes;node++){
            if(visited[node] == false){
                executeDFS(node);
            }
        }

        //print dfs
        dfsList.stream().forEach(node -> System.out.print(node + " "));
    }

    /**
     * Actual DFS method which will called recursively for every adjacent nodes | TC-O(n) & SC-O(n)
     * @param node
     */
    private static void executeDFS(int node) {
        //insert node into the dfsList
        dfsList.add(node);

        //mark node as visited in the visited array
        visited[node] = true;

        //call dfs recursively for each adjacent node
        for (int adjacentNode : adjList.get(node)){
            if(visited[adjacentNode] == false){
                executeDFS(adjacentNode);
            }
        }
    }


    /**
     * Creates the adjacency list for all the components of graph
     * @return
     */
    private static List<List<Integer>> createAdjList() {
        for (int i = 1;i <= (numberOfNodes+1);i++){
            adjList.add(new ArrayList<>());
        }
        // add nodes and its adjacent nodes in the adjacency list
        add(1,2);
        add(2,5);
        add(2,3);
        add(3,4);
        add(4,5);
        add(6,7);

        return adjList;
    }

    /**
     * Utility method to add nodes and its adjacent in the list
     * @param u
     * @param v
     */
    private static void add(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}

