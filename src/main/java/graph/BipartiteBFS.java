package graph;

import java.util.*;

public class BipartiteBFS {
    public static int[] graphColor;
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static boolean isGraphBipartite = false;

    public static void main(String[] args) {
        int noOfNodes = 6;
        //intitialize graphColor array with default values
        graphColor = new int[noOfNodes+1];
        for (int i=0;i< graphColor.length;i++){
            graphColor[i] = -1;
        }

        //create Adjacency list
        adjList = createAdjListNonBipartite(noOfNodes);
        //adjList = createAdjListBipartite(noOfNodes);

        //Execute BFS algorithm for graph coloring
        for(int node = 1;node<=noOfNodes;node++){
            if(graphColor[node] == -1){
                if (checkBipartiteBFS(node)){
                    isGraphBipartite = true;
                    break;
                }
            }
        }

        System.out.println("Is Graph Bipartite: " + isGraphBipartite);
    }

    private static List<List<Integer>> createAdjListBipartite(int noOfNodes) {
        for (int i=0;i<=noOfNodes;i++){
            adjList.add(new ArrayList<>());
        }

        // add nodes and its adjacent nodes in the adjacency list
        add(1,2);
        add(2,5);
        add(2,3);
        add(3,4);
        add(4,5);

        return adjList;
    }

    private static boolean checkBipartiteBFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        graphColor[node] = 0;

        while (!queue.isEmpty()){
            int removedNode = queue.poll();

            for(int adjNode : adjList.get(removedNode)){
                if(graphColor[adjNode] == -1){
                    if (graphColor[removedNode] == 0)
                        graphColor[adjNode] = 1;
                    else
                        graphColor[adjNode] = 0;
                    queue.add(adjNode);
                }else{
                    if(graphColor[removedNode] == graphColor[adjNode]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static List<List<Integer>> createAdjListNonBipartite(int noOfNodes) {
        for (int i=0;i<=noOfNodes;i++){
            adjList.add(new ArrayList<>());
        }

        // add nodes and its adjacent nodes in the adjacency list
        add(1,2);
        add(2,6);
        add(2,3);
        add(3,4);
        add(4,5);
        add(5,6);

        return adjList;
    }

    private static void add(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
