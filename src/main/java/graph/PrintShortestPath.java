package graph;

import java.util.*;

class GraphNode{
    int value;
    int weight;

    GraphNode(int value, int weight){
        this.value = value;
        this.weight = weight;
    }

}

public class PrintShortestPath {
    public static int n = 5;
    public static int[] weights = new int[n+1];
    public static List<List<GraphNode>> adjList = new ArrayList<>();
    public static int[] incomingPath = new int[n+1];
    public static List<Integer> shortestPath = new ArrayList<>();

    public static void main(String[] args) {
        for (int i=1;i<=n;i++){
            weights[i] = Integer.MAX_VALUE;
        }

        for (int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        //Prepare adjList
        adjList.get(1).add(new GraphNode(2, 2));
        adjList.get(1).add(new GraphNode(4, 1));

        adjList.get(2).add(new GraphNode(3, 4));
        adjList.get(2).add(new GraphNode(5, 5));
        adjList.get(2).add(new GraphNode(1, 2));

        adjList.get(3).add(new GraphNode(2, 4));
        adjList.get(3).add(new GraphNode(4, 3));
        adjList.get(3).add(new GraphNode(5, 1));

        adjList.get(4).add(new GraphNode(1, 1));
        adjList.get(4).add(new GraphNode(3, 3));

        adjList.get(5).add(new GraphNode(2, 5));
        adjList.get(5).add(new GraphNode(3, 1));

        int source = 1;
        weights[source] = 0;
        incomingPath[source] = source;

        callBFSDijkstraAlgo(source);

        int node = n;
        shortestPath.add(node);
        while(node != 1){
            shortestPath.add(incomingPath[node]);
            node = incomingPath[node];
        }
        Collections.reverse(shortestPath);
        shortestPath.forEach(listNode -> System.out.print(listNode + " "));
    }

    private static void callBFSDijkstraAlgo(int source) {
        PriorityQueue<GraphNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        queue.add(new GraphNode(source, weights[source]));

        while(!queue.isEmpty()){
            GraphNode currentNode = queue.poll();
            int currentNodeWeight = currentNode.weight;
            int currentNodeValue = currentNode.value;

            for(GraphNode adjNode : adjList.get(currentNodeValue)){
                int adjNodeValue = adjNode.value;
                int adjNodeWeight = adjNode.weight;
                int finalWeight = currentNodeWeight + adjNodeWeight;
                if(finalWeight<weights[adjNodeValue]){
                    adjNodeWeight = finalWeight;
                    weights[adjNodeValue] = adjNodeWeight;
                    queue.add(new GraphNode(adjNodeValue, adjNodeWeight));
                    incomingPath[adjNodeValue] = currentNodeValue;
                }
            }
        }
    }

}
