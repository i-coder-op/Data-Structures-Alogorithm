package hashing.collision.resolution;

import java.util.ArrayList;
import java.util.List;

public class DoubleHashing {
    public int usedCells;
    public String[] hashTable;

    public DoubleHashing(int size){
        this.hashTable = new String[size];
    }

    public static void main(String args[]){
        DoubleHashing doubleHashing = new DoubleHashing(8);

        doubleHashing.insertWordInHashTable("quick");
        doubleHashing.insertWordInHashTable("brown");
        doubleHashing.insertWordInHashTable("fox");
        doubleHashing.insertWordInHashTable("shivam");
        doubleHashing.insertWordInHashTable("shubham");
        doubleHashing.insertWordInHashTable("surbhi");
        doubleHashing.insertWordInHashTable("harshal");
        doubleHashing.insertWordInHashTable("amit");
        doubleHashing.insertWordInHashTable("manit");
        doubleHashing.insertWordInHashTable("ganit");
        doubleHashing.insertWordInHashTable("hanit");
        doubleHashing.insertWordInHashTable("munny");

        doubleHashing.displayHashTable();
    }

    public double getLoadFactor(){
        return usedCells * 1.0/hashTable.length;
    }

    public int getHashKeyFunctionFirst(String word){
        int sum = 0;
        for (int i=0;i<word.length();i++){
            sum = sum + word.charAt(i);
        }
        return sum % hashTable.length;
    }

    public int getHashKeyFunctionSecond(String word){
        int sum = 0;
        for (int i=0;i<word.length();i++){
            sum = sum + word.charAt(i);
        }

        if(sum > hashTable.length){
            sum = addAllDigits2Gether(sum);
        }
        return sum % hashTable.length;
    }

    private int addAllDigits2Gether(int sum) {
        int value = 0;
        while(sum > 0){
            value = sum % 10;
            sum = sum / 10;
        }
        return value;
    }

    public void performRehashing(String word){
        usedCells = 0;
        List<String> list = new ArrayList<>();
        for (String existingWord : hashTable){
            if(null != existingWord)
                list.add(existingWord);
        }
        list.add(word);
        hashTable = new String[hashTable.length * 2];
        list.stream().forEach(s -> insertWordInHashTable(s));
    }

    private void insertWordInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if(loadFactor > 0.75){
            System.out.println("\n--------------------------");
            System.out.println("Word: " + word + " | Load Factor: " + loadFactor + " --> Performing Rehashing");
            System.out.println("\n--------------------------");
            performRehashing(word);
        }else{
            int firstHashKey = getHashKeyFunctionFirst(word);
            int secondHashKey = getHashKeyFunctionSecond(word);

            for (int i = firstHashKey;i<hashTable.length;i++){
                int newHashKey = (firstHashKey + (i*secondHashKey)) % hashTable.length;
                if(null == hashTable[newHashKey]){
                    hashTable[newHashKey] = word;
                    usedCells++;
                    System.out.println(word + " has been inserted at cell " + newHashKey);
                    break;
                }else{
                    System.out.println(newHashKey + " cell is occupied, trying new cell...");
                }
            }
        }
    }

    private void displayHashTable() {
        System.out.println("HashKey  |  Word");
        for(int i = 0; i<hashTable.length; i++){
            System.out.println(i + " -> " + hashTable[i]);
        }
    }
}
