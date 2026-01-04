//package OOPs;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//
//
//class MyStudent{
//    int maxMarks;
//
//    int rollNumber;
//
//    MyStudent(int maxMarks, int rollNumber) {
//        this.maxMarks = maxMarks;
//        this.rollNumber = rollNumber;
//    }
//
//    @Override
//    public String toString() {
//        return "MyStudent{" +
//                "maxMarks=" + maxMarks +
//                ", rollNumber=" + rollNumber +
//                '}';
//    }
//}
//
//
//public class OOPs_Lecture_12 {
//    public static void main(String[] args) {
////        ArrayList<Integer> arrayList = new ArrayList<>();
////        //sort on the basis of unit digit and
////        //if unit digit is same then print the smaller number first
////        arrayList.add(10);
////        arrayList.add(20);
////        arrayList.add(11);
////        arrayList.add(10);
////        arrayList.add(17);
////        arrayList.add(15);
//
//        ArrayList<MyStudent> arrayList = new ArrayList<>();
//        arrayList.add(new MyStudent(90, 20));
//        arrayList.add(new MyStudent(90, 10));
//        arrayList.add(new MyStudent(88, 22));
//        arrayList.add(new MyStudent(88, 24));
//        arrayList.add(new MyStudent(96, 2));
//        arrayList.add(new MyStudent(64, 1));
//
//        OOPs_Lecture_12 compare1 = new OOPs_Lecture_12();
//        compare1.display(arrayList);
//
////        Comparator<Integer> cmp = new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                //if 1 then swap +ve
////                //if 0 or -1 then don't swap -ve
////                int u1 = o1%10;
////                int u2 = o2%10;
//////                if (u1<u2){
//////                    return -1;
//////                }
//////                else if (u1>u2){
//////                    return 1;
//////                }
//////                else {
//////                    if (o1<o2){
//////                        return -1;
//////                    }
//////                    else if (o1>o2){
//////                        return 1;
//////                    }
//////                }
//////                return 0;
////
////                if (u1 == u2){
////                    return o1-o2;
////                }
////                return u1-u2;
////            }
////        };
//
//        Comparator<MyStudent> cmp = new Comparator<MyStudent>() {
//            @Override
//            public int compare(MyStudent o1, MyStudent o2) {
//                int mark1 = o1.maxMarks;
//                int mark2 = o2.maxMarks;
//                if (mark1 == mark2){
//                    return o1.rollNumber- o2.rollNumber;
//                }
//                return o2.maxMarks-o1.maxMarks;
//            }
//        };
//        Collections.sort(arrayList, cmp);
//        compare1.display(arrayList);
//    }
//
//    public <T>void display(ArrayList<T> list){
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
////            if (i != list.size()-1){
////                System.out.print(", ");
////            }
//        }
//        System.out.println();
//    }
//}



//Comparable

package OOPs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class MyStudent implements Comparable<MyStudent>{
    int maxMarks;

    int rollNumber;

    MyStudent(int maxMarks, int rollNumber) {
        this.maxMarks = maxMarks;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "maxMarks=" + maxMarks +
                ", rollNumber=" + rollNumber +
                '}';
    }

    @Override
    public int compareTo(MyStudent that) {
        int mark1 = this.maxMarks;
        int mark2 = that.maxMarks;
        if (mark1 == mark2){
            return this.rollNumber- that.rollNumber;
        }
        return that.maxMarks-this.maxMarks;
    }
}


public class OOPs_Lecture_12 {
    public static void main(String[] args) {

        ArrayList<MyStudent> arrayList = new ArrayList<>();
        arrayList.add(new MyStudent(90, 20));
        arrayList.add(new MyStudent(90, 10));
        arrayList.add(new MyStudent(88, 22));
        arrayList.add(new MyStudent(88, 24));
        arrayList.add(new MyStudent(96, 2));
        arrayList.add(new MyStudent(64, 1));

        OOPs_Lecture_12 compare1 = new OOPs_Lecture_12();
        compare1.display(arrayList);

//        Comparator<Integer> cmp = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                //if 1 then swap +ve
//                //if 0 or -1 then don't swap -ve
//                int u1 = o1%10;
//                int u2 = o2%10;
////                if (u1<u2){
////                    return -1;
////                }
////                else if (u1>u2){
////                    return 1;
////                }
////                else {
////                    if (o1<o2){
////                        return -1;
////                    }
////                    else if (o1>o2){
////                        return 1;
////                    }
////                }
////                return 0;
//
//                if (u1 == u2){
//                    return o1-o2;
//                }
//                return u1-u2;
//            }
//        };

//        Comparator<MyStudent> cmp = new Comparator<MyStudent>() {
//            @Override
//            public int compare(MyStudent o1, MyStudent o2) {
//                int mark1 = o1.maxMarks;
//                int mark2 = o2.maxMarks;
//                if (mark1 == mark2){
//                    return o1.rollNumber- o2.rollNumber;
//                }
//                return o2.maxMarks-o1.maxMarks;
//            }
//        };

        Collections.sort(arrayList);
        compare1.display(arrayList);
    }

    public <T>void display(ArrayList<T> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
//            if (i != list.size()-1){
//                System.out.print(", ");
//            }
        }
        System.out.println();
    }
}
