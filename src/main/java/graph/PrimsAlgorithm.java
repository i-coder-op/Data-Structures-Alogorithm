package graph;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class PNode{
    public int node;
    public int weight;
    public int parent;

    public PNode(int node, int weight, int parent){
        this.node = node;
        this.weight = weight;
        this.parent = parent;
    }
}

/**
 * Prims algorithm is used to find the minimum spanning tree from the graph.
 * Minimum spanning tree can be defined as number of nodes must be N, number of edges must N-1 and should have less weight as compared to other spanning trees.
 */
public class PrimsAlgorithm {

    public static int nodes = 5;
    public static boolean[] visited = new boolean[nodes];
    public static List<List<PNode>> adjList = new ArrayList<>();
    public static List<PNode> minimumSpanningTree = new ArrayList<>();

    public static void main(String[] args) {
        //Prepare the adjacency list for the prims algorithm
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }

        addNodesInAdjList(0, 1, 2);
        addNodesInAdjList(0, 2, 1);

        addNodesInAdjList(1, 2, 1);

        addNodesInAdjList(2, 4, 2);
        addNodesInAdjList(2, 3, 2);

        addNodesInAdjList(3, 4, 1);

        //Call Prims algorithm
        int source = 0;
        callPrimsAlgorithm(source);
    }

    /**
     * Prims algorithm to find the minimum spanning tree
     * @param source
     */
    private static void callPrimsAlgorithm(int source) {
        PriorityQueue<PNode> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value.weight));
        queue.add(new PNode(source, 0, 0));

        int sum = 0;
        while(!queue.isEmpty()){
            PNode currentNode = queue.poll();
            int nodeValue = currentNode.node;
            int nodeWeight = currentNode.weight;

            if(visited[nodeValue]){
                continue;
            }
            visited[nodeValue] = true;
            sum += nodeWeight;
            minimumSpanningTree.add(currentNode);

            for(PNode adjNode : adjList.get(nodeValue)){
                int adjNodeValue = adjNode.node;
                int adjNodeWeight = adjNode.weight;
                if(!visited[adjNodeValue]){
                    queue.add(new PNode(adjNodeValue, adjNodeWeight, nodeValue));
                }
            }
        }

        System.out.println("MST Sum: " + sum);
        System.out.println("MST Nodes: ");
        minimumSpanningTree.stream().forEach(pNode -> System.out.print(pNode.parent + "->" + pNode.node + " "));
    }

    private static void addNodesInAdjList(int u, int v, int w) {
        adjList.get(u).add(new PNode(v, w, u));
        adjList.get(v).add(new PNode(u, w, v));
    }
}
