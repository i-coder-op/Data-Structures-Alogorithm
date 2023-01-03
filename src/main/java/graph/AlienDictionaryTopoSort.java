package graph;

import java.util.*;

public class AlienDictionaryTopoSort {
    public static String[] alienWords = {"baa", "abcd", "abca", "cab", "cad"};
    public static int noOfAlphabets = 4;
    public static int[] inDegree = new int[noOfAlphabets];
    public static Map<Character, Integer> alphabetMap = new HashMap<>();
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static int[] alienOrderArray = new int[noOfAlphabets];

    public static void main(String[] args){
        //Initialize alphabets map
        alphabetMap.put('a', 0);
        alphabetMap.put('b', 1);
        alphabetMap.put('c', 2);
        alphabetMap.put('d', 3);

        //Creating the adjList
        for(int i=0;i<noOfAlphabets;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0;i< alienWords.length-1;i++){
           String s1 = alienWords[i];
           String s2 = alienWords[i+1];

           int size = Math.max(s1.length(), s2.length());

           for(int k = 0;k<size;k++){
               if(s1.charAt(k) != s2.charAt(k)){
                 adjList.get(alphabetMap.get(s1.charAt(k))).add(alphabetMap.get(s2.charAt(k)));
                 break;
               }
           }
        }

        //find indegree
        for(int i=0;i<noOfAlphabets;i++){
            int inDegreeValue = 0;
            for(int j = 0;j< adjList.size();j++){
                for (int adjNode : adjList.get(j)){
                    if(adjNode == i){
                        inDegreeValue++;
                    }
                }
            }
            inDegree[i] = inDegreeValue;
        }

        callTopoUsingKahnBFSAlgo();
    }

    private static void callTopoUsingKahnBFSAlgo() {
        //add all the '0' indegree to temp queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i< inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int removedNode = queue.poll();
            alienOrderArray[index] = removedNode;
            index++;
            for (int adjNode : adjList.get(removedNode)){
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0){
                    queue.add(adjNode);
                }
            }
        }
        System.out.println("");
    }
}
