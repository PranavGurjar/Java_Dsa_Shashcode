package Graph_Data_Structure;

import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String []wordedList = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(wordedList);

        List<List<String>> ladders = findLadders(beginWord, endWord, wordList);
        System.out.println("ladders : "+ladders);

    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)){
            return res;
        }
        List<String> dummy = new ArrayList<>();
        dummy.add(beginWord);
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(dummy);
        if (set.contains(beginWord)){
            set.remove(beginWord);
        }
        int level = 0;
        int resLevel = -1;
        //O(N*M^2*26)
        while (!queue.isEmpty()){
            HashSet<String> usedWords = new HashSet<>();
            int curLevelSize = queue.size();
            //level wise traversal
            for (int i = 0; i < curLevelSize; i++) {
                List<String> nodeList = queue.poll();
                String node = nodeList.get(nodeList.size()-1);
                if (node.equals(endWord)){
                    resLevel = level;
                    res.add(nodeList);
                }
                //adjList
                List<String> neighbours = getNeighbours(node, set);
                for (String word : neighbours){
                    if (set.contains(word)){    //cat -> bat, hat
                        nodeList.add(word);
                        queue.offer(new ArrayList<>(nodeList));
                        nodeList.remove(word);
                        usedWords.add(word);
                    }
                }
            }
            for (String visited : usedWords){
                set.remove(visited);
            }
            if (level == resLevel){
                break;
            }
            level++;
        }
        return res;
    }

    private static List<String> getNeighbours(String word, HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)){
                    continue;
                }
                String newWord = word.substring(0, i) + ch + word.substring(i+1, word.length());
                if (set.contains(newWord)){
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }
}
