package graph;

import java.util.ArrayList;
import java.util.List;

public class BipartiteDFS {
    public static int[] graphColor;
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static boolean isGraphBipartite = false;

    public static void main(String[] args){
        int noOfNodes = 5;
        //Initialize graph array with default values - 1
        graphColor = new int[noOfNodes+1];
        for (int i=0;i< graphColor.length;i++){
            graphColor[i] = -1;
        }

        //create adjacency list
        adjList = createAdjListBipartite(noOfNodes);

        //call DFS for each component which are not colored
        for (int node=1;node<=noOfNodes;node++){
            if(graphColor[node] == -1){
                if(checkBipartiteDFS(node)){
                    isGraphBipartite = true;
                    break;
                }
            }
        }

        System.out.println("Is Graph Bipartite: " + isGraphBipartite);
    }

    private static boolean checkBipartiteDFS(int node) {
        if(graphColor[node] == -1){
            graphColor[node] = 0;
        }

        for (int adjNode : adjList.get(node)){
            if(graphColor[adjNode] == -1){
                if(graphColor[node] == 0)
                    graphColor[adjNode] = 1;
                else
                    graphColor[adjNode] = 0;
                //call DFS recursively
                if(checkBipartiteDFS(adjNode)){
                    return true;
                }else{
                    return false;
                }
            }else if(graphColor[adjNode] == graphColor[node]){
                return false;
            }
        }
        return true;
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

    private static void add(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
}
