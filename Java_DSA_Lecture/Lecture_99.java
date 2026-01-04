/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

//class Solution {
//    public Node segregate(Node head) {
//        Node zeroHead = new Node(-1);
//        Node zeroTail = zeroHead;
//        Node oneHead = new Node(-1);
//        Node oneTail = oneHead;
//        Node twoHead = new Node(-1);
//        Node twoTail = twoHead;
//        Node temp = head;
//
//        while (temp != null){
//            Node nextNode = temp.next;
//            if (temp.data == 0){
//                temp.next = null;
//                zeroTail.next = temp;
//                zeroTail = zeroTail.next;
//            }
//            else if (temp.data == 1){
//                temp.next = null;
//                oneTail.next = temp;
//                oneTail = oneTail.next;
//            }
//            else {
//                temp.next = null;
//                twoTail.next = temp;
//                twoTail = twoTail.next;
//            }
//            temp = nextNode;
//        }
//
//        if (oneHead.next == null){
//            zeroTail.next = twoHead.next;
//        }
//        else {
//            zeroTail.next = oneHead.next;
//            oneTail.next = twoHead.next;
//        }
//        //delete dummies
//        oneHead.next = null;
//        twoHead.next = null;
//        Node t1 = zeroHead;
//        zeroHead = zeroHead.next;
//        t1.next = null;
//
//        return zeroHead;
//    }
//}


class SortListNode{
    int data;
    SortListNode next;

    public SortListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class SortSolution {
    public SortListNode segregate(SortListNode head) {
        SortListNode zeroHead = new SortListNode(-1);
        SortListNode zeroTail = zeroHead;
        SortListNode oneHead = new SortListNode(-1);
        SortListNode oneTail = oneHead;
        SortListNode twoHead = new SortListNode(-1);
        SortListNode twoTail = twoHead;
        SortListNode temp = head;

        while (temp != null){
            SortListNode nextNode = temp.next;
            if (temp.data == 0){
                temp.next = null;
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            }
            else if (temp.data == 1){
                temp.next = null;
                oneTail.next = temp;
                oneTail = oneTail.next;
            }
            else {
                temp.next = null;
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = nextNode;
        }

        if (oneHead.next == null){
            zeroTail.next = twoHead.next;
        }
        else {
            zeroTail.next = oneHead.next;
            oneTail.next = twoHead.next;
        }
        //delete dummies
        oneHead.next = null;
        twoHead.next = null;
        SortListNode t1 = zeroHead;
        zeroHead = zeroHead.next;
        t1.next = null;

        return zeroHead;
    }
}

public class Lecture_99 {
    public static SortListNode buildNode(int []arr){
        SortListNode head = null;
        SortListNode temp = null;
        for (int val : arr){
            SortListNode node = new SortListNode(val);
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

    public static void printList(SortListNode head){
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
        int []arr = {1, 0, 2, 1, 2, 0};

        System.out.println("Before Sort : ");
        SortListNode node1 = buildNode(arr);
        printList(node1);


        System.out.println("After Sort : ");
        SortSolution sol1 = new SortSolution();
        SortListNode res1 = sol1.segregate(node1);
        printList(res1);
    }
}
