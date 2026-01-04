
class MyCar{
    public void drive(){
        System.out.println("I am Driving");
    }

    protected void drop(){
        System.out.println("Dropped");
    }
}

class Driver{
    //has - a relationship
    MyCar object;

    Driver(MyCar object){
        this.object = object;
    }

    void print(){
        object.drive();
        object.drop();
    }
}


public class Lecture_86 {
    public static void main(String[] args) {
        MyCar c = new MyCar();
        Driver d = new Driver(c);
        d.print();
    }
}
