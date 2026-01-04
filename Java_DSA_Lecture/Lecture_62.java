public class Lecture_62 {
    public static void main(String[] args) {
        //  GFG - Minimum Adjacent Swaps for bracket balancing
        System.out.println(minimumNumberOfSwaps("[]]]][][[[[]"));
    }

    public static int minimumNumberOfSwaps(String s) {

        int open = 0, close = 0, unbalanced = 0, swap = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '['){
                open++;
                if (unbalanced > 0){
                    swap += unbalanced;
                    unbalanced--;
                }
            }else {
                close++;
                unbalanced = close - open;
            }
        }
        return swap;
    }
}
