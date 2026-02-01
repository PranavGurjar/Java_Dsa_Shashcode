package Top20InterviewJavaProblem.StringProblems;

public class FirstNon_RepeatingCharacter {
    static char firstNonRepeat(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        for (char c : s.toCharArray())
            if (freq[c] == 1) return c;
        return '_';
    }

}
