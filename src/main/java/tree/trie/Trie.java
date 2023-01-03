package tree.trie;

import java.util.HashMap;

/**
 * Trie implementation By Shivam Kale
 */
public class Trie {
    public TrieNode root;

    public Trie(){
        this.root = new TrieNode();
        this.root.trieMap = new HashMap<>();
        this.root.endOfString = false;
        System.out.println("Empty Trie has been created");
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        //Insertion Operation - insert a string in the trie form

        trie.insertString(trie.root, "SHIVAM");
        trie.insertString(trie.root, "KALE");

        //Search a String in the trie
        trie.searchString(trie.root, "HARSHAL");
    }

    /**
     * This method will be responsible for searching a string in trie
     * @param root
     * @param searchString
     */
    private void searchString(TrieNode root, String searchString) {
        TrieNode currentNode = root;
        int matchedCharaters = -1;
        for(int index=0;index<searchString.length();index++){
            Character character = searchString.charAt(index);
            if(currentNode.trieMap.containsKey(character)){
                currentNode = currentNode.trieMap.get(character);
                matchedCharaters++;
            }else{
                if(matchedCharaters>0){
                    System.out.println("For " + searchString + " " + matchedCharaters + " characters are present");
                }else
                    System.out.println(searchString + " is not present in trie");
                return;
            }
        }
        if(currentNode.endOfString){
            System.out.println(searchString + " is present in trie");
        }else{
            if(matchedCharaters>0){
                System.out.println("For " + searchString + " " + matchedCharaters + " characters are present");
            }else {
                System.out.println(searchString + " is present as prefix for some other string in trie");
            }
        }
    }

    /**
     * This method will be responsible to insert a string as trie
     * @param root
     * @param string
     */
    private void insertString(TrieNode root, String string) {
        TrieNode currentNode = root;
        for (int index = 0; index<string.length(); index++){
            Character character = string.charAt(index);

            TrieNode isCharPresent = currentNode.trieMap.get(character);
            if(null != isCharPresent){
                currentNode = currentNode.trieMap.get(character);
                continue;
            }

            TrieNode nextNode = new TrieNode();
            nextNode.trieMap = new HashMap<>();
            currentNode.trieMap.put(character, nextNode);
            currentNode.endOfString = false;
            currentNode = nextNode;
        }
        currentNode.endOfString = true;
        System.out.println(string + " has been inserted in trie");
    }
}
