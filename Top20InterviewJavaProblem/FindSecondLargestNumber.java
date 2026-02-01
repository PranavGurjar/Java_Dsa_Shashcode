package Top20InterviewJavaProblem;

public class FindSecondLargestNumber {
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8};
        System.out.println(secondLargest(arr));
    }
    static int secondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int n : arr){
            if(n > largest){
                second = largest;
                largest = n;
            }
            else if(n > second && n != largest){
                second = n;
            }
        }
        return second;
    }
}
