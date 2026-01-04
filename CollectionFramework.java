import java.util.*;

class Student{
    public int rollNo;
    public String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public String toString(){
        return (rollNo +" : "+name);
    }
}

class MyCollege{
    int regNo;
    private int hashCode;
    public MyCollege(int regNo) {
        this.regNo = regNo;
        this.hashCode = Objects.hashCode(regNo);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        MyCollege college = (MyCollege) obj;
        return this.regNo == college.regNo;
    }
}

class MyRanking{
    int rank;

    public MyRanking(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return ""+this.rank;
    }

    @Override
    public boolean equals(Object obj) {
        MyRanking r = (MyRanking) obj;
        return this.rank == r.rank;
    }
}


public class CollectionFramework {
    public static void main(String[] args) {
//        //List --> interface
//        arrayLists();
//        linkedList();
//        stacks();
//        studentList();

//        //Queue --> interface
//        arrayDeque();
//        priorityQueue();
//        linkedListQueue();


//        //Set --> interface
//        treeSet();
//        hashSet();
//        linkedHashSet();


//        //Map --> interface
//        treeMap();
//        hashMap1();
        hashMap2();
//        linkedHashMap();

    }

    public static void linkedHashMap(){
        Map<Integer, String> classMap = new LinkedHashMap<>();
//        classMap.put(1,"Shashwat");
//        classMap.put(2,"Ayush");
//        classMap.put(1,"Pavleen");
//        classMap.put(1,"Aashray");
//        classMap.put(1,"Tridib");


        classMap.put(1,"Shashwat");
        classMap.put(2,"Ayush");
        classMap.put(3,"Pavleen");
        classMap.put(4,"Aashray");
        classMap.put(5,"Tridib");

        System.out.println(classMap);
        classMap.putIfAbsent(1,"Pavleen");

        System.out.println(classMap.get(4));
        System.out.println(classMap.get(6));
        System.out.println(classMap.getOrDefault(6, "No One"));

        System.out.println(classMap.containsKey(4));
        System.out.println(classMap.containsValue("Shashwat"));

        for (Map.Entry<Integer, String> entry : classMap.entrySet()){
            System.out.println("Key : "+entry.getKey()+" , Value : "+entry.getValue());
        }

        for (Integer key : classMap.keySet()){
            System.out.println("Key : "+key);
        }

        for (String value : classMap.values()){
            System.out.println("Value : "+value);
        }
    }

    public static void hashMap2(){
        Map<Integer, Integer> collegeRankingMap1 = new HashMap<>();
        collegeRankingMap1.put(111, 1);
        collegeRankingMap1.put(312, 2);
        collegeRankingMap1.put(457, 3);
        System.out.println(collegeRankingMap1.get(111));
        System.out.println(collegeRankingMap1.containsValue(1));

        Map<MyCollege, MyRanking> collegeRankingMap2 = new HashMap<>();
        collegeRankingMap2.put(new MyCollege(111), new MyRanking(1));
        collegeRankingMap2.put(new MyCollege(312), new MyRanking(2));
        collegeRankingMap2.put(new MyCollege(457), new MyRanking(3));
//        System.out.println(collegeRankingMap2.get(111));
        System.out.println(collegeRankingMap2.get(new MyCollege(111)));
        System.out.println(collegeRankingMap2.containsValue(1));
        System.out.println(collegeRankingMap2.containsValue(new MyRanking(1)));
    }

    public static void hashMap1(){
        Map<Integer, String> classMap = new HashMap<>();
//        classMap.put(1,"Shashwat");
//        classMap.put(2,"Ayush");
//        classMap.put(1,"Pavleen");
//        classMap.put(1,"Aashray");
//        classMap.put(1,"Tridib");


        classMap.put(1,"Shashwat");
        classMap.put(2,"Ayush");
        classMap.put(3,"Pavleen");
        classMap.put(4,"Aashray");
        classMap.put(5,"Tridib");

        System.out.println(classMap);

        classMap.put(2, "Shivansh");
        System.out.println(classMap);

        classMap.replace(6, "Raj");
        System.out.println(classMap);

        classMap.putIfAbsent(1,"Pavleen");

        System.out.println(classMap.get(4));
        System.out.println(classMap.get(6));
        System.out.println(classMap.getOrDefault(6, "No One"));

        System.out.println(classMap.containsKey(4));
        System.out.println(classMap.containsValue("Shashwat"));

        for (Map.Entry<Integer, String> entry : classMap.entrySet()){
            System.out.println("Key : "+entry.getKey()+" , Value : "+entry.getValue());
        }

        for (Integer key : classMap.keySet()){
            System.out.println("Key : "+key);
            System.out.println("Value : "+classMap.get(key));
        }

        for (String value : classMap.values()){
            System.out.println("Value : "+value);
        }
    }

    public static void treeMap(){
        Map<Integer, String> treeMap = new TreeMap<>();
//        treeMap.put(1,"Shashwat");
//        treeMap.put(2,"Ayush");
//        treeMap.put(1,"Pavleen");
//        treeMap.put(1,"Aashray");
//        treeMap.put(1,"Tridib");


//        treeMap.put(1,"Shashwat");
//        treeMap.put(2,"Ayush");
//        treeMap.put(3,"Pavleen");
//        treeMap.put(4,"Aashray");
//        treeMap.put(5,"Tridib");


        treeMap.put(1,"Shashwat");
        treeMap.put(7,"Ayush");
        treeMap.putIfAbsent(3,"Pavleen");
        treeMap.putIfAbsent(2,"Aashray");
        treeMap.putIfAbsent(11,"Tridib");
        System.out.println(treeMap);

        treeMap.put(1,treeMap.getOrDefault(1,"NO ONE")+" Tiwari");
        System.out.println(treeMap);


        treeMap.put(6,treeMap.getOrDefault(6,"NO ONE")+" Tiwari");
        System.out.println(treeMap);

        treeMap.putIfAbsent(1,"Pavleen");

        System.out.println(treeMap.get(4));
        System.out.println(treeMap.get(6));
        System.out.println(treeMap.getOrDefault(6, "No One"));

        System.out.println(treeMap.containsKey(4));
        System.out.println(treeMap.containsValue("Shashwat"));

        for (Map.Entry<Integer, String> entry : treeMap.entrySet()){
            System.out.println("Key : "+entry.getKey()+" , Value : "+entry.getValue());
        }

        for (Integer key : treeMap.keySet()){
            System.out.println("Key : "+key);
        }

        for (String value : treeMap.values()){
            System.out.println("Value : "+value);
        }


        System.out.println("***************************************************************************");
        Map<Integer, String> revTreeMap = new TreeMap<>(Collections.reverseOrder());
//        revTreeMap.put(1,"Shashwat");
//        revTreeMap.put(2,"Ayush");
//        revTreeMap.put(1,"Pavleen");
//        revTreeMap.put(1,"Aashray");
//        revTreeMap.put(1,"Tridib");


//        revTreeMap.put(1,"Shashwat");
//        revTreeMap.put(2,"Ayush");
//        revTreeMap.put(3,"Pavleen");
//        revTreeMap.put(4,"Aashray");
//        revTreeMap.put(5,"Tridib");


        revTreeMap.put(1,"Shashwat");
        revTreeMap.put(7,"Ayush");
        revTreeMap.putIfAbsent(3,"Pavleen");
        revTreeMap.putIfAbsent(2,"Aashray");
        revTreeMap.putIfAbsent(11,"Tridib");
        System.out.println(revTreeMap);

        revTreeMap.put(1,revTreeMap.getOrDefault(1,"NO ONE")+" Tiwari");
        System.out.println(revTreeMap);


        revTreeMap.put(6,revTreeMap.getOrDefault(6,"NO ONE")+" Tiwari");
        System.out.println(revTreeMap);


        revTreeMap.putIfAbsent(1,"Pavleen");

        System.out.println(revTreeMap.get(4));
        System.out.println(revTreeMap.get(6));
        System.out.println(revTreeMap.getOrDefault(6, "No One"));

        System.out.println(revTreeMap.containsKey(4));
        System.out.println(revTreeMap.containsValue("Shashwat"));

        for (Map.Entry<Integer, String> entry : revTreeMap.entrySet()){
            System.out.println("Key : "+entry.getKey()+" , Value : "+entry.getValue());
        }

        for (Integer key : revTreeMap.keySet()){
            System.out.println("Key : "+key);
        }

        for (String value : revTreeMap.values()){
            System.out.println("Value : "+value);
        }
    }

    public static void linkedHashSet(){

        Set<Integer> hset = new LinkedHashSet<>();
//        hset.add(1);
//        hset.add(1);
//        hset.add(1);
//        hset.add(1);
//        hset.add(1);


//        hset.add(1);
//        hset.add(2);
//        hset.add(1);
//        hset.add(1);
//        hset.add(1);


        hset.add(1);
        hset.add(2);
        hset.add(3);
        hset.add(4);
        hset.add(5);

        System.out.println(hset);
        System.out.println(hset.contains(4));
        System.out.println(hset.contains(1));
        System.out.println(hset.remove(1));
        System.out.println(hset);

        Iterator<Integer> itr = hset.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void hashSet(){
        Set<Integer> hset = new HashSet<>();
//        hset.add(1);
//        hset.add(1);
//        hset.add(1);
//        hset.add(1);
//        hset.add(1);


//        hset.add(1);
//        hset.add(2);
//        hset.add(1);
//        hset.add(1);
//        hset.add(1);


        hset.add(1);
        hset.add(2);
        hset.add(3);
        hset.add(4);
        hset.add(5);

        System.out.println(hset);
        System.out.println(hset.contains(4));
        System.out.println(hset.contains(1));
        System.out.println(hset.remove(1));
        System.out.println(hset);

        Iterator<Integer> itr = hset.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void treeSet(){
        Set<Integer> tree = new TreeSet<>();
//        tree.add(1);
//        tree.add(1);
//        tree.add(1);
//        tree.add(1);
//        tree.add(1);


//        tree.add(1);
//        tree.add(2);
//        tree.add(1);
//        tree.add(1);
//        tree.add(1);


        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        System.out.println(tree);
        System.out.println(tree.contains(4));
        System.out.println(tree.contains(1));
        System.out.println(tree.remove(1));
        System.out.println(tree);

        Iterator<Integer> itr = tree.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }



        Set<Integer> revTree = new TreeSet<>(Collections.reverseOrder());

//        revTree.add(1);
//        revTree.add(1);
//        revTree.add(1);
//        revTree.add(1);
//        revTree.add(1);


//        revTree.add(1);
//        revTree.add(2);
//        revTree.add(1);
//        revTree.add(1);
//        revTree.add(1);


        revTree.add(1);
        revTree.add(2);
        revTree.add(3);
        revTree.add(4);
        revTree.add(5);

        System.out.println(revTree);
        System.out.println(revTree.contains(4));
        System.out.println(revTree.contains(1));
        System.out.println(revTree.remove(1));
        System.out.println(revTree);

        Iterator<Integer> revItr = revTree.iterator();
        while (revItr.hasNext()){
            System.out.println(revItr.next());
        }

    }

    public static void linkedListQueue(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(5);
        queue.offer(7);
        queue.offer(1);
        queue.offer(8);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        System.out.println(queue);

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(5);
        deque.offer(7);
        deque.offer(1);
        deque.offer(8);
        System.out.println(deque);
//        System.out.println(deque.peek());
//        System.out.println(deque.poll());
//        System.out.println(deque.size());
//        System.out.println(deque);

        System.out.println(deque.offerFirst(9));
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque);

        System.out.println(deque.offerLast(10));
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque);

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);

        System.out.println(deque.size());
        System.out.println(deque);
    }

    public static void priorityQueue(){
        Queue<Integer> priQueue = new PriorityQueue<>();
        priQueue.offer(5);
        priQueue.offer(7);
        priQueue.offer(1);
        priQueue.offer(8);
        System.out.println(priQueue);
        System.out.println(priQueue.peek());
        System.out.println(priQueue.poll());
        System.out.println(priQueue.size());
        System.out.println(priQueue);


        Queue<Integer> revPriQueue = new PriorityQueue<>(Comparator.reverseOrder());
        revPriQueue.offer(5);
        revPriQueue.offer(7);
        revPriQueue.offer(1);
        revPriQueue.offer(8);
        System.out.println(revPriQueue);
        System.out.println(revPriQueue.peek());
        System.out.println(revPriQueue.poll());
        System.out.println(revPriQueue.size());
        System.out.println(revPriQueue);
    }

    public static void arrayDeque(){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(5);
        deque.offer(7);
        deque.offer(1);
        deque.offer(8);
        System.out.println(deque);

        System.out.println(deque.offerFirst(9));
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque);

        System.out.println(deque.offerLast(10));
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque);

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);

        System.out.println(deque.size());
        System.out.println(deque);
    }

    public static void stacks(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(1);
        stack.push(3);
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.size());
    }

    public static void linkedList(){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(7);

        System.out.println(list);

        list.remove(Integer.valueOf(5));
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        System.out.println(list.contains(7));

        System.out.println(list.get(0));

        System.out.println(list.set(0, 9));

        System.out.println(list);

        //traverse using iterator
        Iterator<Integer> itr = list.iterator();
        System.out.println("My List --> ");
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        Collections.sort(list);
        System.out.println(list);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer A, Integer B) {
                return A-B;
            }
        });
        System.out.println(list);
    }

    public static void studentList(){
        List<Student> student = new ArrayList<>();
        student.add(new Student(10,"Pranav"));
        student.add(new Student(5,"Yash"));
        student.add(new Student(15,"Kunal"));
        student.add(new Student(20,"Sujal"));


//        student.add(new Student(10,"Pranav"));
//        student.add(new Student(10,"Yash"));
//        student.add(new Student(10,"Kunal"));
//        student.add(new Student(10,"Sujal"));

        System.out.println(student);

        student.sort(new Comparator<Student>() {
            @Override
            public int compare(Student A, Student B) {
                return B.rollNo - A.rollNo;
            }
        });
        System.out.println(student);

        student.sort(new Comparator<Student>() {
            @Override
            public int compare(Student A, Student B) {
                return A.rollNo - B.rollNo;
            }
        });
        System.out.println(student);

//        ListIterator<Student> prevLitr = student.listIterator(student.size());
//        System.out.println("Student Previous List Iterator : ");
//        while (prevLitr.hasPrevious()){
//            System.out.println(prevLitr.previous());
//        }
//        System.out.println("***********************************************************************");
//        ListIterator<Student> nextLitr = student.listIterator();
//
//        System.out.println("Student Next List Iterator : ");
//        while (nextLitr.hasNext()){
//            System.out.println(nextLitr.next());
//        }
//        System.out.println("***********************************************************************");



//        System.out.println("***********************************************************************");
//        ListIterator<Student> itr = student.listIterator();
//        System.out.println("Student Next List Iterator : ");
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//            if (itr.hasPrevious()){
//                System.out.println(itr.previous());
//                break;
//            }
//        }
//        System.out.println("***********************************************************************");

//        student.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student A, Student B) {
//                int res =  B.rollNo - A.rollNo;
//                if(res == 0){
//                    return A.name.compareTo(B.name);
//                }
//                return res;
//            }
//        });
//        System.out.println(student);
//
//        student.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student A, Student B) {
//                int res =  A.rollNo - B.rollNo;
//                if(res == 0){
//                    return B.name.compareTo(A.name);
//                }
//                return res;
//            }
//        });
//        System.out.println(student);
    }

    public static void arrayLists(){
        List<Integer> list = new ArrayList<>();    //capacity = 10   //capacity = (n + (n/2) + 1)

        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(7);

        System.out.println(list);

        list.remove(Integer.valueOf(5));
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        System.out.println(list.contains(7));

        System.out.println(list.get(0));

        System.out.println(list.set(0, 9));

        System.out.println(list);

        //traverse using iterator
        Iterator<Integer> itr = list.iterator();
        System.out.println("My List --> ");
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        Collections.sort(list);
        System.out.println(list);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer A, Integer B) {
                return A-B;
            }
        });
        System.out.println(list);
    }
}
