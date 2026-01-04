package Recursion;

public class PrintArrayUsingRecursion {
    public static void main(String[] args) {
        int []arr = {7, 6, 1, 4, 5, 8, 0, 2};

        System.out.print("Print Array : ");
        printArrayLeftToRight(0, arr);

        System.out.println();

        System.out.print("Reverse Array : ");
        printArrayRightToLeft(0, arr);

        System.out.println();

        int target = 2;
        boolean checkElement = checkElement(arr, 0, target);
        System.out.println("Check Element : "+checkElement);

        int []brr = {7, 4, 1, 4, 5, 8, 4, 2};
        target = 4;
        int firstOccurrence = firstOccurrence(brr, 0, target);
        System.out.println("firstOccurrence "+target+" index : "+firstOccurrence);

        target = 11;
        int lastOccurrence = lastOccurrence(brr, 0, target);
        System.out.println("lastOccurrence "+target+" index : "+lastOccurrence);

    }

    public static int lastOccurrence(int []arr, int index, int target){
        if (index == arr.length) return -1;      //base case
        int res = lastOccurrence(arr, index+1, target);
        if (res == -1){
            if (arr[index] == target) return index;
        }
        return res;
    }

    public static int firstOccurrence(int []arr, int index, int target){
        if (index == arr.length) return -1;      //base case
        if (target == arr[index]) return index;
        return firstOccurrence(arr, index+1, target);
    }

    public static boolean checkElement(int []arr, int index, int target){
        if (index == arr.length) return false;      //base case
        if (target == arr[index]) return true;
        return checkElement(arr, index+1, target);
    }

    public static void printArrayLeftToRight(int index, int []arr){
        if (index == arr.length) return;
        System.out.print(arr[index]+" ");
        printArrayLeftToRight(index+1, arr);
    }

    public static void printArrayRightToLeft(int index, int []arr){
        if (index == arr.length) return;
        printArrayRightToLeft(index+1, arr);
        System.out.print(arr[index]+" ");
    }
}
