import java.util.ArrayList;
import java.util.Stack;

class StockSpanner{
    Stack<Integer> stack;
    ArrayList<Integer> list;

    public StockSpanner(){
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public int next(int price){
        list.add(price);
        System.out.println("price : "+price);
        //index = stack.peek();
        //list.get(index) -> value

        while(!stack.isEmpty() && list.get(stack.peek()) <= price){
            System.out.println("stack.pop() : "+stack.pop());
//            stack.pop();
        }

        int previousGreaterIndex = (stack.isEmpty())? -1 : stack.peek();
        System.out.println("previousGreaterIndex : "+previousGreaterIndex);
        int currentIndex = list.size() - 1;
        System.out.println("currentIndex : "+currentIndex);
        int ans = currentIndex - previousGreaterIndex;
//        System.out.println("ans : "+ans);

//        stack.push(currentIndex);
        System.out.println("stack.push(currentIndex) : "+stack.push(currentIndex));

        System.out.println("ans : "+ans);
        return ans;
    }
}

public class Lecture_64 {
    public static void main(String[] args) {
        StockSpanner stock = new StockSpanner();
        int []arr = {100, 80, 60, 70, 60, 75, 85};


        for (int price : arr){
            System.out.println("Price : "+ price + " -> Span : " + stock.next(price));
            System.out.println("**********************************************************************************************");
        }
    }

    public static int next(int price){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        list.add(price);

        //index = stack.peek();
        //list.get(index) -> value

        while(!stack.isEmpty() && list.get(stack.peek()) <= price){
            stack.pop();
        }

        int previousGreaterIndex = (stack.isEmpty())? -1 : stack.peek();
        int currentIndex = list.size() - 1;
        int ans = currentIndex - previousGreaterIndex;

        stack.push(currentIndex);
        return ans;
    }
}




//class StockSpanner {
//    Stack<Integer> stack;
//    ArrayList<Integer> list;
//
//    public StockSpanner(){
//        stack = new Stack<>();
//        list = new ArrayList<>();
//    }
//
//    public int next(int price){
//        list.add(price);
//
//        //index = stack.peek();
//        //list.get(index) -> value
//
//        while(!stack.isEmpty() && list.get(stack.peek()) <= price){
//            stack.pop();
//        }
//
//        int previousGreaterIndex = (stack.isEmpty())? -1 : stack.peek();
//        int currentIndex = list.size() - 1;
//        int ans = currentIndex - previousGreaterIndex;
//
//        stack.push(currentIndex);
//        return ans;
//    }
//}
