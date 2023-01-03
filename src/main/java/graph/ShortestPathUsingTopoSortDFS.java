package graph;

import java.util.*;

public class ShortestPathUsingTopoSortDFS {
    public static List<HashMap<Integer, Integer>> adjList = new ArrayList<>();
    public static int[] distanceArray;
    public static boolean[] visitedArray;
    public static Stack<Integer> topoStack = new Stack<>();

    public static void main(String[] args) {
        int noOfNodes = 6;
        distanceArray = new int[noOfNodes];

        //assign higher value to each element in distance array
        for (int i=0;i< distanceArray.length;i++)
            distanceArray[i] = 100000;

        visitedArray = new boolean[noOfNodes];

        //create AdjacencyList and add nodes
        for(int i=0;i<noOfNodes;i++) {
            adjList.add(new HashMap<>());
        }

        adjList.get(0).put(5, 3);

        adjList.get(1).put(2, 1);
        adjList.get(1).put(0, 2);

        adjList.get(2).put(0, 3);
        adjList.get(2).put(3, 1);
        adjList.get(2).put(5, 2);

        adjList.get(3).put(5, 2);
        adjList.get(3).put(4, 1);

        adjList.get(5).put(4, 3);

        System.out.println("Adjacency List created");

        //loop for all the components of graph and find the topoSorted elements
        for(int i=0;i<noOfNodes;i++){
            if(!visitedArray[i]){
                topoSortUsingDFS(i);
            }
        }

        System.out.println("Finding toposort is done using DFS algo");

        //Find the shortest distance by popping the elements from the stack one by one
        //Initialize the distance of last pushed element to '0' as it will be considered as source element
        distanceArray[topoStack.lastElement()] = 0;

        while(!topoStack.empty()){
            int poppedElement = topoStack.pop();
            int poppedElementWeight = distanceArray[poppedElement];

            for(Map.Entry<Integer, Integer> adjNode : adjList.get(poppedElement).entrySet()){
                int finalWeight = poppedElementWeight + adjNode.getValue();

                if(finalWeight < distanceArray[adjNode.getKey()]){
                    distanceArray[adjNode.getKey()] = finalWeight;
                }
            }
        }

        System.out.println("Shortest distance calculation is completed");
    }

    /**
     *This method will run DFS algo recursively and push the elements to stack
     * once the dfs call for particular element is completed
     * @param node
     */
    private static void topoSortUsingDFS(int node) {
        //mark the element as visited in the visited array
        visitedArray[node] = true;

        for (int adjNode : adjList.get(node).keySet()){
            if(!visitedArray[adjNode]){
                topoSortUsingDFS(adjNode);
            }
        }

        //once call is done push the element to the stack
        topoStack.push(node);
    }
}

