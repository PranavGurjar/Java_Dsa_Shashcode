import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class QueueUsingStack1{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int val){
        stack1.push(val);
    }

    public int dequeue(){
        if (stack1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int val = stack2.pop();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int peek(){
        if (stack1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int val = stack2.peek();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }
}

class QueueUsingStack2{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int val){
        //move all elements from stack 1 to stack 2
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //insert value in stack 1
        stack1.push(val);
        //move all element from stack 2 to stack 1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int dequeue(){
        if (stack1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return stack1.pop();
    }

    public int peek(){
        if (stack1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return stack1.peek();
    }
}

class QueueUsingStack3{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int val){
        stack1.push(val);
    }

    public int dequeue(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int val = stack2.pop();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }

    public int peek(){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int val = stack2.peek();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }
}

class QueueUsingStack4{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int val){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        stack1.push(val);

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int dequeue(){
        if (stack1.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return stack1.pop();
    }

    public int peek(){
        if (stack1.isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return stack1.peek();
    }
}

public class Lecture_72 {
    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedList<>();
//        QueueUsingStack1 queue = new QueueUsingStack1();
//        QueueUsingStack2 queue = new QueueUsingStack2();


//        QueueUsingStack3 queue = new QueueUsingStack3();
        QueueUsingStack4 queue = new QueueUsingStack4();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.stack1);
        System.out.println("Peek is : "+queue.peek());
        System.out.println("Dequeue is : "+queue.dequeue());
        System.out.println(queue.stack1);
        queue.enqueue(7);
        System.out.println("Peek is : "+queue.peek());
        System.out.println(queue.stack1);
    }
}
