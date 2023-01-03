package graph;

import java.util.Arrays;
import java.util.Base64;

/**
 * Floyd Warshall Algo is used to find the shortest path.
 * Used to find shortest path from multi source to destination.
 * it takes TC - O(n^3) & SC - (n^2).
 * we can find the shortest path from multi source to destination using the Dijkstra algorithm as well.
 * Floyd Warshall can be used to find the negative cycle in the graph
 * In this algorithm we will be using the Adjacency matrix not the adjacency list.
 */
public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        //Defined an undefined/infinite value which node is not reachable
        int u = (int)1e9;

        //Creating an adjacency matrix
        int[][] adjMatrix = new int[][]{
                {0,2,u,u},
                {1,0,3,u},
                {u,u,0,u},
                {3,5,4,0}
        };
        int adjMatrixLength = adjMatrix.length;
        for(int via=0;via<adjMatrixLength;via++){
            for (int i=0;i<adjMatrixLength;i++){
                for (int j=0;j<adjMatrixLength;j++){
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][via] + adjMatrix[via][j]);
                }
            }
        }

        System.out.println("Shortest path from multi-source to multi-destination");
        for (int i=0;i<adjMatrixLength;i++){
            for (int j=0;j<adjMatrixLength;j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }

        for (int i=0;i<adjMatrixLength;i++){
            if(adjMatrix[i][i] < 0){
                System.out.println("Negative cycle is present in graph");
                break;
            }
        }
    }
}
