package graph;

import java.util.*;

public class BFSAlgorithm {
    public static List<Integer> bfsList = new ArrayList<>();

    public static void main(String[] args){
        int noOfNodes = 7;
        // create adjacency list of graph
        List<List<Integer>> adjList = createAdjacencyList(7);

        //Initialize a unvisitedArray of type boolean
        boolean[] visited = new boolean[noOfNodes+1];

        for (int node=1;node<=7;node++){
            if(visited[node] == false){
                executeBFS(adjList, visited, node);
            }
        }

        bfsList.stream().forEach(integer -> System.out.print(integer + ", "));
    }

    /**
     * This is the actual method to perform BFS (Breadth First Search) | TC-O(n) & SC-O(n)
     * @param adjList
     * @param visited
     * @param node
     */
    private static void executeBFS(List<List<Integer>> adjList, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int poppedNode = queue.poll();

            for(int adjacentNode : adjList.get(poppedNode)){
                if(visited[adjacentNode] == false){
                    visited[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }

            bfsList.add(poppedNode);
        }
    }

    /**
     * This method will be used to create adjacency list of graph
     * @return
     */
    private static List<List<Integer>> createAdjacencyList(int noOfNodes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=1;i<=noOfNodes+1;i++)
            adjList.add(new ArrayList<>());

        add(adjList, 1, 2);
        add(adjList, 2, 3);
        add(adjList, 2, 5);
        add(adjList, 3, 4);
        add(adjList, 4, 5);
        add(adjList, 6, 7);
        return adjList;
    }

    private static void add(List<List<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}

