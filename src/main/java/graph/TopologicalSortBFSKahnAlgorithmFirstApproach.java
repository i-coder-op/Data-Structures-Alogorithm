package graph;

import java.util.*;

public class TopologicalSortBFSKahnAlgorithmFirstApproach {
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static int[] topoArray;
    public static int[] inDegree;

    public static void main(String[] args){
        int noOfNodes = 6;

        inDegree = new int[noOfNodes+1];

        //Create AdjacencyList
        adjList = createAdjList(noOfNodes);

        //Assign inDegree for each node
        for (int node=1;node< inDegree.length;node++){
            for (int i=1;i<=noOfNodes;i++){
                if(adjList.get(i).contains(node)){
                    inDegree[node] = inDegree[node] + 1;
                }
            }
        }

        //Perform topological sort
        performTopoSortKahnsAlgorithm(noOfNodes);

        //Print topo sort array
        Arrays.stream(topoArray).forEach(value -> System.out.print(value + " "));

    }

    /**
     * This method demonstrate the topo sort using kahn's algorithm and it uses BFS approach
     * @param noOfNodes
     */
    private static void performTopoSortKahnsAlgorithm(int noOfNodes) {
        Queue<Integer> queue = new LinkedList<>();
        topoArray = new int[noOfNodes+1];

        //Insert all the nodes which has indegree as '0'
        for(int node=1;node<inDegree.length;node++){
            if (inDegree[node] == 0){
                queue.add(node);
            }
        }

        int nodeNumber = 0;
        while(!queue.isEmpty()){
            int removedNode = queue.poll();
            topoArray[nodeNumber++] = removedNode;

            for (int adjNode : adjList.get(removedNode)){
                //decrement the degree of adjacent node and if its degree becomes 0 then store in the queue
                inDegree[adjNode] = inDegree[adjNode] - 1;
                if(inDegree[adjNode] == 0){
                    queue.add(adjNode);
                }
            }
        }
    }

    private static List<List<Integer>> createAdjList(int noOfNodes) {
        for (int i=0;i<=noOfNodes;i++){
            adjList.add(new ArrayList<>());
        }

        adjList.get(2).add(1);
        adjList.get(2).add(6);

        adjList.get(3).add(4);

        adjList.get(5).add(1);
        adjList.get(5).add(3);

        adjList.get(6).add(4);

        return adjList;
    }
}
