package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDFSDirectedGraph {
    public static boolean isCycleDetected = false;
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static boolean[] visited;
    public static boolean[] dfsVisited;

    public static void main(String[] args){
        int noOfNodes = 7;

        visited = new boolean[noOfNodes+1];
        dfsVisited = new boolean[noOfNodes+1];

        //create adjacency list
        adjList = createAdjList(noOfNodes);

        //call dfs for each component
        for (int node=1;node<=noOfNodes;node++){
            if(visited[node] == false){
                if(cycleDirectedDFS(node)){
                    isCycleDetected = true;
                    break;
                }
            }
        }

        System.out.println("Is cycle detected: " + isCycleDetected);
    }

    /**
     * Cycle detection using DFS for directed graph
     * @param node
     * @return
     */
    private static boolean cycleDirectedDFS(int node) {
        visited[node] = true;
        dfsVisited[node] = true;

        for(int adjNode : adjList.get(node)){
            if(visited[adjNode] == false){
                if(cycleDirectedDFS(adjNode)){
                    return true;
                }
            }else{
                if(dfsVisited[adjNode] == true){
                    return true;
                }
            }
        }
        dfsVisited[node] = false;
        return false;
    }

    private static List<List<Integer>> createAdjList(int noOfNodes) {
        for (int i=0;i<=noOfNodes;i++){
            adjList.add(new ArrayList<>());
        }

        adjList.get(1).add(2);

        adjList.get(2).add(3);

        adjList.get(3).add(4);
        /*adjList.get(3).add(5);*/
        adjList.get(3).add(6);

        adjList.get(4).add(5);

        adjList.get(5).add(3);

        adjList.get(6).add(7);

        /*adjList.get(7).add(2);*/

        return adjList;
    }
}
