package Recursion;


public class FindIndex {
    public static void main(String[] args) {
        int []arr = {7, 4, 1, 4, 5, 8, 4, 2};
        int[] index = findIndex(arr, 4);
        System.out.print("Res : ");
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i]);
            if (i != index.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    static int[] findIndex(int arr[], int key) {
        int res[] = {-1, -1};
        findOccurrence(0, arr, key, res);
        return res;
    }
    static void findOccurrence(int index, int []arr, int key, int []res){
        if (index == arr.length) return;

        if (arr[index] == key){
            res[1] = index;
        }
        findOccurrence(index+1, arr, key, res);
        if (arr[index] == key){
            res[0] = index;
        }
    }
}
