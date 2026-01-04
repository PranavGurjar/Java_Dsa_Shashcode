package Java;

class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        int last = 0;
        int swapCount = 0;
        for (int curr = 0; curr < n; curr++) {
            if (s.charAt(curr) == '1'){
                continue;
            }
            else {
                //white ball
                swapCount += (curr - last);     //imag swapping
                last++;
            }
        }
        return swapCount;
    }
}

public class SeparateBlackAndWhiteBalls {
    public static void main(String[] args) {
        String str = "110010110";
        long minimumSteps1 = minimumSteps1(str);
        System.out.println("minimumSteps1 : "+minimumSteps1);

        long minimumSteps2 = minimumSteps2(str);
        System.out.println("minimumSteps2 : "+minimumSteps2);
    }
    public static int minimumSteps2(String s) {
        int n = s.length();
        int last = 0;
        int swapCount = 0;
        for (int curr = 0; curr < n; curr++) {
            if (s.charAt(curr) == '1'){
                continue;
            }
            else {
                //white ball
                swapCount += (curr - last);     //imaginary swapping
                last++;
            }
        }
        return swapCount;
    }
    public static int minimumSteps1(String s) {
        int n = s.length();
        int last = 0;
        int swapCount = 0;
        for (int curr = 0; curr < n; curr++) {
            if (s.charAt(curr) == '0'){
                //white ball
                swapCount += (curr - last);     //imag swapping
                last++;
            }
        }
        return swapCount;
    }
}
