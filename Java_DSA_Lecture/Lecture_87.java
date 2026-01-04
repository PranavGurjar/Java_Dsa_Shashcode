
//Introduction to linked list | Linked list in java

class Node<T> {
    T data;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    Node next;
    Node(){
        this.next = null;
    }
}

class ll{
    Node<Integer> head;
    int size;

    public ll() {
        this.head = null;
        this.size = 0;
    }

    public void insertHead1(int data){
        Node<Integer> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            System.out.println("Insert on head success");
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        System.out.println("Insert on head success");
        size++;
    }

    public void insertTail1(int data){
        Node<Integer> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            System.out.println("Insert on tail success");
            size++;
            return;
        }
        Node<Integer> temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Insert on tail success");
        size++;
    }

    public void insertNode1(int data, int position){
        if (position <= 0 || position > size+1){
            System.out.println("Wrong position");
            return;
        }
        //head
        if (position == 1){
            insertHead1(data);
        }
        else if (position == size+1){
            insertTail1(data);
        }
        else {
            Node<Integer> newNode = new Node<>(data);
            Node<Integer> temp = head;
            int counter = 1;
            while(counter < position-1 && temp != null){
                counter++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
        System.out.println("Insert on position : "+position+" success");
    }

    public void deleteHead1(){
        if (head == null){
            System.out.println("LL is empty");
            return;
        }
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("Delete on head");
        size--;
    }

    public void deleteTail1(){
        if (head == null){
            System.out.println("LL is empty");
            return;
        }
        if (head.next == null){
            head = null;
            size--;
            System.out.println("Delete at tail");
            return;
        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        size--;
        System.out.println("Delete at tail");
    }

    public void deleteNode1(int position){
            if (position <= 0 || position > size){
                System.out.println("Wrong input");
                return;
            }

            if (position == 1){
                deleteHead1();
            } else if (position == size) {
                deleteTail1();
            }
            else {
                int counter = 1;
                Node<Integer> prev = null;
                Node<Integer> temp = head;
                while (counter<position-1 && temp != null){
                    counter++;
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = temp.next;
                temp.next = null;
                size--;
                System.out.println("Deletion successful at position "+position);
            }
        }

    public void updateNode1(int position, int updateValue){
        if (head == null){
            System.out.println("LL is empty");
            return;
        }
        int counter = 1;
        Node<Integer> temp = head;
        while (counter<position && temp!=null){
            counter++;
            temp = temp.next;
        }
        if (temp!=null && counter == position){
            temp.data = updateValue;
        }
        else {
            System.out.println("Size of ll is small than position "+position);
            return;
        }
        System.out.println("Update at position : "+position+"was successful");
    }

    public boolean searchNode1(int searchValue){
        if (head == null){
            System.out.println("ll is empty");
            return false;
        }
        int counter = 1;
        Node<Integer> temp = head;
        while (temp!=null){
            if (temp.data == searchValue){
                System.out.println("Fount at position : "+counter);
                return true;
            }
            counter++;
            temp = temp.next;
        }
        System.out.println("Not found");
        return false;
    }

    public void printList1(){
       Node<Integer> temp = head;
        System.out.println("Data : ");
        while (temp!=null){
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

class MyLinkedList{
    Node<Integer> head;
    int size;
    public MyLinkedList() {
        this.head = null;
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
            Node<Integer> newNode = new Node<>(data);
            Node<Integer> temp = head;
            while (counter<position-1 && temp!=null){
                counter++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
        System.out.println("Insertion successful at position "+position);
    }

    public void insertHead(int data){
        Node<Integer> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            System.out.println("Insertion at head is successful");
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        System.out.println("Insertion at head is successful");
        size++;
    }

    public void insertTail(int data){
        Node<Integer> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            System.out.println("Insertion at tail is successful");
            size++;
            return;
        }
        Node<Integer> temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
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
            Node<Integer> prev = null;
            Node<Integer> temp = head;
            while (counter<position-1 && temp!=null){
                counter++;
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
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
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("Deletion at head is successful");
        size--;
    }

    public void deleteTail(){
        if (head == null){
            System.out.println("Linked List Is Empty");
            return;
        }
        if (head.next == null){
            head = null;
            size--;
            return;
        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        System.out.println("Deletion at tail is successful");
        size--;
    }

    public void updateNode(int position, int updateValue){
        if (head == null){
            System.out.println("Linked List Is Empty");
            return;
        }
        int counter = 1;
        Node<Integer> temp = head;
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
        Node<Integer> temp = head;
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
        Node<Integer> temp = head;
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
}



public class Lecture_87 {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.insertTail(10);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.insertTail(20);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.insertHead(5);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.insertNode(25, 4);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.insertNode(23, 4);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteTail();
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteHead();
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteNode(3);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteNode(1);
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);
        obj.deleteNode(3);
        obj.printList();
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
        System.out.println("Search 10 : "+obj.searchNode(100));
        obj.printList();
        System.out.println("Linked List Size -> "+obj.size);

    }
}
