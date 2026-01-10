package Recursion.Backtracking;


public class CountInversionsInAnArrayUsingMergeSort {
    public static void main(String[] args) {
        int []arr = {2, 4, 1, 3, 5};

        System.out.println("Before Merge Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        int inversionCount = inversionCount(arr);

        System.out.println("After Merge Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        System.out.println("Inversion Count : "+inversionCount);
    }

    public static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length-1);
    }

    public static int mergeSort(int arr[], int l, int r) {
        //base case
        if (l>=r){
            return 0;
        }

        int mid = l + (r - l)/2;
        int count = 0;
        count += mergeSort(arr, l, mid);
        count += mergeSort(arr, mid+1, r);

        count += merge(arr, l, mid, r);
        return count;
    }

    public static int merge(int []arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r - m;

        int a1[] = new int[n1];
        int a2[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            a1[i] = arr[l+i];
        }

        for (int j = 0; j < n2; j++) {
            a2[j] = arr[m + 1 +j];
        }

        int i = 0, j = 0, k = l;
        int count = 0;

        while (i < n1 && j < n2){
            if (a1[i] <= a2[j]){
                arr[k] = a1[i];
                i++;
            }
            else {
                arr[k] = a2[j];
                j++;
                count += (n1-i);
            }
            k++;
        }

        while (i < n1){
            arr[k] = a1[i];
            k++;
            i++;
        }

        while (j < n2){
            arr[k] = a2[j];
            k++;
            j++;
        }
        return count;
    }
}
