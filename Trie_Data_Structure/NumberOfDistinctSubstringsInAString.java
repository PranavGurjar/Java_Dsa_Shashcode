package Trie_Data_Structure;

public class NumberOfDistinctSubstringsInAString {
    public static void main(String[] args) {
        String s = "aabbaba";
        int countDistinct = countDistinct(s);
        System.out.println("countDistinct \""+s+"\": "+countDistinct);
    }

    static class TrieNode {
        TrieNode[]trieNode;
        public TrieNode() {
            this.trieNode = new TrieNode[26];
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
    }
    public static int countDistinct(String s){
        TrieNode root = new TrieNode();
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            TrieNode temp = root;
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (!temp.containsChar(ch)){
                    temp.add(ch);
                    count++;
                }
                temp = temp.getChar(ch);
            }
        }
        return count;
    }
}