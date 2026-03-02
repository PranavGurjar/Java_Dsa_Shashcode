package Trie_Data_Structure;

public class CountingWordsWithAGivenPrefix {
    public static void main(String[] args) {
        String []words = {"pay","attention","practice","attend"};
        String pref = "at";
        int prefixCount = prefixCount(words, pref);
        System.out.println("prefixCount : "+prefixCount);
    }

    static class TrieNode {
        TrieNode []trieNode;
        int count;

        public TrieNode() {
            //c -> c-a -> 2
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

    public static int prefixCount(String[] words, String pref) {
        //insert word in trie
        TrieNode root = new TrieNode();
        for (String word : words){
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
        for (char ch : pref.toCharArray()){
            if (!temp.containsChar(ch)){
                return 0;
            }
            temp = temp.getChar(ch);
        }
        return temp.getCount();
    }
}