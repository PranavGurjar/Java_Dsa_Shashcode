import java.util.Scanner;

public class Lecture_50 {
    public static void main(String[] args) {

        System.out.println("----------------------------------------------------------------------------");
        //1. Play with strings
        System.out.println("1. Play with strings");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word1");
        String word1 = in.next();
        System.out.println("Enter a word2");
        String word2 = in.next();

        System.out.println("Enter a Line1");
        String line1 = in.nextLine();
        System.out.println("Enter a Line2");
        String line2 = in.nextLine();

        System.out.println("Word1 : "+ word1 + ",");
        System.out.println("Word2 : "+ word2 + ",");
        System.out.println("Line1 : "+ line1 + ",");
        System.out.println("Line2 : "+ line2 + ",");

        /*
            Enter a word1
            Shashwat ms
            Enter a word2
            Enter a Line1
            Enter a Line2
            Pranav
            Word1 : Shashwat,
            Word2 : ms,
            Line1 : ,
            Line2 : Pranav,
         */

        System.out.println("----------------------------------------------------------------------------");
        //2. String Concatenation  (String(s)/double(d)/Integer(i))
        System.out.println("2. String Concatenation  (String(s)/double(d)/Integer(i))");
        System.out.println("Shashwat"+64+87.99); //s+d+i
        System.out.println(64+87.99+"Shashwat"); //i+d+s
//        String cal = 64+87.99;
        String cal = 64+87.99+"Shashwat";

        int rollno = 37;
        String name = "Shashwat";
        System.out.println("My name is "+name+" My RollNumber is "+rollno);

        System.out.println("Shashwat"+(64+87.99)); //Use BODMAS method

        System.out.println("----------------------------------------------------------------------------");
        //3. String Formatting
        System.out.println("3. String Formatting");

        double num = 67.86789765;
        String address = "India";
        System.out.println(num);
        System.out.printf("Number is %f ", num);    //sout vs souf
        System.out.printf("\nNumber is %.8f ", num);
        System.out.printf("\nNumber is %.5f ", num);
        System.out.printf("\nNumber is %.6f ", num);
        System.out.printf("\nNumber is %.4f ", num);
        System.out.printf("\nNumber is %.2f ", num);


        String nameFormat = String.format("\nNumber is %.2f",num);
        System.out.println(nameFormat);
        String lineFormat = String.format("\nMy number is %f And My address is %s",num, address);
        System.out.println(lineFormat);

        System.out.printf("\nMy number is %f And My address is %s",num, address);
        System.out.printf("\nMy number is %1$f And My address is %2$s",num, address);

//        System.out.printf("\nMy number is %f And My address is %s",address, num);
        System.out.printf("\nMy number is %2$f And My address is %1$s",address, num);

    }
}
