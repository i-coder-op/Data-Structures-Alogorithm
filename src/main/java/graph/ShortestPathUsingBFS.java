package graph;

import java.util.*;

public class ShortestPathUsingBFS {
    public static List<HashMap<Integer,Integer>> adjList = new ArrayList<>();
    public static int[] distanceArray;

    public static void main(String[] args) {
        int noOfNodes = 6;
        distanceArray = new int[noOfNodes];
        for (int i=0;i<noOfNodes;i++) {
            distanceArray[i] = Integer.MAX_VALUE;
            adjList.add(new HashMap<>());
        }

        adjList.get(0).put(5, 3);

        adjList.get(1).put(2, 1);
        adjList.get(1).put(0, 2);

        adjList.get(2).put(0, 3);
        adjList.get(2).put(3, 1);
        adjList.get(2).put(5, 2);

        adjList.get(3).put(5, 2);
        adjList.get(3).put(4, 6);

        adjList.get(5).put(4, 3);

        int source = 0;
        shortestPathUsingBFS(source);
        for(int i=0;i<noOfNodes;i++){
            if(distanceArray[i] == Integer.MAX_VALUE){
                System.out.println("Shortest Distance from " + source + " to " + i + " = No Path");
            }else{
                System.out.println("Shortest Distance from " + source + " to " + i + " = " + distanceArray[i]);
            }
        }
    }

    private static void shortestPathUsingBFS(int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        distanceArray[source] = 0;

        while (!queue.isEmpty()){
            int removedElement = queue.poll();
            int previousDistance = distanceArray[removedElement];

            for (Map.Entry<Integer, Integer> entry : adjList.get(removedElement).entrySet()){
                int adjNode = entry.getKey();
                int currentDistance = entry.getValue();

                int finalDistance = previousDistance + currentDistance;
                if(finalDistance < distanceArray[adjNode]){
                    distanceArray[adjNode] = finalDistance;
                }
                queue.add(adjNode);
            }
        }
    }
}
