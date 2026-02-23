package Tree_Data_Structure.Heap_And_PriorityQueue;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "Aabb"; //"tree";
        String frequencySort = frequencySort(s);
        System.out.println("frequencySort : "+frequencySort);
    }

    static class Element implements Comparable<Element>{
        char ch;
        int freq;

        public Element(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(Element that) {
            return that.freq - this.freq;       //dec
        }
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            Element element = new Element(entry.getKey(), entry.getValue());
            pq.offer(element);
        }
        //gen res
        StringBuilder str = new StringBuilder();
        while (pq.size() > 0){
            Element element = pq.poll();
            while (element.freq > 0){
                str.append(element.ch);
                element.freq--;
            }
        }
        return str.toString();
    }
}