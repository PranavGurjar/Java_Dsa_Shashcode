package Top20InterviewJavaProblem;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNon_RepeatingCharacter {
    public static void main(String[] args) {
        String s = "aabbccd";
        System.out.println(firstNonRepeat(s));
    }

    static char firstNonRepeat(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : map.keySet())
            if (map.get(c) == 1) return c;
        return '_';
    }
}
