/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.

//class Solution {
//    Node sortedInsert(Node head, int key) {
//        Node newNode = new Node(key);
//        Node prev = null;
//        Node temp = head;
//
//        while (temp != null){
//            if (temp.data >= key){
//                break;
//            }
//            prev = temp;
//            temp = temp.next;
//        }
//        if (prev == null){
//            newNode.next = head;
//            head = newNode;
//        }
//        else {
//            newNode.next = prev.next;
//            prev.next = newNode;
//        }
//        return head;
//    }
//}

class InSortNode{
    int data;
    InSortNode next;

    public InSortNode(int data) {
        this.data = data;
        this.next = null;
    }
}


class InSortSolution {
    InSortNode sortedInsert(InSortNode head, int key) {
        InSortNode newNode = new InSortNode(key);
        InSortNode prev = null;
        InSortNode temp = head;

        while (temp != null){
            if (temp.data >= key){
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (prev == null){
            newNode.next = head;
            head = newNode;
        }
        else {
            newNode.next = prev.next;
            prev.next = newNode;
        }
        return head;
    }
}

public class Lecture_102 {
    public static InSortNode buildNode(int []arr){
        InSortNode head = null;
        InSortNode temp = null;
        for (int val : arr){
            InSortNode node = new InSortNode(val);
            if (head == null){
                head = node;
                temp = node;
            }
            else {
                temp.next = node;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void printList(InSortNode head){
        while (head != null){
            System.out.print(head.data);
            if (head.next != null){
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("Before Sort : ");
        InSortNode node = buildNode(arr);
        printList(node);


        System.out.println("After Sort : ");
        InSortSolution sol1 = new InSortSolution();
        InSortNode result = sol1.sortedInsert(node, 8);
        printList(result);
    }
}
