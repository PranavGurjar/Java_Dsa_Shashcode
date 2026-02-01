package Top20InterviewJavaProblem.StringProblems;

public class FrequencyOfCharacters {
    public static void main(String[] args) {
        String s = "programming";
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;

    }
}
