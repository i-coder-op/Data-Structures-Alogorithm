package graph;

import java.util.*;

class Node{
    int nodeValue;
    int nodeWeight;
    Node(int nodeValue, int nodeWeight){
        this.nodeValue = nodeValue;
        this.nodeWeight = nodeWeight;
    }
}

public class ShortestPathUsingDijkstraAlgorithm {
    public static int noOfNodes = 6;
    public static int[] weights = new int[noOfNodes];
    public static List<List<Node>> adjList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0;i<noOfNodes;i++){
            weights[i] = Integer.MAX_VALUE;
            adjList.add(new ArrayList<Node>());
        }

        //Representing graph into adjacency list
        adjList.get(0).add(new Node(1, 1));
        adjList.get(0).add(new Node(3, 2));

        adjList.get(1).add(new Node(0, 1));
        adjList.get(1).add(new Node(3, 3));
        adjList.get(1).add(new Node(2, 1));
        adjList.get(1).add(new Node(4, 2));

        adjList.get(2).add(new Node(1, 1));
        adjList.get(2).add(new Node(4, 3));
        adjList.get(2).add(new Node(5, 1));

        adjList.get(3).add(new Node(1, 3));
        adjList.get(3).add(new Node(0, 2));
        adjList.get(3).add(new Node(4, 3));

        adjList.get(4).add(new Node(1, 2));
        adjList.get(4).add(new Node(2, 3));
        adjList.get(4).add(new Node(3, 3));
        adjList.get(4).add(new Node(5, 3));

        adjList.get(5).add(new Node(2, 1));
        adjList.get(5).add(new Node(4, 3));

        //Finalize the source node & initialize its weight to '0'
        int sourceNode = 0;
        weights[0] = 0;

        //Call the BFS for Dijkstra algorithm
        callBFSForDijkstraAlgorithm(sourceNode);

        Arrays.stream(weights).forEach(value -> System.out.print(value + " "));
    }

    /**
     * This method is responsible for performing Dijkstra algorithm using priority queue
     * @param sourceNode
     */
    private static void callBFSForDijkstraAlgorithm(int sourceNode) {
        PriorityQueue<Node> pQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.nodeWeight));
        /*PriorityQueue<Node> pQueue = new PriorityQueue<>((x,y)-> x.nodeWeight - y.nodeWeight);*/
        //Queue<Node> pQueue = new LinkedList<>();
        pQueue.add(new Node(sourceNode, 0));

        while (!pQueue.isEmpty()){
            Node currentNode = pQueue.poll();
            int currentNodeValue = currentNode.nodeValue;
            int currentNodeWeight = currentNode.nodeWeight;

            for(Node adjNode : adjList.get(currentNodeValue)){
                int adjNodeValue = adjNode.nodeValue;
                int adjNodeWeight = adjNode.nodeWeight;

                int finalWeight = currentNodeWeight+adjNodeWeight;
                if(finalWeight < weights[adjNodeValue]){
                    weights[adjNodeValue] = finalWeight;
                    adjNode.nodeWeight = finalWeight;
                    pQueue.add(adjNode);
                }
            }
        }
    }
}
