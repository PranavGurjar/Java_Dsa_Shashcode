package OOPs;

class Car{
    //attribute
    String brand;

    String color;

    String model;

    int speed;

    boolean isABSPresent;

    //default constructor
    Car(){
        System.out.println("This is default constructor");
        this.brand = "Maruti";
        this.color = "Black";
        this.model = "Swift";
        this.speed = 80;
        isABSPresent = false;
    }

    Car(Car newCar){
        System.out.println("This is copy contructor");
        this.brand = newCar.brand;
        this.color = newCar.color;
        this.model = newCar.model;
        this.speed = newCar.speed;
        isABSPresent = newCar.isABSPresent;
        System.out.println("copy contructor invoked");
    }

    //constructor
    Car(String brand, String color, String model, int speed, boolean isAbs){
        System.out.println("Init");
        System.out.println("This is parametrized contructor");
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.speed = speed;
        isABSPresent = isAbs;
        System.out.println("Init Done");
    }

    //method
    public void Drive(){
        System.out.println("Driving...");
    }

    public void SpeedUp(int newSpeed){
        speed = newSpeed;
        System.out.println("Speed up.");
    }
}


public class OOPs_Lecture_1 {
    public static void main(String[] args) {
//        Car Object;     //no memory allocation

        //default constructor
        Car obj1 = new Car();    //object is allocated in heap memory
        System.out.println("Obj 1 Speed : " + obj1.speed);

        //parameterized contructor
        Car obj2 = new Car("Ford","Blue","EcoSports",100, true);
        System.out.println("Obj 2 Speed : " + obj2.speed);

        //copy contructor   //deep copy -> to copy the values
        Car obj3 = new Car(obj2);
        System.out.println("Obj 3 Speed : " + obj3.speed);

        obj2.speed = 90;
        System.out.println("Obj 2 Speed : " + obj2.speed);    //obj2 val change but not change n obj3
        System.out.println("Obj 3 Speed : " + obj3.speed);    //value copy in obj3 not reference

        //same reference //shallow copy -> to copy the reference
        Car obj4 = obj2;
        System.out.println("Obj 2 Speed : " + obj2.speed);
        System.out.println("Obj 4 Speed : " + obj4.speed);

        obj2.speed = 120;
        System.out.println("Obj 2 Speed : " + obj2.speed);
        System.out.println("Obj 4 Speed : " + obj4.speed);

    }
}
