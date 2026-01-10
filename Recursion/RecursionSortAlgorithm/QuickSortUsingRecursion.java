package Backtracking;



public class QuickSortUsingRecursion {
    public static void main(String[] args) {
        int []arr = {4, 1, 7, 3, 9};

        System.out.println("Before Quick Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        quickSort(arr, 0, arr.length-1);

        System.out.println("After Quick Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high){
            return;
        }

        int pivot = partition(arr, low, high);

        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        int i = low;
        int j = high;

        while (i < j){
            while (i < high && arr[i] <= pivot) i++;

            while (j > low && arr[j] > pivot) j--;

            if (i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}