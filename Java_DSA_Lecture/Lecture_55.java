import java.util.Arrays;

public class Lecture_55 {
    public static void main(String[] args) {
        boolean res1 = areAnagrams1("ABCD", "DABC");
        System.out.println(res1);


        boolean res2 = areAnagrams2("ABCD", "DABC");
        System.out.println(res2);
    }

    public static boolean areAnagrams2(String a1, String b1) {
        String a = a1.toLowerCase();
        String b = b1.toLowerCase();

        if(a.length() != b.length()){
            return false;
        }
        int len = a.length();
        int []freq = new int[26];
        int indexA = 0;
        int indexB = 0;

        while(indexA<len && indexB<len){
            char charA = a.charAt(indexA);
            int freqIndexA = charA - 97;
            freq[freqIndexA] += 1;

            char charB = b.charAt(indexB);
            int freqIndexB = charB - 97;
            freq[freqIndexB] -= 1;

            indexA++;
            indexB++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0){
                return false;
            }
        }
        return true;
    }


    public static boolean areAnagrams1(String s1, String s2) {
        // code here
        if(s1.length() != s2.length()){
            return false;
        }

        char []arrA = s1.toCharArray();
        char []arrB = s2.toCharArray();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int indexA=0;
        int indexB=0;

        int len = arrA.length;

        while(indexA<len && indexB<len){

            if(arrA[indexA] != arrB[indexB]){
                return false;
            }

            indexA++;
            indexB++;
        }
        return true;
    }
}
