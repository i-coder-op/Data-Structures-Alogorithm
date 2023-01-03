package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static List<Integer> topologicalSortedList = new ArrayList<>();
    public static boolean[] visited;
    public static Stack<Integer> topoStack;

    public static void main(String[] args) {
        int noOfNodes = 5;

        visited = new boolean[noOfNodes + 1];
        topoStack = new Stack<>();

        //create the adjacency list
        adjList = createAdjList(noOfNodes);

        //call DFS for each component and find topological sorted nodes
        for (int node = 1;node<=noOfNodes;node++){
           if (visited[node] == false){
               findTopoSortUsingDFS(node);
           }
        }
        for (int i=1;i<=noOfNodes;i++){
            topologicalSortedList.add(topoStack.pop());
        }
        topologicalSortedList.forEach(element -> System.out.println(element + " "));
    }

    /**
     * Find topological sort using DFS algorithm
     * @param node
     */
    private static void findTopoSortUsingDFS(int node) {
        visited[node] = true;

        for (int adjNode : adjList.get(node)){
            if (visited[adjNode] == false){
                findTopoSortUsingDFS(adjNode);
            }
        }
        topoStack.push(node);
    }

    private static List<List<Integer>> createAdjList(int noOfNodes) {
        for (int i=0;i<=noOfNodes;i++){
            adjList.add(new ArrayList<>());
        }

        adjList.get(1).add(2);

        adjList.get(2).add(5);
        adjList.get(2).add(3);

        adjList.get(3).add(4);

        adjList.get(4).add(5);


        return adjList;
    }
}
