package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BellmanFordGraphNode {
    int source;
    int weight;
    int destination;

    public BellmanFordGraphNode(int source, int weight, int destination) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

/**
 * Bellman ford algorithm is used to find the shortest distance from the single source to destination
 * It is designed to find the negative cycle as well because Dijkstra algorithm does work for negative paths/cycle
 * We usually use a weights/distance array and do the relaxation for every node for (N-1) iterations where N = number of nodes
 * Why (N-1) iterations? -> coz there might be a chance where the source node is located at the end.
 * -> Each iteration will update the weights array and it helps other node to find the shortest distance from source as a relaxation.
 * We usually apply this algorithm on the DG(Directed Graphs) and if we get the undirected graph then we need to convert it to DG
 */
public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        int N = 5;
        //Create graph nodes
        List<BellmanFordGraphNode> graphNodeList = new ArrayList<>();

        graphNodeList.add(new BellmanFordGraphNode(1, -1, 4));

        graphNodeList.add(new BellmanFordGraphNode(2, -2, 1));

        graphNodeList.add(new BellmanFordGraphNode(3, 2, 2));

        graphNodeList.add(new BellmanFordGraphNode(0, 5, 2));

        graphNodeList.add(new BellmanFordGraphNode(0, 5, 3));

        graphNodeList.add(new BellmanFordGraphNode(2, 1, 4));

        graphNodeList.add(new BellmanFordGraphNode(3, -3, 4));

        graphNodeList.add(new BellmanFordGraphNode(0, 6, 1));

        int[] weights = new int[N];
        for(int i=0;i<N;i++){
            weights[i] = (int)1e8;//Integer.MAX_VALUE;
        }

        int source = 0;

        weights = callBellmanFordAlgorithm(source, graphNodeList, N, weights);System.out.println("");
        if (weights[0] < 0)
            System.out.println("Graph has a negative cycle!");
    }

    /**
     * Bellman ford algorithm
     * @param source
     * @param graphNodeList
     * @param n
     * @param weights
     * @return
     */
    private static int[] callBellmanFordAlgorithm(int source, List<BellmanFordGraphNode> graphNodeList, int n, int[] weights) {
        weights[source] = 0;
        for(int i=0;i<n-1;i++){
            for (BellmanFordGraphNode node : graphNodeList){
                int sourceNode = node.source;
                int weight = node.weight;
                int destinationNode = node.destination;

                if(weights[sourceNode] != (int)1e8/*Integer.MAX_VALUE*/ &&
                        (weights[sourceNode] + weight < weights[destinationNode])){
                    weights[destinationNode] = weights[sourceNode] + weight;
                }
            }
        }

        System.out.println("Shortest path from source " + source);
        Arrays.stream(weights).forEachOrdered(value -> {
            System.out.print(value + " ");
        });

        //Nth iteration to find the negative cycle
        for (BellmanFordGraphNode node : graphNodeList){
            int sourceNode = node.source;
            int weight = node.weight;
            int destinationNode = node.destination;

            if(weights[sourceNode] != (int)1e8/*Integer.MAX_VALUE*/ &&
                    (weights[sourceNode] + weight < weights[destinationNode])){
                return new int[] {-1};
            }
        }

        return weights;
    }
}
