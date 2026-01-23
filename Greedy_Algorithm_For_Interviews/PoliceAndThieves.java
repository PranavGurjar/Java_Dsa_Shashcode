package Greedy_Algorithm_For_Interviews;

public class PoliceAndThieves {
    public static void main(String[] args) {
        char arr[] = {'P', 'T', 'T', 'P', 'T', 'T', 'T', 'P', 'T'};
        int k = 1;

        int catchThieves = catchThieves(arr, k);
        System.out.println("catchThieves : "+catchThieves);
    }

    public static int catchThieves(char[] arr, int k) {
        int n = arr.length;
        int i = -1;
        int j = -1;
        for (int m = 0; m < n; m++) {
            if (i == -1 && arr[m] == 'P') i=m;
            if (j == -1 && arr[m] == 'T') j=m;
            if (i != -1 && j != -1) break;
        }
        if (i == -1 || j == -1) return 0;

        int caught = 0;
        while (i < n && j < n){
            if (Math.abs(i-j) <= k){        //next police and thief
                caught++;
                i++;
                while (i<n && arr[i] != 'P') i++;
                j++;
                while (j<n && arr[j] != 'T') j++;
            }
            else if (i<j){      //next police find
                i++;
                while (i<n && arr[i] != 'P') i++;
            }
            else {          //next thief find
                j++;
                while (j<n && arr[j] != 'T') j++;
            }
        }
        return caught;
    }
}