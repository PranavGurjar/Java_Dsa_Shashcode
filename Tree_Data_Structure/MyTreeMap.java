package Tree_Data_Structure;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Student1 implements Comparable<Student1> {      //comparator
    int rollNo;
    int marks;
    String name;

    public Student1(int rollNo, int marks, String name) {
        this.rollNo = rollNo;
        this.marks = marks;
        this.name = name;
    }

    @Override
    public int compareTo(Student1 that) {        //compare
        //sort inc roll
        if (this.marks == that.marks){
            if (this.rollNo == that.rollNo){
                return this.name.compareTo(that.name);      //lex name
            }
            return this.rollNo-that.rollNo;     //inc
        }
        return that.marks-this.marks;     //dec
    }

    @Override
    public String toString() {
        return "Student1 : " + this.name;
    }
}


class Student2 implements Comparator<Student2> {      //comparator
    int rollNo;
    int marks;
    String name;

    public Student2(int rollNo, int marks, String name) {
        this.rollNo = rollNo;
        this.marks = marks;
        this.name = name;
    }

    @Override
    public int compare(Student2 s1, Student2 s2) {

        // marks desc
        if (s1.marks == s2.marks) {
            // rollNo asc
            if (s1.rollNo == s2.rollNo) {
                // name lex
                return s1.name.compareTo(s2.name);
            }
            return s1.rollNo - s2.rollNo;
        }
        return s2.marks - s1.marks;


    }

    @Override
    public String toString() {
        return "Student2 : " + this.name;
    }

}

public class MyTreeMap {
    // equals, hashcode -> hash
    public static void main(String[] args) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(3, 30);
        tmap.put(4, 40);
        tmap.put(1, 10);
        tmap.put(2, 20);
        System.out.println(tmap);
        System.out.println(tmap.get(1));
        System.out.println(tmap.get(3));
        System.out.println(tmap.getOrDefault(3, 0));
        System.out.println(tmap.containsKey(2));
        System.out.println(tmap.containsKey(3));
        for (Map.Entry<Integer, Integer> entry : tmap.entrySet()){
            System.out.println("Key : "+entry.getKey()+", Values : "+entry.getValue());
        }
        System.out.println("*************************************************************************************");

        TreeMap<Student1, Integer> smap1 = new TreeMap<>();
        smap1.put(new Student1(4, 70, "Aman"), 40);
        smap1.put(new Student1(3, 45, "Vivek"), 30);
        smap1.put(new Student1(2, 55, "Om"), 20);
        smap1.put(new Student1(1, 65, "Raj"), 10);
        smap1.put(new Student1(5, 70, "Ram"), 50);
        Student1 obj11 = new Student1(2, 55, "Fukra");
        System.out.println(smap1.containsKey(obj11));
        Student1 obj12 = new Student1(2, 65, "Fukra");
        System.out.println(smap1.containsKey(obj12));

        System.out.println(smap1);
        for (Map.Entry<Student1, Integer> entry : smap1.entrySet()){
            System.out.println("Key : "+entry.getKey()+", Values : "+entry.getValue());
        }
        System.out.println("*************************************************************************************");

        TreeMap<Integer, Integer> tmap2 = new TreeMap<>();
        tmap2.put(1, 10);
        tmap2.put(4, 12);
        tmap2.put(5, 14);
        tmap2.put(7, 16);
        tmap2.put(8, 18);
        System.out.println(tmap2);
        System.out.println(tmap2.containsKey(5));
        System.out.println(tmap2.containsKey(6));
        System.out.println(tmap2.floorKey(6));
        System.out.println(tmap2.ceilingKey(6));
        System.out.println(tmap2.lastKey());
        System.out.println(tmap2.firstKey());
        System.out.println(tmap2.ceilingEntry(6));
        System.out.println("*************************************************************************************");

        TreeMap<Student2, Integer> smap2 = new TreeMap<>(new Student2(0,0,""));
        smap2.put(new Student2(4, 70, "Aman"), 40);
        smap2.put(new Student2(3, 45, "Vivek"), 30);
        smap2.put(new Student2(2, 55, "Om"), 20);
        smap2.put(new Student2(1, 65, "Raj"), 10);
        smap2.put(new Student2(5, 70, "Ram"), 50);
        Student2 obj21 = new Student2(2, 55, "Fukra");
        System.out.println(smap2.containsKey(obj21));
        Student2 obj22 = new Student2(2, 65, "Fukra");
        System.out.println(smap2.containsKey(obj22));

        System.out.println(smap2);
        for (Map.Entry<Student2, Integer> entry : smap2.entrySet()){
            System.out.println("Key : "+entry.getKey()+", Values : "+entry.getValue());
        }
        System.out.println("*************************************************************************************");

    }
}
