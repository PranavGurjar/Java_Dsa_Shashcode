package Trie_Data_Structure;

public class ImplementTrie_Prefix_Tree {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println("search \"apple\" is present : "+t.search("apple"));
        System.out.println("search \"app\" is present : "+t.search("app"));
        System.out.println("starts with \"app\" is present : "+t.startsWith("app"));
        t.insert("app");
        System.out.println("search \"app\" is present : "+t.search("app"));
    }

    static class TrieNode {
        TrieNode trieNode[];
        boolean wordEnd;

        public TrieNode() {
            //c -> c-a -> 2
            this.trieNode = new TrieNode[26];
            this.wordEnd = false;
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

        void markWordEnd() {
            wordEnd = true;
        }

        boolean isWord() {
            return wordEnd;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.containsChar(ch)) {
                    temp.add(ch);
                }
                temp = temp.getChar(ch);
            }
            temp.markWordEnd();
        }

        public boolean search(String word) {
            TrieNode temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.containsChar(ch)) {
                    return false;
                }
                temp = temp.getChar(ch);
            }
            return temp.isWord();
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            for (char ch : prefix.toCharArray()) {
                if (!temp.containsChar(ch)) {
                    return false;
                }
                temp = temp.getChar(ch);
            }
            return (temp != null);
        }
    }
}