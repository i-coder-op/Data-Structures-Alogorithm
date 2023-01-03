package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionBFS {
    public static class Node{
        public Integer current;
        public Integer previous;
    }

    public static boolean[] visited;
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static List<Integer> bfsList = new ArrayList<>();

    public static void main(String[] args){
        int noOfNodes = 8;
        //initialize visited array with default values and size
        visited = new boolean[noOfNodes+1];

        //create adjacency list for each component of graph
        adjList = createAdjList(noOfNodes);

        //call bfs algorithm for cycle detection
        boolean isCycleDetected = false;
        for(int node = 1;node <= noOfNodes;node++){
            if(!visited[node]){
                if(detectCycleUsingBFS(node)){
                    isCycleDetected = true;
                    break;
                }
            }
        }
        System.out.println("Is Cycle Detected: " + isCycleDetected);

    }

    /**
     * Detect cycle using bfs algorithm
     * @param node
     * @return
     */
    private static boolean detectCycleUsingBFS(int node) {
        //Initialize a queue and enque first node and mark node as visited
        Queue<Node> queue = new LinkedList<>();
        Node firstNode = new Node();
        firstNode.current = node;
        firstNode.previous = -1;
        queue.add(firstNode);
        visited[node] = true;

        while (!queue.isEmpty()){
            Node removedNode = queue.poll();

            for (int adjacentNode : adjList.get(removedNode.current)){
                if(!visited[adjacentNode]){
                    Node newNode = new Node();
                    newNode.current = adjacentNode;
                    newNode.previous = removedNode.current;

                    visited[adjacentNode] = true;

                    queue.add(newNode);
                }else if(visited[adjacentNode] && adjacentNode != removedNode.previous){
                    return true;
                }
            }

            bfsList.add(removedNode.current);
        }

        return false;
    }

    /**
     * Create adjacency list for each component of graph
     * @param noOfNodes
     * @return
     */
    private static List<List<Integer>> createAdjList(int noOfNodes) {
        for (int i=0;i<=(noOfNodes);i++){
            adjList.add(new ArrayList<>());
        }

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
