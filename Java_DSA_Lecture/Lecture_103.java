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
//    public ListNode insertionSortList(ListNode head) {
//        if (head == null || head.next == null){
//            return head;
//        }
//        ListNode temp = head.next;
//        ListNode sortHead = head;
//        ListNode sortTail = head;
//
//        while (temp != null){
//            //temp is already at sorted position (insertion at the tail)
//            if (temp.val >= sortTail.val){
//                sortTail = temp;
//                temp = temp.next;
//                continue;
//            }
//            sortTail.next = temp.next;
////            temp.next = null;
//            ListNode prev = null;
//            ListNode t1 = head;
//            while (t1 != sortTail.next){
//                if (t1.val >= temp.val){
//                    break;
//                }
//                prev = t1;
//                t1 = t1.next;
//            }
//
//            if (prev == null){
//                temp.next = head;
//                head = temp;
//            }
//            else {
//                //insert at specific position
//                temp.next = prev.next;
//                prev.next = temp;
//            }
//            temp = sortTail.next;
//        }
//        return head;
//    }
//}


class InsertionSortNode{
    int val;
    InsertionSortNode next;

    public InsertionSortNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class InsertionSortSolution {
    public InsertionSortNode insertionSortList(InsertionSortNode head) {
        if (head == null || head.next == null){
            return head;
        }
        InsertionSortNode temp = head.next;
        InsertionSortNode sortHead = head;
        InsertionSortNode sortTail = head;

        while (temp != null){
            //temp is already at sorted position (insertion at the tail)
            if (temp.val >= sortTail.val){
                sortTail = temp;
                temp = temp.next;
                continue;
            }
            sortTail.next = temp.next;
//            temp.next = null;
            InsertionSortNode prev = null;
            InsertionSortNode t1 = head;
            while (t1 != sortTail.next){
                if (t1.val >= temp.val){
                    break;
                }
                prev = t1;
                t1 = t1.next;
            }

            if (prev == null){
                temp.next = head;
                head = temp;
            }
            else {
                //insert at specific position
                temp.next = prev.next;
                prev.next = temp;
            }
            temp = sortTail.next;
        }
        return head;
    }
}

public class Lecture_103 {
    public static InsertionSortNode buildNode(int []arr){
        InsertionSortNode head = null;
        InsertionSortNode temp = null;
        for (int val : arr){
            InsertionSortNode node = new InsertionSortNode(val);
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

    public static void printList(InsertionSortNode head){
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
        int []arr = {2, 4, 3, 1, 5};

        System.out.println("Before Insertion Sort List : ");
        InsertionSortNode node1 = buildNode(arr);
        printList(node1);


        System.out.println("After Insertion Sort List : ");
        InsertionSortSolution sol = new InsertionSortSolution();
        InsertionSortNode result = sol.insertionSortList(node1);
        printList(result);

    }
}
