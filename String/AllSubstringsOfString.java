public class AllSubstringsOfString {
    public static void main(String[] args) {
        //Print all Substrings of String
        //  s -> (n(n + 1)/2) + 1
        System.out.println("Print all Substrings of String :- ");
        printAllSubstring("abc");
    }

    public static void printAllSubstring(String input){
        int n = input.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.println(input.substring(i, j));
            }
        }
    }
}
