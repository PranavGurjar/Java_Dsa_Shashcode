package OOPs;


interface Shape {
    String name = "Interface";

    void display();

    void calculateArea();

    private void greetUser(){
        System.out.println("Welcome user");
    }

    default void printSome(){
        greetUser();
    }

    static void printName(){
        System.out.println("Name is "+name);
    }

    void fillArea();
}

interface Intermediate extends Shape{
    void fillArea();
}

class Circle implements Intermediate, Shape {

    private final double pi = 3.14;
    int radius;

    Circle(){
        this.radius = 10;
    }

    @Override
    public void display() {
        System.out.println("Shape is circle");
    }

    @Override
    public void calculateArea() {
        double area = pi * radius * radius;
        System.out.println("Area of circle : "+area);
    }

    @Override
    public void fillArea() {
        System.out.println("Filled");
    }
}

public class OOPs_Lecture_9 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.calculateArea();
        circle.display();
        circle.printSome();

        Shape shape = new Circle();
        shape.printSome();
    }
}
