public class StringFunction_Builder_And_Buffer {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
////        System.out.println("Enter a word");
////        String word = in.next();
//        System.out.println("Enter a line");
//        String line = in.nextLine();
//        System.out.println("Enter a word");
//        String word = in.next();
//        System.out.println("Word is = "+word);
//        System.out.println("Line is = "+line);

        String str = "Shashwat Tiwari";
        System.out.println(str);
        System.out.println(str.toLowerCase());
        String str1 = str.toLowerCase();
        System.out.println(str);
        System.out.println(str1);

        System.out.println(str.toUpperCase());

        System.out.println(str.charAt(0));

        System.out.println(str.indexOf("T"));

        System.out.println(str.lastIndexOf("a"));

        System.out.println(str.length());

        char []ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]+" ");
        }

        System.out.println("Shashwat".compareTo("Shash")); //3
        System.out.println("Shash".compareTo("Shashwat")); //-3
        System.out.println("Shashwat".compareTo("Shashwat")); //0

        System.out.println("     Pranav     ".trim());

        System.out.println("Ram_raje".startsWith("Ram"));

        System.out.println("Ram_raje".endsWith("raje"));

        System.out.println("Shashwat".substring(0));
        System.out.println("Shashwat".substring(3));
        System.out.println("Shashwat".substring(3, 5));
        System.out.println("Shashwat".substring(3, 4));
        System.out.println("Shashwat".substring(3, 3));
//        System.out.println("Shashwat".substring(3, 1));   //StringIndexOutOfBoundsException: Range [3, 1) out of bounds for length 8

        String myLocations = " hyderabad, chennai, bangalore, noida, pune";
        String myLocationList[] = myLocations.split(",");
        for (int i = 0; i < myLocationList.length; i++) {
            System.out.println(myLocationList[i]+" ");
        }

        String email1 = "pranav@gmail.com";
        String email2 = "yash@hotgmail.com";
        int e1a = email1.indexOf("@");
        int e1d = email1.indexOf(".");
//        System.out.println("'@' index : "+e1a+" , '.' index : "+e1d);
        int e2a = email2.indexOf("@");
        int e2d = email2.indexOf(".");
//        System.out.println("'@' index : "+e2a+" , '.' index : "+e2d);
//        System.out.println(email1.substring(7,12));
//        System.out.println(email2.substring(5,13));
        System.out.println(email1.substring(e1a+1,e1d));
        System.out.println(email2.substring(e2a+1,e2d));

        String emailArr1[] = email1.split("@");
        String lastPart1 = emailArr1[emailArr1.length-1];
        int dotIndex1 = lastPart1.lastIndexOf(".");
        System.out.println(lastPart1.substring(0, dotIndex1));

        String emailArr2[] = email2.split("@");
        String lastPart2 = emailArr2[emailArr2.length-1];
        int dotIndex2 = lastPart2.lastIndexOf(".");
        System.out.println(lastPart2.substring(0, dotIndex2));

        //String Builder is Multi Thread unsafe and non synchronous
        StringBuilder name1 = new StringBuilder("Shashwat");
        StringBuilder name2 = new StringBuilder("Shashwat");
        StringBuilder name3 = new StringBuilder("Shashwat");
        StringBuilder name4 = name1;

//        System.out.println(name1.equals(name2));
//        System.out.println(name2.equals(name3));
//        System.out.println(name3.equals(name4));
//        System.out.println(name4.equals(name2));
//        System.out.println(name4.equals(name1));

        System.out.println(name1 == name2);
        System.out.println(name2 == name3);
        System.out.println(name3 == name4);
        System.out.println(name4 == name2);
        System.out.println(name4 == name1);

        name4.append("Tiwari");

        System.out.println(name1 == name2);
        System.out.println(name2 == name3);
        System.out.println(name3 == name4);
        System.out.println(name4 == name2);
        System.out.println(name4 == name1);

//        System.out.println(name1.equals(name2));
//        System.out.println(name2.equals(name3));
//        System.out.println(name3.equals(name4));
//        System.out.println(name4.equals(name2));
//        System.out.println(name4.equals(name1));



    }
}
