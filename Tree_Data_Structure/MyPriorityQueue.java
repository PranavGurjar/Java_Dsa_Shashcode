package Tree_Data_Structure;

import java.util.Collections;
import java.util.PriorityQueue;

class NewStudent implements Comparable<NewStudent>{
    int marks;
    String name;

    public NewStudent(String name, int marks) {
        this.marks = marks;
        this.name = name;
    }

    //this.p1, that.p2
    @Override
    public int compareTo(NewStudent that) {
//        return this.marks - that.marks;     //inc - asc
        if (this.marks == that.marks){
            return this.name.compareTo(that.name);      //-neg, 0, pos+
        }
        return that.marks - this.marks;     //dec - desc
    }

    @Override
    public String toString() {
        return "Student name = " + this.name + ", marks = " + this.marks;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NewStudent){
            NewStudent that = (NewStudent) obj;
            boolean isNameSame = (this.name.compareTo(that.name)) == 0;
            if (this.marks == that.marks && isNameSame){
                return true;
            }
        }
        return false;
    }
}

public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        minPq.offer(1);
        minPq.offer(2);
        minPq.offer(10);
        minPq.offer(0);
        System.out.println("min pq : highest priority element -> "+minPq.peek());
        System.out.println("min pq : element 0 is contain -> "+minPq.contains(0));
        System.out.println("min pq : deleted -> "+minPq.poll());
        System.out.println("min pq : highest priority element -> "+minPq.peek());
        System.out.println("min pq : element 0 is contain -> "+minPq.contains(0));
        System.out.println("*************************************************************************");


        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        maxPq.offer(1);
        maxPq.offer(2);
        maxPq.offer(10);
        maxPq.offer(0);
        System.out.println("max pq : highest priority element -> "+maxPq.peek());
        System.out.println(maxPq.contains(10));
        System.out.println("max pq : deleted -> "+maxPq.poll());
        System.out.println("max pq : highest priority element -> "+maxPq.peek());
        System.out.println(maxPq.contains(10));
        System.out.println("*************************************************************************");

        PriorityQueue<NewStudent> minStudentPQ = new PriorityQueue<>();
        NewStudent ns = new NewStudent("Pranav", 60);
        minStudentPQ.offer(ns);
        minStudentPQ.offer(new NewStudent("shashwat", 80));
        minStudentPQ.offer(new NewStudent("aman", 70));
        minStudentPQ.offer(new NewStudent("mohit", 90));
        minStudentPQ.offer(new NewStudent("shiv", 90));
        System.out.println(minStudentPQ.peek());
        System.out.println(minStudentPQ.contains(new NewStudent("shashwat", 80)));
        System.out.println(minStudentPQ.contains(ns));

    }
}
