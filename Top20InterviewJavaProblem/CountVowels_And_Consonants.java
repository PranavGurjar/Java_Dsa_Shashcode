package Top20InterviewJavaProblem;

public class CountVowels_And_Consonants {
    public static void main(String[] args) {
        String s = "hello";
        int v=0, c=0;
        for(char ch : s.toCharArray()){
            if("aeiouAEIOU".indexOf(ch) != -1)
                v++;
            else if(Character.isLetter(ch))
                c++;
        }
        System.out.println("Vowels = " + v + ", Consonants = " + c);
    }
}
