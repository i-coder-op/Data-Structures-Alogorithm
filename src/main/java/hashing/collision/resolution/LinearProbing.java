package hashing.collision.resolution;

import java.util.ArrayList;

public class LinearProbing {
    public String[] hashTable;
    public int usedCells;

    public LinearProbing(int size){
        this.hashTable = new String[size];
    }

    public static void main(String[] args){
        LinearProbing linearProbing = new LinearProbing(10);
        linearProbing.insertWord2HashTable("quick");
        linearProbing.insertWord2HashTable("brown");
        linearProbing.insertWord2HashTable("fox");
        linearProbing.insertWord2HashTable("shivam");
        linearProbing.insertWord2HashTable("shubham");
        linearProbing.insertWord2HashTable("surbhi");
        linearProbing.insertWord2HashTable("harshal");
        linearProbing.insertWord2HashTable("amit");
        linearProbing.insertWord2HashTable("sunny");

        linearProbing.displayHashTable();

        linearProbing.searchWord("shivam");

        linearProbing.deleteWord("amit");

        linearProbing.displayHashTable();
    }

    /**
     * This method will delete the word from the hashTable
     * @param word
     */
    private void deleteWord(String word) {
        int hashKey = getHashKey(word, hashTable.length);
        for(int i = hashKey;i<(hashKey+hashTable.length);i++){
            int newHashKey = i % hashTable.length;
            if (null != hashTable[newHashKey] && word.equals(hashTable[newHashKey])) {
                hashTable[newHashKey] = null;
                System.out.println(word + " deleted from " + newHashKey);
                usedCells--;
                return;
            }
        }
        System.out.println(word + " not found in the hashTable");
    }

    /**
     * This method will search the word in the hashTable
     * @param word
     */
    private void searchWord(String word) {
        int hashKey = getHashKey(word, hashTable.length);
        for(int i = hashKey;i<(hashKey+hashTable.length);i++){
            int newHashKey = i % hashTable.length;
            if (null != hashTable[newHashKey] && word.equals(hashTable[newHashKey])) {
                System.out.println(word + " found at " + newHashKey);
                return;
            }
        }
        System.out.println(word + " not found in the hashTable");
    }

    private void displayHashTable() {
        System.out.println("HashKey  |  Word");
        for(int i = 0; i<hashTable.length; i++){
            System.out.println(i + " -> " + hashTable[i]);
        }
    }

    /**
     * Insert a word in the hashTable
     * @param word
     */
    private void insertWord2HashTable(String word) {

        double loadFactor = getLoadFactor(hashTable.length);
        if(loadFactor > 0.75){
            performRehashing(word);
        }else{
            int hashKey = getHashKey(word, hashTable.length);
            for(int i = hashKey;i<(hashKey+hashTable.length);i++){
                int newHashKey = i % hashTable.length;
                if(null == hashTable[newHashKey]){
                    hashTable[newHashKey] = word;
                    System.out.println(word + " inserted at " + newHashKey);
                    usedCells++;
                    break;
                }else{
                    System.out.println(newHashKey + " cell is occupied, so trying next cell");
                }
            }
        }
    }

    /**
     * This method will be responsible to perform rehashing of load factor is greater than 0.75
     * @param word
     */
    private void performRehashing(String word) {
        usedCells = 0;
        ArrayList<String> list = new ArrayList<>();
        for(String entry : hashTable){
            if(null != entry){
                list.add(entry);
            }
        }
        list.add(word);
        hashTable = new String[hashTable.length*2];
        list.stream().forEach(s -> insertWord2HashTable(s));
    }

    /**
     * Utility method to calculate and return the hashKey for the word
     * @param word
     * @return hashKey
     */
    public int getHashKey(String word, int hashTableSize){
        int sum = 0;
        for (int i=0;i<word.length();i++){
            sum = sum + word.charAt(i);
        }
        return sum % hashTableSize;
    }

    /**
     * Utility method to calculate the load factor and based on that will expand the array size by double and perform rehashing
     * @param hashTableSize
     * @return loadFactor
     */
    public Double getLoadFactor(int hashTableSize){
        return (usedCells * 1.0)/hashTableSize;
    }
}
