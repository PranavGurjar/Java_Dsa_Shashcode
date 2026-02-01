package Top20InterviewJavaProblem.StringProblems;

public class CountVowels_And_Consonants {
    static void countVC(String s) {
        int v = 0, c = 0;
        for (char ch : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) v++;
            else if (ch >= 'a' && ch <= 'z') c++;
        }
        System.out.println("Vowels=" + v + " Consonants=" + c);
    }

}
