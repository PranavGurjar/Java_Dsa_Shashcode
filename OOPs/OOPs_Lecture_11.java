package OOPs;

class IntergerDisplayer{
    Integer num;

    public void setNum(Integer num){
        this.num = num;
    }

    public void display(){
        System.out.println("element -> "+this.num);
    }
}

class DoubleDisplayer{
    Double num;

    public void setNum(Double num){
        this.num = num;
    }

    public void display(){
        System.out.println("element -> "+this.num);
    }
}


//Generic class
//class Displayer<T> {
//    T num;
//
//    public void setNum(T num){
//        this.num = num;
//    }
//
//    public void display(){
//        System.out.println("element -> "+this.num);
//    }
//}

class College{
    void printCollegeName(){
        System.out.println("XYZ institute of technology");
    }
}

class Student extends College{
    void printName(){
        System.out.println("Student name printed");
    }
}

class Teacher extends College{
    void printName(){
        System.out.println("Teacher name printed");
    }
}

//bounded generic class
class Displayer<T extends College> {
    T num;

    public void setNum(T num){
        this.num.printCollegeName();
        this.num = num;
    }

    public void display(){
        System.out.println("element -> "+this.num);
    }
}

class Displayer1<T>{
    T num;

    public void setNum(T num){
        this.num = num;
    }

    public void display(){
        System.out.println("element -> "+this.num);
    }
}

//Generic class
class Displayer2 {
    Object num;

    public void setNum(Object num){
        this.num = num;
    }

    public void display(){
        System.out.println("element -> "+this.num);
    }
}



//T- type
//E- element
//K- key
//V- Value

public class OOPs_Lecture_11 {

    public <E>void heyGen(E element){
        System.out.println("Hi generic : "+element);
    }

    public static void main(String[] args) {

        OOPs_Lecture_11 mg = new OOPs_Lecture_11();
        mg.heyGen("Pranav");



//        IntergerDisplayer obj1 = new IntergerDisplayer();
//        obj1.setNum(20);
//        obj1.display();
//
//        DoubleDisplayer obj2 = new DoubleDisplayer();
//        obj2.setNum(20.0);
//        obj2.display();

//        Displayer1<Integer> objGeneric1 = new Displayer1<>();
//        objGeneric1.setNum(10);
//        objGeneric1.display();
//
//        Displayer1<Double> objGeneric2 = new Displayer1<>();
//        objGeneric2.setNum(10.0);
//        objGeneric2.display();

//        Displayer2 objD2A = new Displayer2();
//        objD2A.setNum(12);
//        objD2A.setNum(12.0);
//        objD2A.display();
//
//        Displayer2 objD2B = new Displayer2();
//        objD2B.setNum(12.0);
//        objD2B.setNum(12);
//        objD2B.display();

//        Displayer<Student> objC1 = new Displayer<>();
//        objC1.setNum(new Student());
//        objC1.display();
//
//        Displayer<Teacher> objC2 = new Displayer<>();
//        objC2.setNum(new Teacher());
//        objC2.display();


//        Displayer d1 = new Displayer();
//        d1.setNum(10);
//        d1.display();
    }
}
