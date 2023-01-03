package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFSKahnsAlgorithm {
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static int inDegree[];
    public static Queue<Integer> topoQueue = new LinkedList<>();

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

        for (int node=1;node<=noOfNodes;node++){
            if(inDegree[node] == 0 && !topoQueue.contains(node)) {
                topoSortBFSKahnAlgo(node);
            }
        }
        topoQueue.stream().forEach(integer -> {
            System.out.print(integer);
        });
    }

    private static void topoSortBFSKahnAlgo(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            int removedNode = queue.poll();
            if(inDegree[removedNode] == 0){
                topoQueue.add(removedNode);
            }


            for (int adjNode : adjList.get(removedNode)){
                queue.add(adjNode);
                inDegree[adjNode]--;
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
