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
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode first = head;
//        ListNode second = head;
//
//        while (n>0 && second != null){
//            n--;
//            second = second.next;
//        }
//
//        //node out of bound
//        if (n != 0){
//            return head;
//        }
//
//        //only 3 node present and then delete first node
//        if (second == null){
//            ListNode temp = head;
//            head = head.next;
//            temp.next = null;
//            return head;
//        }
//
//        ListNode prev = null;
//        while (second != null){
//            second = second.next;
//            prev = first;
//            first = first.next;
//        }
//        prev.next = first.next;
//        first.next = null; //node to be deleted
//        return head;
//    }
//}

class DelNListNode{
    int val;
    DelNListNode next;

    public DelNListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class DelNSolution {
    public DelNListNode removeNthFromEnd(DelNListNode head, int n) {
        DelNListNode first = head;
        DelNListNode second = head;

        while (n>0 && second != null){
            n--;
            second = second.next;
        }

        //node out of bound
        if (n != 0){
            return head;
        }

        //only 3 node present and then delete first node
        if (second == null){
            DelNListNode temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }

        DelNListNode prev = null;
        while (second != null){
            second = second.next;
            prev = first;
            first = first.next;
        }
        prev.next = first.next;
        first.next = null; //node to be deleted
        return head;
    }
}

public class Lecture_98 {
    public static DelNListNode buildNode(int []arr){
        DelNListNode head = null;
        DelNListNode temp = null;
        for (int val : arr){
            DelNListNode node = new DelNListNode(val);
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

    public static void printList(DelNListNode head){
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
        int []arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        DelNListNode node = buildNode(arr);
        System.out.println("Before Remove Nth From End : ");
        printList(node);

        DelNSolution sol1 = new DelNSolution();
        sol1.removeNthFromEnd(node,3);
        System.out.println("After Remove Nth From End : ");
        printList(node);
    }
}
