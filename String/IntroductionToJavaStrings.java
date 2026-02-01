public class IntroductionToJavaStrings {
    public static void main(String[] args) {
//        int arr[] = new int[3];
//        arr[0] = 4;
//        System.out.println(arr[0]);
//        int brr[] = arr;
//        brr[0] = 8;
//        System.out.println(arr[0]);
//        int crr[] = new int[3];
//        crr[0] = 10;
//        System.out.println(crr[0]);
//        System.out.println("*******************************************************");
//        System.out.println(arr[0]);
//        System.out.println(brr[0]);
//        System.out.println(crr[0]);

//        String name1 = "Sham";
//        System.out.println(name1);
//        String name2 = new String("Ram");
//        System.out.println(name2);

//        String name1 = "Pranav";
//        System.out.println(name1);
//
//        String name2 = name1;
//        name2 = "Om";
//        System.out.println(name1);
//
//        String name3 = "Raj";
//        System.out.println(name3);
//
//        System.out.println("*******************************************************");
//        System.out.println(name1);
//        System.out.println(name2);
//        System.out.println(name3);


        //SCP -> String Contant Pool
//        String name1 = "Shashwat";
//        String name2 = "Shashwat";
//        String name3 = "Shashwat";
//        String name4 = name1;
//
//        System.out.println(name1 == name2); //true
//        System.out.println(name2 == name3); //true
//        System.out.println(name3 == name4); //true
//        System.out.println(name4 == name2); //true
//        System.out.println(name4 == name1); //true

//        int []arr1 = new int[3];
//        int []arr2 = new int[3];
//        int []arr3 = new int[3];
//        int []arr4 = arr1;
//
//        System.out.println(arr1 == arr2); //false
//        System.out.println(arr2 == arr3); //false
//        System.out.println(arr3 == arr4); //false
//        System.out.println(arr4 == arr2); //false
//        System.out.println(arr4 == arr1); //true

        //String is immutable   //delete by only garbage collector
//        int arr[] = new int[3];
//        String name = new String("Shashwat");

        String name1 = new String("Shashwat");
        String name2 = new String("Shashwat");
        String name3 = new String("Shashwat");
        String name4 = name1;

        System.out.println(name1 == name2);//false
        System.out.println(name2 == name3);//false
        System.out.println(name3 == name4);//false
        System.out.println(name4 == name2);//false
        System.out.println(name4 == name1);//true

        //equal() -> check value not reference
        System.out.println(name1.equals(name2));
    }
}
