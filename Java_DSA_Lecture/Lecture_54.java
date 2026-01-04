public class Lecture_54 {
    public static void main(String[] args) {
        reverseWords1("   Hello  Coder   ");
        reverseWords2("   Hello  Coder   ");
        reverseWords3("   Hello  Coder   ");
    }


    public static void reverseWords3(String s) {
        StringBuilder res = new StringBuilder();
        int startIndex = s.length()-1;

        while(startIndex>=0){
            while (startIndex>=0 && s.charAt(startIndex) == ' '){
                startIndex--;
            }

            if(startIndex<0){
                break;
            }

            int endIndex = startIndex;

            while (startIndex>=0 && s.charAt(startIndex) != ' '){
                startIndex--;
            }

            if (res.length() == 0){
                res.append(s.substring(startIndex+1, endIndex+1));
            }
            else {
                res.append(" ");
                res.append(s.substring(startIndex+1, endIndex+1));
            }
        }
        System.out.println(res.toString());
    }

    public static void reverseWords2(String s) {
        String []arr = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i].length() == 0){
                continue;
            }

            if (res.length() == 0){
                res.append(arr[i]);
            }
            else {
                res.append(" ");
                res.append(arr[i]);
            }
        }
        System.out.println(res.toString());
    }

    public static void reverseWords1(String s) {
        String []arr = s.split(" ");
        String res = "";
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i].length() == 0){
                continue;
            }

            if (res.length() == 0){
                res += arr[i];
            }
            else {
                res += " " + arr[i];
            }
        }
        System.out.println(res);
    }


}


