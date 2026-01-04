import java.util.Scanner;

//Stack Data Structure Using Array

public class Lecture_57 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter the Size of stack : ");
        int size = in.nextInt();
        int top = -1;
        int []stack = new int[size];
        int choice = 0;



        while(choice != 7){
            System.out.println("**************** Stack **********************");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. isEmpty");
            System.out.println("5. Size");
            System.out.println("6. Peek");
            System.out.println("7. Exit");

            System.out.println("Enter the choice : ");
            choice = in.nextInt();


            switch (choice){
                case 1 : top = push(top, size, stack); break;
                case 2 : top = pop(top, stack); break;
                case 3 : display(stack, top); break;
                case 4 : isEmpty(top); break;
                case 5 : size(top); break;
                case 6 : peek(stack, top); break;
                case 7 : System.out.println("Stack is end ! ");break;
            }
        }
    }

    public static int push(int top, int size, int []stack){
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter the element : ");
        int element = in.nextInt();

        if(top >= size-1){
            System.out.println("Stack is Overflow ! ");
            return top;
        }
        top++;
        stack[top] = element;
        System.out.println("Stack Push : "+element);
        return top;
    }

    public static int pop(int top, int []stack){
        if(isEmpty(top)){
            System.out.println("Stack is underflow !");
            return top;
        }
        System.out.println("Stack Pop : "+stack[top]);
        top--;
        return top;
    }

    public static boolean isEmpty(int top){
        System.out.println("Is Stack Empty : "+(top <= -1));
        return top <= -1;
    }

    public static int size(int top){
        System.out.println("Stack Size : "+(top + 1));
        return top + 1;
    }

    public static int peek(int []stack, int top){
        if(isEmpty(top)){
            System.out.println("Stack is empty ! ");
            return Integer.MIN_VALUE;
        }
        System.out.println("Stack Peek : "+(stack[top]));
        return stack[top];
    }

    public static void display(int []stack, int top){
        if(isEmpty(top)){
            System.out.println("Stack is empty !");
            return;
        }

        System.out.println("Printing Stack : ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);
            if (i != top){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}




//class MyStack{
//    int []stack;
//    int top;
//    int size;
//
//    public MyStack(int stackSize){
//        stack = new int[stackSize];
//        top = -1;
//        size = stackSize;
//    }
//
//    //insert
//    public void push(int element){
//        if(top >= size-1){
//            System.out.println("Stack is Overflow");
//            return;
//        }
//        top++;
//        stack[top] = element;
//    }
//
//    //isEmpty
//    public boolean isEmpty(){
//        return top <= -1;
//    }
//
//    //Size
//    public int size(){
//        return top + 1;
//    }
//
//    public int peek(){
//        if (isEmpty()){
//            System.out.println("Stack is Empty");
//            return Integer.MIN_VALUE;
//        }
//        return stack[top];
//    }
//
//    public int pop(){
//        int val = peek();
//        System.out.println("val : "+val);
//        System.out.println("Integer.MIN_VALUE : "+Integer.MIN_VALUE);
//        if (val != Integer.MIN_VALUE){
//            top--;
//        }
//        return val;
//    }
//
//    public void printStack(){
//        System.out.println("Printing Stack : ");
//        for (int i = 0; i <= top; i++) {
//            System.out.print(stack[i]);
//            if (i != top){
//                System.out.print(", ");
//            }
//        }
//        System.out.println();
//    }
//}
//
//
//public class Lecture_57 {
//    public static void main(String[] args) {
//        int n = 5;
//        MyStack stack = new MyStack(n);
//        System.out.println("isEmpty : "+stack.isEmpty());
//        stack.push(9);
//        stack.printStack();
//        stack.push(1);
//        stack.printStack();
//        stack.push(8);
//        stack.printStack();
//        stack.push(5);
//        stack.printStack();
//        stack.push(8);
//        stack.printStack();
//        stack.push(2);
//        stack.printStack();
//        stack.push(6);
//        stack.printStack();
//        System.out.println("Peek : "+stack.peek());
//        System.out.println("Size : "+stack.size());
//        System.out.println("isEmpty : "+stack.isEmpty());
//        stack.pop();
//        stack.printStack();
//        stack.pop();
//        stack.printStack();
//        stack.pop();
//        stack.printStack();
//        System.out.println("Peek : "+stack.peek());
//        System.out.println("Size : "+stack.size());
//        System.out.println("isEmpty : "+stack.isEmpty());
//    }
//}





//C:\Users\PRANAV\.jdks\openjdk-24.0.1\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2025.1.4.1\lib\idea_rt.jar=57919" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\PRANAV\Desktop\Java_DSA\out\production\Java_DSA Lecture_57
//Enter the Size of stack :
//        5
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        6
//Is Stack Empty : true
//Stack is empty !
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        5
//Stack Size : 0
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        4
//Is Stack Empty : true
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        3
//Is Stack Empty : true
//Stack is empty !
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        2
//Is Stack Empty : true
//Stack is underflow !
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        1
//Enter the element :
//        11
//Stack Push : 11
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        1
//Enter the element :
//        12
//Stack Push : 12
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        1
//Enter the element :
//        13
//Stack Push : 13
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        2
//Is Stack Empty : false
//Stack Pop : 13
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        1
//Enter the element :
//        13
//Stack Push : 13
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        1
//Enter the element :
//        14
//Stack Push : 14
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        1
//Enter the element :
//        15
//Stack Push : 15
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        1
//Enter the element :
//        16
//Stack is Overflow !
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        6
//Is Stack Empty : false
//Stack Peek : 15
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        5
//Stack Size : 5
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        4
//Is Stack Empty : false
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        3
//Is Stack Empty : false
//Printing Stack :
//        11, 12, 13, 14, 15
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        2
//Is Stack Empty : false
//Stack Pop : 15
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        6
//Is Stack Empty : false
//Stack Peek : 14
//        **************** Stack **********************
//        1. Push
//2. Pop
//3. Display
//4. isEmpty
//5. Size
//6. Peek
//7. Exit
//Enter the choice :
//        7
//Stack is end !
//
//Process finished with exit code 0
