package Top20InterviewJavaProblem;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        System.out.println(7+ " is on index : "+search(arr, 7));
    }
    static int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
