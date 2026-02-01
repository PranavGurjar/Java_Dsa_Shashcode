package Top20InterviewJavaProblem.StringProblems;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateCharactersInString {
    public static void main(String[] args) {
        String s = "programming";
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) > 1)
                System.out.println(c);
        }
    }
}
