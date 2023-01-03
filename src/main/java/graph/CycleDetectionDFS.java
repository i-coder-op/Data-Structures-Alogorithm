package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDFS {
    public static boolean[] visited;
    public static List<List<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args){
        int noOfNodes = 8;
        boolean isCycleDetected = false;

        //initialize the visited array with size
        visited = new boolean[noOfNodes+1];

        //create adjacency list for each component of graph
        adjList = createAdjList(noOfNodes);

        //call dfs algorithm with modification to detect cycle
        for (int currentNode=1;currentNode<=noOfNodes;currentNode++){
            if(visited[currentNode] == false){
                if (detectCycleDFS(currentNode, -1))
                    isCycleDetected = true;
            }
        }

        System.out.println("Is Cycle Detected: " + isCycleDetected);
    }

    private static boolean detectCycleDFS(int currentNode, int previousNode) {
        //mark the current node as visited
        visited[currentNode] = true;

        for (int adjNode : adjList.get(currentNode)){
            if(visited[adjNode] == false){
                if(detectCycleDFS(adjNode, currentNode)){
                    return true;
                }
            }else if(adjNode != previousNode){
                return true;
            }
        }
        return false;
    }

    private static List<List<Integer>> createAdjList(int noOfNodes) {
        for (int i=0;i<=noOfNodes;i++)
            adjList.add(new ArrayList<>());

        // add nodes and its adjacent nodes in the adjacency list
        add(1,2);
        add(2,5);
        add(2,3);
        add(3,4);
        add(4,5);
        add(6,7);
        add(6,8);
        add(7,8);

        return adjList;
    }

    private static void add(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
