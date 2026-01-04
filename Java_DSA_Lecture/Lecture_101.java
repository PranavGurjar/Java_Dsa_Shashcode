/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//public class Solution {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode t1 = headA;
//        ListNode t2 = headB;
//
//        while (t1 != t2){
//            t1 = (t1 == null) ? headB : t1.next;
//            t2 = (t2 == null) ? headA : t2.next;
//        }
//        return t1;
//    }
//}

class InSecNode{
    int val;
    InSecNode next;

    public InSecNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class IntSecSolution {
    public InSecNode getIntersectionNode(InSecNode headA, InSecNode headB) {
        InSecNode t1 = headA;
        InSecNode t2 = headB;

        while (t1 != t2){
            t1 = (t1 == null) ? headB : t1.next;
            t2 = (t2 == null) ? headA : t2.next;
        }
        return t1;
    }
}

public class Lecture_101 {
    public static InSecNode buildNode(int []arr){
        InSecNode head = null;
        InSecNode temp = null;
        for (int val : arr){
            InSecNode node = new InSecNode(val);
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

    public static void printList(InSecNode head){
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
//        int []arr = {1, 2, 3, 4, 5, 6, 7};
//        int []brr = {8, 9, 4, 5, 6, 7};

        InSecNode n1 = new InSecNode(1);
        InSecNode n2 = new InSecNode(2);
        InSecNode n3 = new InSecNode(3);
        InSecNode n4 = new InSecNode(4);
        InSecNode n5 = new InSecNode(5);
        InSecNode n6 = new InSecNode(6);
        InSecNode n7 = new InSecNode(7);
        InSecNode n8 = new InSecNode(8);
        InSecNode n9 = new InSecNode(9);

        //Linked List 1
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        //Linked List 2
        n8.next = n9;
        n9.next = n4;

        System.out.println("Before Node1 : ");
        printList(n1);

        System.out.println("Before Node2 : ");
        printList(n8);

        System.out.println("Result : ");
        IntSecSolution sol1 = new IntSecSolution();
        InSecNode res1 = sol1.getIntersectionNode(n1, n8);
        printList(res1);

        System.out.println("Intersected Point : "+res1.val);

    }
}
