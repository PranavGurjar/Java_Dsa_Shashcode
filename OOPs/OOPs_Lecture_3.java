package OOPs;

/// /Inheritance -> is a relationship
/// /single inheritance
//class Terminator1 {
//    String pname;
//
//    int page;
//
//    public void displayParent(){
////        displayAge();
//        System.out.println("Parent name is : "+pname);
//    }
//
//    //data hiding -> restricting access
//    private void displayAge(){
//        System.out.println("Parent age is : "+page);
//    }
//}
//
//class Child extends Terminator1 {
//    String cname;
//
//    int cage;
//
//    public void displayChild(){
//        System.out.println("Child name is : "+cname);
//    }
//}
//
//public class OOPs_Lecture_3 {
//    public static void main(String[] args) {
//        Terminator1 t1 = new Terminator1();
//        t1.pname = "Shashwat";
//        t1.displayParent();
//
//        Child c1 = new Child();
//        c1.pname = "Pranav";
//        c1.displayParent();
//        c1.cname = "Om";
//        c1.displayChild();
//    }
//}


////Multilevel inheritance
//class Terminator1 {
//    String pname;
//
//    int page;
//
//    public void displayParent(){
////        displayAge();
//        System.out.println("Parent name is : "+pname);
//    }
//
//    //data hiding -> restricting access -> parent class has not given access of below function to the child
//    private void displayAge(){
//        System.out.println("Parent age is : "+page);
//    }
//}
//
//class Child1 extends Terminator1 {
//    String c1name;
//
//    int c1age;
//
//    public void displayChild1(){
//        System.out.println("Child name is : "+c1name);
//    }
//
//    private void displayAge1(){
//        System.out.println("Parent age is : "+c1age);
//    }
//}
//
//class Child2 extends Child1 {
//    String c2name;
//
//    int c2age;
//
//    public void displayChild2(){
//        System.out.println("Child name is : "+c2name);
//    }
//
//    private void displayAge2(){
//        System.out.println("Parent age is : "+c2age);
//    }
//}
//
//public class OOPs_Lecture_3 {
//    public static void main(String[] args) {
//        Terminator1 t1 = new Terminator1();
//        t1.pname = "Shashwat";
//        t1.displayParent();
//
//        Child1 c1 = new Child1();
//        c1.pname = "Pranav";
//        c1.displayParent();
//        c1.c1name = "Shiv";
//        c1.displayChild1();
//
//        Child2 c2 = new Child2();
//        c2.pname = "Yash";
//        c2.displayParent();
//        c2.c2name = "Ram";
//        c2.displayChild2();
//    }
//}


////hierarchical inheritance
//class Terminator1 {
//    String pname;
//
//    int page;
//
//    public void displayParent(){
////        displayAge();
//        System.out.println("Parent name is : "+pname);
//    }
//
//    //data hiding -> restricting access -> parent class has not given access of below function to the child
//    private void displayAge(){
//        System.out.println("Parent age is : "+page);
//    }
//}
//
//class Child1 extends Terminator1 {
//    String c1name;
//
//    int c1age;
//
//    public void displayChild1(){
//        System.out.println("Child name is : "+c1name);
//    }
//
//    private void displayAge1(){
//        System.out.println("Parent age is : "+c1age);
//    }
//}
//
//class Child2 extends Terminator1 {
//    String c2name;
//
//    int c2age;
//
//    public void displayChild2(){
//        System.out.println("Child name is : "+c2name);
//    }
//
//    private void displayAge2(){
//        System.out.println("Parent age is : "+c2age);
//    }
//}
//
//public class OOPs_Lecture_3 {
//    public static void main(String[] args) {
//        Terminator1 t1 = new Terminator1();
//        t1.pname = "Shashwat";
//        t1.displayParent();
//
//        Child1 c1 = new Child1();
//        c1.pname = "Pranav";
//        c1.displayParent();
//        c1.c1name = "Shiv";
//        c1.displayChild1();
//
//        Child2 c2 = new Child2();
//        c2.pname = "Yash";
//        c2.displayParent();
//        c2.c2name = "Ram";
//        c2.displayChild2();
//    }
//}


////Hybrid inheritance
class Terminator1 {
    String pname;

    int page;

    public void displayParent() {
//        displayAge();
        System.out.println("Parent name is : " + pname);
    }

    //data hiding -> restricting access -> parent class has not given access of below function to the child
    private void displayAge() {
        System.out.println("Parent age is : " + page);
    }
}

class Child1 extends Terminator1 {
    String c1name;

    int c1age;

    public void displayChild1() {
        System.out.println("Child name is : " + c1name);
    }

    private void displayAge1() {
        System.out.println("Parent age is : " + c1age);
    }
}

//c2 -> c1 -> t1
class Child2 extends Child1 {
    String c2name;

    int c2age;

    public void displayChild2() {
        System.out.println("Child name is : " + c2name);
    }

    private void displayAge2() {
        System.out.println("Parent age is : " + c2age);
    }
}

//c3 -> c1 -> t1
class Child3 extends Child1 {
    String c3name;

    int c3age;

    public void displayChild3() {
        System.out.println("Child name is : " + c3name);
    }

    private void displayAge3() {
        System.out.println("Parent age is : " + c3age);
    }
}

//by default behaviour
class M1 extends Object{
    int age;

    public void display(){

    }
}

public class OOPs_Lecture_3 {
    public static void main(String[] args) {
        Terminator1 t1 = new Terminator1();
        t1.pname = "Shashwat";
        t1.displayParent();

        Child1 c1 = new Child1();
        c1.pname = "Pranav";
        c1.displayParent();
        c1.c1name = "Shiv";
        c1.displayChild1();

        Child2 c2 = new Child2();
        c2.pname = "Yash";
        c2.displayParent();
        c2.c2name = "Ram";
        c2.displayChild2();

        Child3 c3 = new Child3();
        c3.pname = "Kunal";
        c3.displayParent();
        c3.c3name = "Krish";
        c3.displayChild3();

        M1 m1 = new M1();
        m1.hashCode(); 
    }
}





