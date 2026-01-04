public class Lecture_52 {
    public static void main(String[] args) {
        //  Reverse Strings StringBuilder | Char Array | Concatenation
        System.out.println("Reverse Strings StringBuilder | Char Array | Concatenation");

        printReverseString1("ABCDEF");
        printReverseString2("ABCDEF");
        printReverseString3("ABCDEF");
    }

    public static void printReverseString1(String input){
        // 1. Method
        int n = input.length();
        String str = " ";
        for (int i = 0; i < n; i++) {
            str = input.charAt(i) + str;
        }
        System.out.println(str);
    }

    public static void printReverseString2(String input){
        // 2. Method
//        int n = input.length();
        StringBuilder ans = new StringBuilder(input);
        int n = ans.length();
        for (int i = 0; i < n/2; i++) {
            char firstChar = ans.charAt(i);
            char lastChar = ans.charAt(n-1-i);
            ans.setCharAt(i, lastChar);
            ans.setCharAt(n-1-i, firstChar);
        }
        System.out.println(ans.toString());
    }

    public static void printReverseString3(String input){
        // 3. Method
        char ansArr[] = input.toCharArray();
        int n = ansArr.length;

        for (int i = 0; i < n/2; i++) {
            char firstChar = ansArr[i];
            char lastChar = ansArr[n-1-i];
            ansArr[i] = lastChar;
            ansArr[n-1-i] = firstChar;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ansArr[i]);
        }
    }
}
