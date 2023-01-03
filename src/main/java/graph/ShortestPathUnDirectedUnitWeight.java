package graph;

import java.util.*;

public class ShortestPathUnDirectedUnitWeight {
    public static int noOfNodes = 6;
    public static int[] weights = new int[6];
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static boolean[] visited = new boolean[6];

    public static void main(String[] args) {
        //Initialize the weights to max value & initialize the adjList
        for (int i = 0;i<noOfNodes;i++){
            weights[i] = Integer.MAX_VALUE;
            adjList.add(new ArrayList<>());
        }

        //Add nodes to the adjacency list
        adjList.get(0).add(1);
        adjList.get(0).add(5);

        adjList.get(1).add(0);
        adjList.get(1).add(5);
        adjList.get(1).add(4);
        adjList.get(1).add(2);

        adjList.get(2).add(1);
        adjList.get(2).add(4);
        adjList.get(2).add(3);

        adjList.get(3).add(4);
        adjList.get(3).add(2);

        adjList.get(4).add(3);
        adjList.get(4).add(2);
        adjList.get(4).add(1);
        adjList.get(4).add(5);

        adjList.get(5).add(4);
        adjList.get(5).add(1);
        adjList.get(5).add(0);

        //source node
        int source = 0;
        callBFSForShortestPath(source);
        System.out.println("Final weights");
        Arrays.stream(weights).forEach(value -> System.out.print(value + " "));
    }

    private static void callBFSForShortestPath(int source) {
        Queue<Integer> queue = new LinkedList<>();
        weights[source] = 0;
        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            visited[currentNode] = true;
            int currentNodeWeight = weights[currentNode];

            for(int adjNode : adjList.get(currentNodeWeight)){
                if(!visited[adjNode]){
                    queue.add(adjNode);
                }
                int finalWeight = currentNodeWeight + 1;
                if(finalWeight < weights[adjNode]){
                    weights[adjNode] = finalWeight;
                }
            }
        }
    }
}
