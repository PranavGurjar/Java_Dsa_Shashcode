import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue{
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int val){
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }

        queue1.offer(val);

        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
    }

    public int pop(){
        if (queue1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return queue1.poll();
    }

    public int peek(){
        if (queue1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return queue1.peek();
    }
}

class StackUsingQueue1{
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int val){
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }

        queue1.offer(val);

        while (!queue2.isEmpty()){
            queue1.offer(queue2.poll());
        }
    }

    public int pop(){
        if (queue1.isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return queue1.poll();
    }

    public int peek(){
        if (queue1.isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return queue1.peek();
    }
}

public class Lecture_73 {
    public static void main(String[] args) {
//        StackUsingQueue stack = new StackUsingQueue();
        StackUsingQueue1 stack = new StackUsingQueue1();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.queue1);
        System.out.println("Pop is : "+stack.pop());
        System.out.println("Pop is : "+stack.pop());
        System.out.println(stack.queue1);
        System.out.println("Peek is : "+stack.peek());
        stack.push(7);
        System.out.println(stack.queue1);
        System.out.println("Peek is : "+stack.peek());


    }
}

//QA
//reverse a stack
//reverse a queue