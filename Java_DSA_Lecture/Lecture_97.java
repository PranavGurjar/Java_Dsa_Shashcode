/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {
//    public int len(ListNode head){
//        int counter = 0;
//        while (head != null){
//            counter++;
//            head = head.next;
//        }
//        return counter;
//    }
//    public ListNode reverseKGroup(ListNode head, int k) {
//        int n = len(head);
//        int groups = n/k;
//        ListNode prevHead = null;
//        ListNode currHead = head;
//        ListNode ansNode = null;
//
//        for (int i = 0; i < groups; i++) {
//            ListNode prev = null;
//            ListNode curr = currHead;
//            ListNode nextNode = null;
//            //Rev - K Group
//            for (int j = 0; j < k; j++) {
//                nextNode = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = nextNode;
//            }
//            if (prevHead == null){
//                ansNode = prev;
//            }else {
//                prevHead.next = prev;
//            }
//            prevHead = currHead;
//            currHead = curr;
//        }
//        //link the last incomplete group and if last group was complete
//        //currHead would be null
//        prevHead.next = currHead;
//        return ansNode;
//    }
//}

class RevKListNode{
    int val;
    RevKListNode next;

    RevKListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

//Reverse Nodes in k-Group
class RevKSolution1 {
    public int len(RevKListNode head){
        int counter = 0;
        while (head != null){
            counter++;
            head = head.next;
        }
        return counter;
    }
    public RevKListNode reverseKGroup(RevKListNode head, int k) {
        int N = len(head);
        int groups = N/k;
        RevKListNode prevHead = null;
        RevKListNode currHead = head;
        RevKListNode ansNode = null;

        for (int i = 0; i < groups; i++) {
            RevKListNode prev = null;
            RevKListNode curr = currHead;
            RevKListNode nextNode = null;
            //Rev - K Group
            for (int j = 0; j < k; j++) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            if (prevHead == null){
                ansNode = prev;
            }else {
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }
        //link the last incomplete group and if last group was complete
        //currHead would be null
        prevHead.next = currHead;
        return ansNode;
    }
}

//class Solution {
//    public static Node reverse(Node head, int k) {
//
//        return reverseKGroup(head, k);
//    }
//    public static Node reverseKGroup(Node head, int K) {
//        Node prevHead = null;
//        Node currHead = head;
//        Node ansNode = null;
//
//        while (currHead != null){
//            Node prev = null;
//            Node curr = currHead;
//            Node nextNode = null;
//
//            int j=0;
//            while (j<K && curr != null){
//                nextNode = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = nextNode;
//                j++;
//            }
//            if (prevHead == null){
//                ansNode = prev;
//            }else {
//                prevHead.next = prev;
//            }
//            prevHead = currHead;
//            currHead = curr;
//        }
//        return ansNode;
//    }
//}


//Reverse a Linked List in groups of given size
class RevKSolution2 {
    public static RevKListNode reverse(RevKListNode head, int k) {
        // code here
        return reverseKGroup(head, k);
    }
    public static RevKListNode reverseKGroup(RevKListNode head, int K) {
        RevKListNode prevHead = null;
        RevKListNode currHead = head;
        RevKListNode ansNode = null;

//        for (int i = 0; i < groups; i++) {
        while (currHead != null){
            RevKListNode prev = null;
            RevKListNode curr = currHead;
            RevKListNode nextNode = null;
            //Rev - K Group
//            for (int j = 0; j < k; j++) {
            int j=0;
            while (j<K && curr != null){
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                j++;
            }
            if (prevHead == null){
                ansNode = prev;
            }else {
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }
        return ansNode;
    }
}


public class Lecture_97 {
    public static RevKListNode buildNode(int []arr){
        RevKListNode head = null;
        RevKListNode temp = null;
        for (int val : arr){
            RevKListNode node = new RevKListNode(val);
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

    public static void printList(RevKListNode head){
        while (head != null){
            System.out.print(head.val);
            if (head.next != null){
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println("Method 1: Before : ");
        RevKListNode node1 = buildNode(arr);
        printList(node1);


        System.out.println("Method 1: After : ");
        RevKSolution1 sol1 = new RevKSolution1();
        RevKListNode result1 = sol1.reverseKGroup(node1, 3);
        printList(result1);

        System.out.println("*********************************************************************");

        int []brr = {1, 2, 3, 4, 5, 6, 7, 8};


        System.out.println("Method 2: Before : ");
        RevKListNode node2 = buildNode(brr);
        printList(node2);


        System.out.println("Method 2: After : ");
        RevKSolution2 sol2 = new RevKSolution2();
        RevKListNode result2 = sol2.reverseKGroup(node2, 3);
        printList(result2);
    }
}
