package hashing.collision.resolution;

import java.util.LinkedList;

/**
 * This is the implementation of collision resolution technique i.e. Direct Chaining
 */
public class DirectChaining {
    LinkedList<String>[] hashTable;

    public DirectChaining(int size){
       this.hashTable = new LinkedList[size];
    }

    public static void main(String[] args){
        DirectChaining directChaining = new DirectChaining(15);
        directChaining.insertStringInHashTable(directChaining.hashTable, "shivam");
        directChaining.insertStringInHashTable(directChaining.hashTable, "surbhi");
        directChaining.insertStringInHashTable(directChaining.hashTable, "shubham");
        directChaining.insertStringInHashTable(directChaining.hashTable, "harshal");
        directChaining.insertStringInHashTable(directChaining.hashTable, "shivam");

        directChaining.searchStringInHashTable("shivam");
        directChaining.searchStringInHashTable("sasdad");

        directChaining.displayHashTable();

        directChaining.deleteStringFromHashTable(directChaining.hashTable, "shubham");

        directChaining.displayHashTable();
    }

    /**
     * This method will be responsible to delete the string from the hash table
     * @param hashTable
     * @param word
     */
    private void deleteStringFromHashTable(LinkedList<String>[] hashTable, String word) {
        int hashKey = getHashValueForString(word, hashTable.length);
        if(null == hashTable[hashKey]){
            System.out.println(word + " not found in hashTable");
        }else{
            if(null != hashTable[hashKey]){
                if(hashTable[hashKey].contains(word)){
                    if(hashTable[hashKey].size() == 1){
                        hashTable[hashKey] = null;
                    }else{
                        hashTable[hashKey].remove(word);
                    }
                    System.out.println(word + " has been delete from hashTable");
                }else{
                    System.out.println(word + " not found in hashTable");
                }
            }
        }
    }

    /**
     * Utility method to search word/string in hashTable
     * @param word
     */
    private void searchStringInHashTable(String word) {
        int hashKey = getHashValueForString(word, hashTable.length);
        if(null == hashTable[hashKey]){
            System.out.println(word + " not found in hashTable");
        }else{
            if(null != hashTable[hashKey]){
                if(hashTable[hashKey].contains(word)){
                    System.out.println(word + " found in hashTable");
                }else{
                    System.out.println(word + " not found in hashTable");
                }
            }
        }
    }

    /**
     * Utility method to display elements inside the hashTable
     */
    private void displayHashTable() {
        System.out.println("----------- HashTable ------------");
        System.out.println("Key " + "Value");
        for(int i=0;i<hashTable.length;i++){
            System.out.println((i+1) + " -> " + hashTable[i]);
        }
    }

    /**
     * This method will be responsible to insert a string in the hash table
     * @param hashTable
     * @param word
     */
    private void insertStringInHashTable(LinkedList<String>[] hashTable, String word) {
        int hashKey = getHashValueForString(word, hashTable.length);
        if(hashKey <= hashTable.length){
            if(null != hashTable[hashKey]){
                if(hashTable[hashKey].contains(word)){
                    System.out.println(word + " already present at " + hashKey + " location in hash table");
                    return;
                }
                hashTable[hashKey].add(word);
            }else{
                LinkedList<String> list = new LinkedList<>();
                list.add(word);
                hashTable[hashKey] = list;
            }
            System.out.println(word + " has been inserted at " + hashKey + " location in hash table");
        }
    }

    /**
     * This is actually a hashFunction which will take input as a string and process that then return an integer value for string
     * @param word
     * @param hashTableSize
     * @return
     */
    public int getHashValueForString(String word, int hashTableSize){
        int hashValue = 0;
        for(int i=0;i<word.length();i++){
            hashValue = hashValue + word.charAt(i);
        }
        return hashValue % hashTableSize;
    }
}
