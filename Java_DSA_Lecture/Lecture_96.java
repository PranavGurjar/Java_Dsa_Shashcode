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
//    public ListNode oddEvenList(ListNode head) {
//        if (head == null || head.next == null){
//            return head;
//        }
//
//        ListNode odd = head;
//        ListNode even = head.next;
//        ListNode evenHead = head.next;
//
//        while (odd.next != null && even.next != null){
//            odd.next = even.next;
//            odd = odd.next;
//            even.next = odd.next;
//            even = even.next;
//        }
//        odd.next = evenHead;
//        return head;
//    }
//}

class OddEvenListNode{
    int val;
    OddEvenListNode next;

    public OddEvenListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class OddEvenSolution {
    public OddEvenListNode oddEvenList(OddEvenListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        OddEvenListNode odd = head;
        OddEvenListNode even = head.next;
        OddEvenListNode evenHead = head.next;

        while (odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

public class Lecture_96 {
    public static OddEvenListNode buildNode(int []arr){
        OddEvenListNode head = null;
        OddEvenListNode temp = null;
        for (int val : arr){
            OddEvenListNode node = new OddEvenListNode(val);
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

    public static void printList(OddEvenListNode head){
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
        int []arr = {1, 2, 3, 4, 5};

        System.out.println("Before OddEvenList : ");
        OddEvenListNode node = buildNode(arr);
        printList(node);

        System.out.println("After OddEvenList : ");
        OddEvenSolution sol1 = new OddEvenSolution();
        sol1.oddEvenList(node);
        printList(node);
    }
}
