package OOPs;

//Inh -> is a relation
//single
class Terminator {
    String pname;

    String name;

    int age;

    Terminator(){
        System.out.println("Constructor of parent");
    }

    Terminator(String name){
        this.name = name;
        System.out.println("Parameterized Constructor of parent");
    }

    public void display(){
        System.out.println("Parent name is : "+name);
    }

    public void display2(){
        System.out.println("Parent2 name is : "+pname);
    }

    public void setName(String name){
        this.name = name;
    }

    //data hiding -> restricting access
    private void displayAge(){
        System.out.println("Parent age is : "+age);
    }
}

class Child extends Terminator {
    String cname;

    String name;

    int age;

    Child(){
        System.out.println("Constructor of child");
    }

    Child(String name){
        this.name = name;
        System.out.println("Parameterized Constructor of child");
    }

    public void display(){
        System.out.println("Child name is : "+name);
    }

    final public void display2(){
        System.out.println("Child2 name is : "+cname);
    }

    public void setName(String name){
        this.name = name;
    }
}

public class OOPs_Lecture_7 {
    public static void main(String[] args) {
        Terminator tP = new Terminator();
        tP.display();


        Terminator tC = new Child();
        tC.display();

//        tC.name = "Shashwat";
        tC.setName("Shashwat");
        tC.display();
        tC.display2();

        Child c = new Child();
        c.display2();
    }
}
