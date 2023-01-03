package tree.trie;

import java.util.Map;

/**
 * This is the trie node which has 2 fields
 * - trieNode [Map]
 * - endOfString [boolean]
 */
public class TrieNode {
    public Map<Character, TrieNode> trieMap;
    public boolean endOfString;
}
