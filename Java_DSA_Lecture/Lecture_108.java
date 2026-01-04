import java.util.*;

//
//class MyCollege{
//    int regNo;
//    private int hashCode;
//    public MyCollege(int regNo) {
//        this.regNo = regNo;
//        this.hashCode = Objects.hashCode(regNo);
//    }
//
//    @Override
//    public int hashCode() {
//        return hashCode;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        MyCollege college = (MyCollege) obj;
//        return this.regNo == college.regNo;
//    }
//}
//
//class MyRanking{
//    int rank;
//
//    public MyRanking(int rank) {
//        this.rank = rank;
//    }
//
//    @Override
//    public String toString() {
//        return ""+this.rank;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        MyRanking r = (MyRanking) obj;
//        return this.rank == r.rank;
//    }
//}

//class YHashMap<K, V>{
//    class Node{
//        K key;
//        V value;
//
//        public Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        @Override
//        public String toString() {
//            return key+" : "+value;
//        }
//    }
//
//    private LinkedList<Node> hashTable[];
//    private int tableSize;
//    private int element;
//    private double threshold;
//
//    YHashMap(){
//        element = 0;
//        threshold = 0.75;
//        tableSize = 16;
//        hashTable = new LinkedList[tableSize];
//        initializeHashMap();
//    }
//
//    private void initializeHashMap() {
//        for (int i = 0; i < tableSize; i++) {
//            hashTable[i] = new LinkedList<>();
//        }
//    }
//
//    public void put(K key, V value){
//        int hashcode = getHashCode(key);
//        int index = searchKeyInList(key, hashcode);
//        Node node = new Node(key, value);
//
//        if (index == -1){
//            hashTable[hashcode].add(0, node);
//            element++;
//        }
//        else {
//            hashTable[hashcode].get(index).value = value;
//        }
//
//        if (element/(double)tableSize >= threshold){
//            rehash();
//        }
//    }
//
//    public V get(K key){
//        int hashcode = getHashCode(key);
//        int index = searchKeyInList(key, hashcode);
//
//        if (index == -1){
//            return null;
//        }
//        else {
//            return hashTable[hashcode].get(index).value;
//        }
//    }
//
//    public boolean containsKey(K key){
//        int hashcode = getHashCode(key);
//        int index = searchKeyInList(key, hashcode);
//
//        if (index == -1){
//            return false;
//        }
//        else {
//            return true;
//        }
//    }
//
//    public boolean containsValue(V value){
//        for (int i = 0; i < tableSize; i++) {
//            for (Node node : hashTable[i]){
//                if (node.value.equals(value)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean isEmpty(){
//        return (element == 0);
//    }
//
//    public int size(){
//        return element;
//    }
//
//    public void iterate(){
//        for (int i = 0; i < tableSize; i++) {
//            for (Node node : hashTable[i]){
//                System.out.println(node);
//            }
//        }
//    }
//
//    public V remove(K key){
//        int hashcode = getHashCode(key);
//        int index = searchKeyInList(key, hashcode);
//
//        if (index == -1){
//            return null;
//        }
//        else {
//            V value = hashTable[hashcode].get(index).value;
//            hashTable[hashcode].remove(index);
//            element--;
//            return value;
//        }
//    }
//
//    private void rehash() {
//        LinkedList<Node> oldTable[] = hashTable;
//        tableSize = 2 * tableSize;
//        element = 0;
//        hashTable = new LinkedList[tableSize];
//        initializeHashMap();
//
//        for(LinkedList<Node> list : oldTable){
//            for (Node node : list){
//                put(node.key, node.value);
//            }
//        }
//    }
//
//    private int searchKeyInList(K key, int hashcode) {
//        LinkedList<Node> list = hashTable[hashcode];
//        for (int index = 0; index < list.size(); index++) {
//            if (list.get(index).key.equals(key)){
//                return index;
//            }
//        }
//        return -1;
//    }
//
//    private int getHashCode(K key) {
//        int hashcode = Objects.hash(key);
//        hashcode = (Math.abs(hashcode)) % tableSize;
//        return hashcode;
//    }
//}

class MyHashMap<K, V>{
    class HashNode{
        K key;
        V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key +" : "+ value;
        }
    }

    private LinkedList<HashNode> hashTable[];
    private int element;
    private int tableSize;
    private double threshold;

    MyHashMap(){
        element = 0;
        tableSize = 16;     //java collection default size
        threshold = 0.75;   //default
        hashTable = new LinkedList[tableSize];
        initializeHashTable();
    }

    private void initializeHashTable() {
        for (int i = 0; i < tableSize; i++){
            hashTable[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value){
        //find the hashcode
        int hashcode = getHashCode(key);
        int index = searchKeyInList(key, hashcode);
        HashNode node = new HashNode(key, value);
        if (index == -1){
            //insert
            hashTable[hashcode].add(0, node);
            element++;
        }
        else {
            //update
            hashTable[hashcode].get(index).value = value;
        }

        if (element/(double)tableSize >= threshold){
            rehash();  //tablesize expand for the data element //table ka develope karo and data copy karo
        }
    }

    public V get(K key){
        //find the hashcode
        int hashcode = getHashCode(key);
        int index = searchKeyInList(key, hashcode);
        if (index == -1){
            return null;
        }
        else {
            return hashTable[hashcode].get(index).value;
        }
    }

    public boolean containsKey(K key){
        //find the hashcode
        int hashcode = getHashCode(key);
        int index = searchKeyInList(key, hashcode);
        if (index == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean containsValue(V value){
        for (int i = 0; i < tableSize; i++) {
            for(HashNode node : hashTable[i]){
                if (node.value.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public V remove(K key){
        //find the hashcode
        int hashcode = getHashCode(key);
        int index = searchKeyInList(key, hashcode);
        if (index == -1){
            return null;
        }
        else {
            V value = hashTable[hashcode].get(index).value;
            hashTable[hashcode].remove(index);
            element--;
            return value;
        }
    }

    public boolean isEmpty(){
        return (element == 0);
    }

    public int size(){
        return element;
    }

    public void iterate(){
        for (int i = 0; i < tableSize; i++) {
            for(HashNode node : hashTable[i]){
                System.out.println(node);
            }
        }
    }

    private void rehash() {
        LinkedList<HashNode> oldTable[] = hashTable;
        tableSize = 2 * tableSize;
        element = 0;
        hashTable = new LinkedList[tableSize];
        initializeHashTable();

        for (LinkedList<HashNode> list : oldTable){
            for (HashNode node : list){
                put(node.key, node.value);
            }
        }
    }

    private int searchKeyInList(K key, int hashcode) {
        LinkedList<HashNode> list = hashTable[hashcode];
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).key.equals(key)){
                return index;
            }
        }
        return -1;
    }

    private int getHashCode(K key) {
        int hashcode = Objects.hash(key);
        hashcode = (Math.abs(hashcode))%tableSize;
        return hashcode;
    }



}


public class Lecture_108 {
    public static void main(String[] args) {
//        MyHashMap<Integer, String> myMap = new MyHashMap<>();
//        myMap.put(1, "Shashwat");
//        myMap.put(2, "Ayush");
//        myMap.put(3, "Shivansh");
//        System.out.println(myMap.get(2));
//        myMap.put(2, "Aashray");
//        System.out.println(myMap.get(2));
//
//        System.out.println(myMap.isEmpty());
//        System.out.println(myMap.containsKey(1));
//        System.out.println(myMap.containsKey(5));
//        System.out.println(myMap.containsValue("Shivansh"));
//        System.out.println(myMap.containsValue("Om"));
//        myMap.iterate();
//
//        System.out.println(myMap.remove(2));
//        System.out.println(myMap.remove(4));
//        myMap.iterate();
//
//        System.out.println(myMap.size());

        MyHashMap<Integer, Integer> collegeRankingMap1 = new MyHashMap<>();
        collegeRankingMap1.put(111, 1);
        collegeRankingMap1.put(312, 2);
        collegeRankingMap1.put(457, 3);
        System.out.println(collegeRankingMap1.get(111));
        System.out.println(collegeRankingMap1.containsValue(1));

        MyHashMap<MyCollege, MyRanking> collegeRankingMap2 = new MyHashMap<>();
        collegeRankingMap2.put(new MyCollege(111), new MyRanking(1));
        collegeRankingMap2.put(new MyCollege(312), new MyRanking(2));
        collegeRankingMap2.put(new MyCollege(457), new MyRanking(3));
        System.out.println(collegeRankingMap2.get(new MyCollege(111)));
        System.out.println(collegeRankingMap2.containsValue(new MyRanking(1)));

    }
}

