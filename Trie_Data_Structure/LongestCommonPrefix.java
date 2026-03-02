package Trie_Data_Structure;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String []strs = {"flower","flow","flight"};
        String longestCommonPrefix = longestCommonPrefix(strs);
        System.out.println("longestCommonPrefix : "+longestCommonPrefix);
    }

    static class TrieNode {
        TrieNode[]trieNode;
        int count;
        public TrieNode() {
            this.trieNode = new TrieNode[26];
            this.count = 0;
        }
        boolean containsChar(char ch) {
            return trieNode[ch - 'a'] != null;
        }
        void add(char ch) {
            trieNode[ch - 'a'] = new TrieNode();
        }
        TrieNode getChar(char ch) {
            return trieNode[ch - 'a'];
        }
        void incrementCount() {
            count++;
        }
        int getCount() {
            return count;
        }
    }
    public static String longestCommonPrefix(String[] strs) {
        //insert strs in trie
        TrieNode root = new TrieNode();
        for (String word : strs){
            TrieNode temp = root;
            for (char ch : word.toCharArray()){
                if (!temp.containsChar(ch)){
                    temp.add(ch);
                }
                temp = temp.getChar(ch);
                temp.incrementCount();
            }
        }
        //check count of pref
        TrieNode temp = root;
        int n = strs.length;
        int count = 0;
        for (char ch : strs[0].toCharArray()){
            temp = temp.getChar(ch);
            if (temp.getCount() != n){
                break;
            }
            count++;
        }
        return strs[0].substring(0, count);
    }
}