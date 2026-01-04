package OOPs;

class Outer {
    static int rollNumber;

    String name;

    private int age;

    int data;

    Outer() {
        rollNumber = 100;
        this.name = "Shashwat";
        this.age = 24;
        this.data = 10;
        System.out.println("Init Outer");
    }

    public void displayData() {
        System.out.println("Outer Data is : "+data);
        Inner obj = new Inner();
        System.out.println("Inner Data is : "+obj.data);
        System.out.println("Inner rollNumber is : "+Inner.rollNumber);
    }

    //member inner class
    class Inner {
        static int rollNumber;

        static String name;

        int data;

        Inner() {
            name = "Inner";
            this.data = 20;
            System.out.println("Init Inner");
        }

        Inner(int data) {
            name = "Inner";
            this.data = data;
        }

        public void displayData(){
            System.out.println("Data is : "+data); //outer //Inner ?
            System.out.println("Outer Data is : "+Outer.this.data);
            System.out.println("Outer Age is : "+Outer.this.age);
            Outer.this.displayData();
        }

        public void displayRollNumber(){
            System.out.println("Outer RollNumber is : "+Outer.rollNumber);
            System.out.println("Inner RollNumber is : "+rollNumber);
        }
    }

    class InnerNew extends Inner {

    }
}

//Local Inner Class
class Fan {
    void display(){
        System.out.println("Outer Display");

        class InnerFan{
            void display() {
                System.out.println("Inner Display");
            }
        }
        InnerFan f = new InnerFan();
        f.display();
    }
}

class Normal{
    void display(){
        System.out.println("This is Normal class");
    }
}

abstract class NoName{
    abstract void display();

    abstract void print();
}

interface NoGame{
    void display();
}

class OuterNonStatic{
    static int age;

    String name;

    static  class InnerStatic{
        void display(){
            age = 20;
            System.out.println("Non static method inside static inner class");
        }
    }

    static class InnerSecondStatic{
        static void display(){
            System.out.println("Static method inside Non-static inner class");
        }
    }
}

public class OOPs_Lecture_10 {
    public static void main(String[] args) {
        Outer obj = new Outer();
        Outer.Inner innerObject = obj.new Inner();

        obj.displayData();
        innerObject.displayData();

        NoName nn = new NoName() {
            @Override
            void display() {
                System.out.println("Anonymous class");
            }

            @Override
            void print() {
                System.out.println("printed class");
            }
        };
        nn.display();
        nn.print();

        NoGame ng = new NoGame() {
            @Override
            public void display() {
                System.out.println("No Game");
            }
        };
        ng.display();

        OuterNonStatic ons = new OuterNonStatic();
        OuterNonStatic.InnerStatic obj1 = new OuterNonStatic.InnerStatic(); //inner nested class
        obj1.display();

        //no need of object
        OuterNonStatic.InnerSecondStatic.display();
        //no need of object
        //OuterNonStatic.InnerSecondStatic obj2 = new OuterNonStatic.InnerSecondStatic();
        //obj2.
    }
}
