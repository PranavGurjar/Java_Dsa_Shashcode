package OOPs;



//Abstraction
abstract class Bank {
    static String message;

    Bank(){
        message = "Sir";
        System.out.println("This is constructor");
    }

    abstract int rateOfInterest();

    // static ans final can't overrride
    final void display(){
        System.out.println("Welcome to Our Bank, "+message);
    }

}

class Pnb extends Bank{

    @Override
    int rateOfInterest() {
        return 10;
    }
}

class Sbi extends Bank{

    @Override
    int rateOfInterest() {
        return 9;
    }
}

abstract class Hdfc extends Bank{
    void print(){
        System.out.println("Hi HDFC");
    }
}

class NewBank extends Hdfc{

    @Override
    int rateOfInterest() {
        return 11;
    }
}


public class OOPs_Lecture_8 {
    public static void main(String[] args) {
//        Bank b = new Bank();  //no work
        Pnb p = new Pnb();
        System.out.println(p.rateOfInterest());

        Bank b1 = new Pnb();
        System.out.println(b1.rateOfInterest());
        //b1.display();


        Bank b2 = new Sbi();
        System.out.println(b2.rateOfInterest());
        //b2.display();

        Bank b3 = new NewBank();
        System.out.println(b3.rateOfInterest());
        //b3.display();
    }
}
