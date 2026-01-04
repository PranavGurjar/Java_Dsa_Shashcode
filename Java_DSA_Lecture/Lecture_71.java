
class QueuePRM{
    int front;
    int rear;
    int size;
    int capacity;
    int []queue;

    public QueuePRM(int capacity){
        this.capacity = capacity;
        front = rear = -1;
        size = 0;
        queue = new int[capacity];
    }

    public boolean isEmpty(){
        if (front == -1 && rear == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (rear == capacity-1){
            return true;
        }
        return false;
    }

    public void enqueue(int val){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }

        if (isEmpty()){
            front = 0;
            rear = 0;
        }
        else {
            rear++;
        }
        queue[rear] = val;
        size++;
        return;
    }

    public void deque(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }

        if (front == rear){
            front = -1;
            rear = -1;
        }
        else {
            front++;
        }
        size--;
        return;
    }

    public int getSize(){
        return size;
    }

    public void printQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Print Queue : ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i]);
            if (i != rear){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}

class CircularQueuePRM{
    int front;
    int rear;
    int size;
    int capacity;
    int []cirQuePRM;

    public CircularQueuePRM(int capacity){
        this.capacity = capacity;
        front = rear = -1;
        size = 0;
        cirQuePRM = new int[capacity];
    }

    public boolean isEmpty(){
        if (front == -1 && rear == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if ((front == 0 && rear == capacity-1) || (front != 0 && rear == (front-1)%capacity)){
            return true;
        }
        return false;
    }

    public int peek(){
        if (isEmpty()) {
            return -1;
        }
        return cirQuePRM[front];
    }

    public void enqueue(int val){
        if (isFull()){
            System.out.println("Circular queue is full");
            return;
        }

        if (isEmpty()){
            front = rear = 0;
        } else if (front != 0 && rear == capacity-1) {
            rear = 0;
        }else {
            rear++;
        }
        cirQuePRM[rear] = val;
        size++;
    }

    public void deque(){
        if (isEmpty()){
            System.out.println("Circular Queue is empty.");
        }

        if (front == rear){
            front = -1;
            rear = -1;
        }
        else if (front == capacity-1){
            front = 0;
        }
        else {
            front++;
        }
        size--;
    }

    public int getSize(){
        return size;
    }

    public void printCircularQueue(){
        if (isEmpty()){
            System.out.println("Circular Queue is Empty");
            return;
        }
        System.out.println("Print Queue : ");
        if (rear <= front){
            for (int i = front; i <= capacity-1; i++) {
                System.out.print(cirQuePRM[i]);
                System.out.print(", ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(cirQuePRM[i]);
                if (i != rear){
                    System.out.print(", ");
                }
            }
        }
        else {
            for (int i = front; i <= rear; i++) {
                System.out.print(cirQuePRM[i]);
                if (i != rear){
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }
}

class DoubleEndQueuePRM{
    int front;
    int rear;
    int size;
    int capacity;
    int []dequePRM;

    public DoubleEndQueuePRM(int capacity){
        this.capacity = capacity;
        front = rear = -1;
        size = 0;
        dequePRM = new int[capacity];
    }

    public boolean isEmpty(){
        if (front == -1 && rear == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if ((front == 0 && rear == capacity-1) || (front != 0 && rear == (front-1)%capacity)){
            return true;
        }
        return false;
    }

    public int peekFront(){
        if (isEmpty()) {
            return -1;
        }
        return dequePRM[front];
    }

    public int peekRear(){
        if (isEmpty()) {
            return -1;
        }
        return dequePRM[rear];
    }


    public void enqueueFront(int val){
        if (isFull()){
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()){
            front = 0;
            rear = 0;
        }
        else if (front == 0 && rear != capacity-1){
            front = capacity-1;
        }
        else {
            front--;
        }
        dequePRM[front] = val;
        size++;
    }


    public void enqueueRear(int val){
        if (isFull()){
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()){
            front = 0;
            rear = 0;
        }
        else if (front != 0 && rear == capacity-1){
            rear = 0;
        }
        else {
            rear++;
        }
        dequePRM[rear] = val;
        size++;
    }



    public void dequeFront(){
        if (isEmpty()){
            System.out.println("Deque is empty");
            return;
        }

        if (front == rear){
            front = -1;
            rear = -1;
        }
        else if (front == capacity-1){
            front = 0;
        }
        else {
            front++;
        }
        size--;
    }

    public void dequeRear(){
        if (isEmpty()){
            System.out.println("Deque is empty");
            return;
        }

        if (front == rear){
            front = -1;
            rear = -1;
        }
        else if (rear == 0){
            rear = capacity-1;
        }
        else {
            rear--;
        }
        size--;
    }

    public int getSize(){
        return size;
    }

    public void printQueue(){
        if (isEmpty()){
            System.out.println("Deque is Empty");
            return;
        }
        System.out.println("Print Deque : ");
        if (rear <= front){
            for (int i = front; i <= capacity-1; i++) {
                System.out.print(dequePRM[i]);
                System.out.print(", ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(dequePRM[i]);
                if (i != rear){
                    System.out.print(", ");
                }
            }
        }
        else {
            for (int i = front; i <= rear; i++) {
                System.out.print(dequePRM[i]);
                if (i != rear){
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }
}

class MyQueue{
    int front;
    int rear;
    int capacity;
    int size;
    int []queue;

    public MyQueue(int capacity){
        this.capacity = capacity;
        size = 0;
        front = rear = -1;
        queue = new int[capacity];
    }

    public boolean isEmpty(){
        if(front == -1 && rear == -1){      //if(front == -1)       //if(front == -1 || rear == -1)
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (rear == capacity-1){
            return true;
        }
        return false;
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(queue[front]);
        return;
    }

    public void enqueue(int val){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }

        if (isEmpty()){
            front = 0;
            rear = 0;
        }
        else {
            rear++;
        }
        size++;
        queue[rear] = val;
    }

    public int deque(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int val = queue[front];
        if (front == rear){
            front = -1;
            rear = -1;
        }
        else {
            front++;
        }
        size--;
        return val;
    }

    public void size(){
        System.out.println(size);
        return;
    }

    public void printQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i]);
            if (rear != i){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

class MyCircularQueue{
    int front;
    int rear;
    int capacity;
    int size;
    int []circularQueue;

    public MyCircularQueue(int capacity){
        this.capacity = capacity;
        size = 0;
        front = rear = -1;
        circularQueue = new int[capacity];
    }

    public boolean isEmpty(){
        if(front == -1 && rear == -1){      //if(front == -1)       //if(front == -1 || rear == -1)
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if ((front == 0 && rear == capacity-1) || (front != 0 && rear == (front-1)%(capacity))){
            return true;
        }
        return false;
    }

    public int peek(){
        if (isEmpty()){
//            System.out.println("Circlur Queue is Empty");
            return -1;
        }
//        System.out.println(circularQueue[front]);
        return circularQueue[front];
    }

    public void enqueue(int val){
        if (isFull()){
            System.out.println("Circlur Queue is full");
            return;
        }

        if (isEmpty()){
            front = 0;
            rear = 0;
        }
        else if (rear == capacity-1 && front != 0) {    //circular insertion
            rear = 0;
        } else {    //normal case
            rear++;
        }
        size++;
        circularQueue[rear] = val;
    }

    public int deque(){
        if (isEmpty()){
            System.out.println("Circlur Queue is empty");
            return -1;
        }
        int val = circularQueue[front];
        if (front == rear){
            front = -1;
            rear = -1;
        } else if (front == capacity-1){    //circular deletion
            front = 0;
        }
        else {  //normal
            front++;
        }
        size--;
        return val;
    }

    public int size(){
//        System.out.println(size);
        return size;
    }

    public void printQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Print Circular Queue :- ");
        //circular case
        if (rear <= front){
            for (int i = front; i <= capacity-1; i++) {
                System.out.print(circularQueue[i]);
                System.out.print(", ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(circularQueue[i]);
                if (i != rear){
                    System.out.print(", ");
                }
            }
        }
        else {
            for (int i = front; i <= rear; i++) {
                System.out.print(circularQueue[i]);
                if (i != rear){
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }
}

class MyDoubleEndedQueue{
    int front;
    int rear;
    int capacity;
    int size;
    int []deque;

    public MyDoubleEndedQueue(int capacity){
        this.capacity = capacity;
        size = 0;
        front = rear = -1;
        deque = new int[capacity];
    }

    public boolean isEmpty(){
        if(front == -1 && rear == -1){      //if(front == -1)       //if(front == -1 || rear == -1)
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if ((front == 0 && rear == capacity-1) || (front != 0 && rear == (front-1)%(capacity))){
            return true;
        }
        return false;
    }

    public int peekFront(){
        if (isEmpty()){
//            System.out.println("Deque is Empty");
            return -1;
        }
//        System.out.println(deque[front]);
        return deque[front];
    }

    public int peekRear(){
        if (isEmpty()){
            return -1;
        }
        return deque[rear];
    }

    public void enqueueFront(int val){
        if (isFull()){
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()){
            front = 0;
            rear = 0;
        }
        else if (front == 0 && rear != capacity-1) {    //deque insertion
            front = capacity - 1;
        } else {    //normal case
            front--;
        }
        size++;
        deque[front] = val;
    }

    public void enqueueRear(int val){
        if (isFull()){
            System.out.println("Deque is full");
            return;
        }

        if (isEmpty()){
            front = 0;
            rear = 0;
        }
        else if (rear == capacity-1 && front != 0) {    //deque insertion
            rear = 0;
        } else {    //normal case
            rear++;
        }
        size++;
        deque[rear] = val;
    }

    public int dequeFront(){
        if (isEmpty()){
            System.out.println("Deque is empty");
            return -1;
        }
        int val = deque[front];
        if (front == rear){
            front = -1;
            rear = -1;
        } else if (front == capacity-1){    //deque deletion
            front = 0;
        }
        else {  //normal
            front++;
        }
        size--;
        return val;
    }

    public int dequeRear(){
        if (isEmpty()){
            System.out.println("Deque is empty");
            return -1;
        }
        int val = deque[rear];
        if (front == rear){
            front = -1;
            rear = -1;
        } else if (rear == 0){    //deque deletion
            rear = capacity - 1;
        }
        else {  //normal
            rear--;
        }
        size--;
        return val;
    }

    public int size(){
//        System.out.println(size);
        return size;
    }

    public void printQueue(){
        if (isEmpty()){
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Print Deque :- ");
        //circular case
        if (rear <= front){
            for (int i = front; i <= capacity-1; i++) {
                System.out.print(deque[i]);
                System.out.print(", ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(deque[i]);
                if (i != rear){
                    System.out.print(", ");
                }
            }
        }
        else {
            for (int i = front; i <= rear; i++) {
                System.out.print(deque[i]);
                if (i != rear){
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }
}

public class Lecture_71 {
    public static void main(String[] args) {
//        queue();
//        circularQueue();
//        doubleEndedQueue();

//        queuePRMD();
//        cQuePrm();
        deQuePrm();
    }


    public static void deQuePrm(){
        DoubleEndQueuePRM dq = new DoubleEndQueuePRM(5);
        System.out.println("Deque is Capacity :"+dq.capacity);
        System.out.println("Deque is Empty : "+dq.isEmpty());
        System.out.println("Deque is Full : "+dq.isFull());
        System.out.println("Deque is Peek : "+dq.peekFront());
        System.out.println("Deque is Peek : "+dq.peekRear());
        System.out.println("Deque is Size : "+dq.getSize());

        dq.enqueueFront(1);
        dq.enqueueRear(2);
        dq.enqueueFront(3);
        dq.enqueueRear(4);
        dq.enqueueFront(5);
        dq.enqueueRear(6);
        System.out.println("Deque is Empty : "+dq.isEmpty());
        System.out.println("Deque is Full : "+dq.isFull());
        System.out.println("Deque is Peek : "+dq.peekFront());
        System.out.println("Deque is Peek : "+dq.peekRear());
        System.out.println("Deque is Size : "+dq.getSize());
        dq.printQueue();


        System.out.println("Deque is Full : "+dq.isFull());
        dq.dequeFront();
        System.out.println("Deque is Full : "+dq.isFull());
        dq.printQueue();

        dq.dequeRear();
        dq.printQueue();

        dq.dequeFront();
        dq.printQueue();

        dq.dequeRear();
        dq.printQueue();

        dq.dequeFront();
        System.out.println("Deque is Empty : "+dq.isEmpty());
        System.out.println("Deque is Full : "+dq.isFull());
        System.out.println("Deque is Peek : "+dq.peekFront());
        System.out.println("Deque is Peek : "+dq.peekRear());
        System.out.println("Deque is Size : "+dq.getSize());
        dq.printQueue();
    }
    public static void cQuePrm(){
        CircularQueuePRM cque = new CircularQueuePRM(5);

        System.out.println("Circular Queue is Empty : "+cque.isEmpty());
        System.out.println("Circular Queue is Full : "+cque.isFull());
        System.out.println("Circular Queue is Size : "+cque.getSize());
        System.out.println("Circular Queue is Peek : "+cque.peek());
        cque.enqueue(5);
        cque.enqueue(4);
        cque.enqueue(3);
        cque.enqueue(2);
        cque.enqueue(1);
        cque.enqueue(11);
        cque.printCircularQueue();

        System.out.println("Circular Queue is Empty : "+cque.isEmpty());
        System.out.println("Circular Queue is Full : "+cque.isFull());
        System.out.println("Circular Queue is Size : "+cque.getSize());
        System.out.println("Circular Queue is Peek : "+cque.peek());

        cque.deque();

        cque.printCircularQueue();

        System.out.println("Circular Queue is Empty : "+cque.isEmpty());
        System.out.println("Circular Queue is Full : "+cque.isFull());
        System.out.println("Circular Queue is Size : "+cque.getSize());
        System.out.println("Circular Queue is Peek : "+cque.peek());

        cque.deque();
        cque.deque();
        cque.deque();
        cque.deque();
        cque.printCircularQueue();

        System.out.println("Circular Queue is Empty : "+cque.isEmpty());
        System.out.println("Circular Queue is Full : "+cque.isFull());
        System.out.println("Circular Queue is Size : "+cque.getSize());
        System.out.println("Circular Queue is Peek : "+cque.peek());

    }
    public static void queuePRMD(){
        QueuePRM qprm = new QueuePRM(5);
        System.out.println("Queue is empty : "+qprm.isEmpty());
        System.out.println("Queue is full : "+qprm.isFull());
        qprm.enqueue(5);
        qprm.printQueue();
        qprm.enqueue(4);
        qprm.enqueue(3);
        qprm.enqueue(2);
        qprm.enqueue(1);
        System.out.println("Queue size : "+qprm.getSize());
        qprm.printQueue();

        qprm.deque();
        qprm.deque();
        qprm.printQueue();
        System.out.println("Queue size : "+qprm.getSize());

        System.out.println("Queue is full : "+qprm.isFull());
        qprm.deque();
        qprm.deque();
        qprm.printQueue();
        System.out.println("Queue size : "+qprm.getSize());


        qprm.deque();
        qprm.printQueue();
        System.out.println("Queue size : "+qprm.getSize());
        System.out.println("Queue is empty : "+qprm.isEmpty());
        System.out.println("Queue is full : "+qprm.isFull());

        qprm.deque();
        qprm.printQueue();
        System.out.println("Queue size : "+qprm.getSize());
        System.out.println("Queue is empty : "+qprm.isEmpty());
        System.out.println("Queue is full : "+qprm.isFull());
    }

    public static void doubleEndedQueue(){
        MyDoubleEndedQueue myDEQue = new MyDoubleEndedQueue(5);

        System.out.println("Deque is Capacity :"+myDEQue.capacity);
        System.out.println("Deque is Empty : "+myDEQue.isEmpty());
        System.out.println("Deque is Full : "+myDEQue.isFull());
        System.out.println("Deque is Peek : "+myDEQue.peekFront());
        System.out.println("Deque is Peek : "+myDEQue.peekRear());
        System.out.println("Deque is Size : "+myDEQue.size());

        myDEQue.enqueueFront(1);
        myDEQue.enqueueRear(2);
        myDEQue.enqueueFront(3);
        myDEQue.enqueueRear(4);
        myDEQue.enqueueFront(5);
        myDEQue.enqueueRear(6);
        System.out.println("Deque is Empty : "+myDEQue.isEmpty());
        System.out.println("Deque is Full : "+myDEQue.isFull());
        System.out.println("Deque is Peek : "+myDEQue.peekFront());
        System.out.println("Deque is Peek : "+myDEQue.peekRear());
        System.out.println("Deque is Size : "+myDEQue.size());
        myDEQue.printQueue();


        System.out.println("Deque is Full : "+myDEQue.isFull());
        myDEQue.dequeFront();
        System.out.println("Deque is Full : "+myDEQue.isFull());
        myDEQue.printQueue();

        myDEQue.dequeRear();
        myDEQue.printQueue();

        myDEQue.dequeFront();
        myDEQue.printQueue();

        myDEQue.dequeRear();
        myDEQue.printQueue();

        myDEQue.dequeFront();
        System.out.println("Deque is Empty : "+myDEQue.isEmpty());
        System.out.println("Deque is Full : "+myDEQue.isFull());
        System.out.println("Deque is Peek : "+myDEQue.peekFront());
        System.out.println("Deque is Peek : "+myDEQue.peekRear());
        System.out.println("Deque is Size : "+myDEQue.size());
        myDEQue.printQueue();

    }

    public static void circularQueue(){
        MyCircularQueue mcq = new MyCircularQueue(5);

        System.out.println("Circular Queue is Capacity :"+mcq.capacity);
        System.out.println("Circular Queue is Empty : "+mcq.isEmpty());
        System.out.println("Circular Queue is Full : "+mcq.isFull());
        System.out.println("Circular Queue is Peek : "+mcq.peek());
        System.out.println("Circular Queue is Size : "+mcq.size());

        mcq.enqueue(1);
        mcq.enqueue(2);
        mcq.enqueue(3);
        mcq.enqueue(4);
        mcq.enqueue(5);
        mcq.enqueue(6);
        System.out.println("Circular Queue is Empty : "+mcq.isEmpty());
        System.out.println("Circular Queue is Full : "+mcq.isFull());
        System.out.println("Circular Queue is Peek : "+mcq.peek());
        System.out.println("Circular Queue is Size : "+mcq.size());
        mcq.printQueue();


        System.out.println("Circular Queue is Full : "+mcq.isFull());
        mcq.deque();
        System.out.println("Circular Queue is Full : "+mcq.isFull());
        mcq.printQueue();
        mcq.enqueue(7);

        System.out.println("Circular Queue is Full : "+mcq.isFull());
        mcq.printQueue();

        System.out.println("Circular Queue is Peek : "+mcq.peek());
        mcq.deque();
        System.out.println("Circular Queue is Full : "+mcq.isFull());
        mcq.printQueue();

        mcq.deque();
        mcq.deque();
        mcq.deque();
        mcq.deque();
        System.out.println("Circular Queue is Empty : "+mcq.isEmpty());
        System.out.println("Circular Queue is Full : "+mcq.isFull());
        System.out.println("Circular Queue is Peek : "+mcq.peek());
        System.out.println("Circular Queue is Size : "+mcq.size());

    }

    public static void queue(){
        MyQueue que = new MyQueue(5);


        que.peek();
        que.size();


        que.enqueue(1);
        que.enqueue(2);
        que.enqueue(3);
        que.enqueue(4);
        que.enqueue(5);

        que.printQueue();
        que.size();


        que.peek();
        que.deque();
        que.printQueue();
        que.isEmpty();
        que.isFull();

        que.peek();
        que.printQueue();
        que.isEmpty();
        que.isFull();


        que.deque();
        que.deque();
        que.deque();
        que.deque();


        que.printQueue();
        que.isEmpty();
        que.isFull();
    }

}



/*


class MyDoubleEndedQueue {
    int front;
    int rear;
    int capacity;
    int size;
    int[] deque;

    public MyDoubleEndedQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        front = -1;
        rear = -1;
        deque = new int[capacity];
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return (front == (rear + 1) % capacity);
    }

    public int peekFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int peekRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    public void enqueueFront(int val) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        deque[front] = val;
        size++;
    }

    public void enqueueRear(int val) {
        if (isFull()) {
            System.out.println("Deque is full");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        deque[rear] = val;
        size++;
    }

    public int dequeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        int val = deque[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return val;
    }

    public int dequeRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        int val = deque[rear];

        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        size--;
        return val;
    }

    public int getSize() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }

        System.out.println("Print Deque :- ");
        int i = front;
        while (true) {
            System.out.print(deque[i]);
            if (i == rear) break;
            System.out.print(", ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}


 */