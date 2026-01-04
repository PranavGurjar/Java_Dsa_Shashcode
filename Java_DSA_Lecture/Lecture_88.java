class DoublyNode<T> {
    T data;

    DoublyNode next;
    DoublyNode prev;

    DoublyNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    DoublyNode(){
        this.next = null;
        this.prev = null;
    }
}


class MyDoublyLinkedList{
    DoublyNode<Integer> head;
    DoublyNode<Integer> tail;
    int size;
    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertNode(int data, int position){
        if (position>size+1 || position <= 0){
            System.out.println("Wrong input");
            return;
        }
        // head
        if (position == 1){
            insertHead(data);
            return;
        }
        else if (position == size+1){
            insertTail(data);
            return;
        }
        else {
            int counter = 1;
            DoublyNode<Integer> newNode = new DoublyNode<>(data);
            DoublyNode<Integer> temp = head;
            while (counter<position-1 && temp!=null){
                counter++;
                temp = temp.next;
            }
            DoublyNode<Integer> currentNode = temp.next;

            newNode.next = currentNode;
            currentNode.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        }
        System.out.println("Insertion successful at position "+position);
    }

    public void insertHead(int data){
        DoublyNode<Integer> newNode = new DoublyNode<>(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            System.out.println("Insertion at head is successful");
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        System.out.println("Insertion at head is successful");
        size++;
    }

    public void insertTail(int data){
       DoublyNode<Integer> newNode = new DoublyNode<>(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            System.out.println("Insertion at tail is successful");
            size++;
            return;
        }
        DoublyNode<Integer> temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        tail = newNode;
        System.out.println("Insertion at tail is successful");
        size++;
    }

    public void deleteNode(int position){
        if (position>size || position <= 0){
            System.out.println("Wrong input");
            return;
        }
        // head
        if (position == 1){
            deleteHead();
        }
        else if (position == size){
            deleteTail();
        }
        else {
            int counter = 1;
            DoublyNode<Integer> prevNode = null;
            DoublyNode<Integer> temp = head;
            while (counter<position-1 && temp!=null){
                counter++;
                prevNode = temp;
                temp = temp.next;
            }
            DoublyNode<Integer> nextNode = temp.next;
            prevNode.next = nextNode;
            if (nextNode != null){
                nextNode.prev = prevNode;
            }
            temp.prev = null;
            temp.next = null;
            size--;
            System.out.println("Deletion successful at position "+position);
        }
    }

    public void deleteHead(){
        if (head == null){
            System.out.println("Linked List Is Empty");
            return;
        }
        DoublyNode<Integer> temp = head;
        head = head.next;
        temp.next = null;
        if (head == null){
            tail = null;
        }
        else {
            head.prev = null;
        }
        System.out.println("Deletion at head is successful");
        size--;
    }

    public void deleteTail(){
        if (head == null){
            System.out.println("Linked List Is Empty");
            return;
        }
        //single node
        if (head.next == null){
            head = null;
            tail = null;
            System.out.println("Deletion at tail is successful");
            size--;
            return;
        }
        DoublyNode<Integer> temp = head;
        DoublyNode<Integer> prevNode = null;
        while(temp.next!=null){
            prevNode = temp;
            temp = temp.next;
        }
        prevNode.next = null;
        temp.prev = null;
        tail = prevNode;
        System.out.println("Deletion at tail is successful");
        size--;
    }

    public void updateNode(int position, int updateValue){
        if (head == null){
            System.out.println("Linked List Is Empty");
            return;
        }
        int counter = 1;
        DoublyNode<Integer> temp = head;
        while (counter<position && temp != null){
            counter++;
            temp = temp.next;
        }
        if (temp != null && counter == position){
            temp.data = updateValue;
        }else {
            System.out.println("Size of linked list is smaller than position "+position);
            return;
        }
        System.out.println("Update at position "+position+" was successful");
    }

    public boolean searchNode(int searchValue){
        if (head == null){
            System.out.println("Linked List Is Empty");
            return false;
        }
        int counter = 1;
        DoublyNode<Integer> temp = head;
        while (temp != null){
            if (temp.data == searchValue){
                System.out.println("Found at position "+counter);
                return true;
            }
            counter++;
            temp = temp.next;
        }
        System.out.println("Not Found!");
        return false;
    }

    public void printList(){
        DoublyNode<Integer> temp = head;
        System.out.print("Data is -> ");
        while (temp!=null){
            System.out.print(temp.data);
            temp = temp.next;
            if (temp!=null){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void printListInReverse(){
        DoublyNode<Integer> temp = tail;
        System.out.print("Data is -> ");
        while (temp!=null){
            System.out.print(temp.data);
            temp = temp.prev;
            if (temp!=null){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}


public class Lecture_88 {
    public static void main(String[] args) {
        MyDoublyLinkedList obj = new MyDoublyLinkedList();
        obj.insertTail(10);
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.insertTail(20);
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.insertHead(5);
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.insertNode(25, 4);
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.insertNode(23, 4);
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteTail();
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteHead();
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteNode(3);
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteNode(1);
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteNode(3);
        obj.printList();
        obj.printListInReverse();
        System.out.println("Linked List Size -> "+obj.size);
        obj.updateNode(1, 10);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.updateNode(6, 30);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.updateNode(2, 30);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        System.out.println("Search 10 : "+obj.searchNode(10));
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);

    }
}
