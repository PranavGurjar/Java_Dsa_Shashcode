package Recursion.RecursionString;

public class RemoveCharFromString {
    public static void main(String[] args) {
        String str = "SHASHCODE";
        char ch = 'A';
        String removedChars = removeChars(str, ch, 0);
        System.out.println("After remove \'"+ch+"\' : "+removedChars);
    }
    public static String removeChars(String str, char ch, int index){
        if (index == str.length()) return "";
        String prev = removeChars(str, ch, index+1);
        if (ch == str.charAt(index)){
            return prev;
        }
        return (str.charAt(index) + prev);
    }
}
