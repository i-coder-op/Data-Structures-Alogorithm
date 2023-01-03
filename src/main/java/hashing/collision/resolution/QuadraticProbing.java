package hashing.collision.resolution;

import java.util.ArrayList;
import java.util.List;

public class QuadraticProbing {
    public int usedCells;
    public String[] hashTable;

    public QuadraticProbing(int size){
        this.hashTable = new String[size];
        this.usedCells = 0;
    }

    public static void main(String[] args){
        QuadraticProbing quadraticProbing = new QuadraticProbing(12);

        quadraticProbing.insertWord2HashTable("quick");
        quadraticProbing.insertWord2HashTable("brown");
        quadraticProbing.insertWord2HashTable("fox");
        quadraticProbing.insertWord2HashTable("shivam");
        quadraticProbing.insertWord2HashTable("shubham");
        quadraticProbing.insertWord2HashTable("surbhi");
        quadraticProbing.insertWord2HashTable("harshal");
        quadraticProbing.insertWord2HashTable("amit");
        quadraticProbing.insertWord2HashTable("manit");
        quadraticProbing.insertWord2HashTable("ganit");
        quadraticProbing.insertWord2HashTable("hanit");
        quadraticProbing.insertWord2HashTable("munny");
        quadraticProbing.displayHashTable();
        quadraticProbing.deleteWord("manty");
        quadraticProbing.deleteWord("manit");
        quadraticProbing.deleteWord("munny");
        quadraticProbing.displayHashTable();
    }

    /**
     * Generate the hashKey for the word
     * @param word
     * @return hashKey
     */
    public int getHashKey(String word){
        int sum = 0;
        for (int i = 0;i<word.length();i++){
            sum = sum + word.charAt(i);
        }
        return sum % hashTable.length;
    }

    /**
     * Utility method to get the load factor
     * @return
     */
    public double getLoadFactor(){
        return (usedCells * 1.0)/hashTable.length;
    }

    /**
     * This method will perform rehashing and increase the size of hashTable by 2 if load factor is greater than 0.75
     * @param word
     */
    public void performRehashing(String word){
        usedCells = 0;
        List<String> tempList = new ArrayList<>();
        for(String s : hashTable){
            if(null != s){
                tempList.add(s);
            }
        }
        tempList.add(word);
        hashTable = new String[hashTable.length * 2];
        tempList.stream().forEach(s -> insertWord2HashTable(s));
    }

    /**
     * This method will be used to insert the word into the hashTable
     * @param word
     */
    private void insertWord2HashTable(String word) {
        double loadFactor = getLoadFactor();
        if(loadFactor > 0.75){
            performRehashing(word);
        }else{
            int hashKey = getHashKey(word);
            int counter = 0;
            for(int i = hashKey;i<(hashKey+hashTable.length);i++){
                int newHashKey = (i + (counter*counter)) % hashTable.length;
                if(null == hashTable[newHashKey]){
                    hashTable[newHashKey] = word;
                    System.out.println(word + " inserted at " + newHashKey);
                    usedCells++;
                    return;
                }else{
                    System.out.println(newHashKey + " is already occupied, so trying next cell");
                }
                counter++;
            }
            //If none of key works to insert the word
            performRehashing(word);
        }
    }

    private void displayHashTable() {
        System.out.println("HashKey  |  Word");
        for(int i = 0; i<hashTable.length; i++){
            System.out.println(i + " -> " + hashTable[i]);
        }
    }

    /**
     * This method will delete the word from the hashTable
     * @param word
     */
    private void deleteWord(String word) {
        int hashKey = getHashKey(word);
        int counter = 0;
        for(int i = hashKey;i<(hashKey+hashTable.length);i++){
            int newHashKey = (i + (counter*counter)) % hashTable.length;
            if (null != hashTable[newHashKey] && word.equals(hashTable[newHashKey])) {
                hashTable[newHashKey] = null;
                System.out.println(word + " deleted from " + newHashKey);
                usedCells--;
                return;
            }
        }
        System.out.println(word + " not found in the hashTable");
    }
}
