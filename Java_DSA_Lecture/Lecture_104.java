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
//    public ListNode sortList(ListNode head) {
//        return mergeSort(head);
//    }
//    public ListNode mergeSort(ListNode head) {
//        if (head == null || head.next == null){
//            return head;
//        }
//
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode prev = null;
//
//        while (fast != null && fast.next != null){
//            prev = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        prev.next = null;
//        ListNode head1 = mergeSort(head);
//        ListNode head2 = mergeSort(slow);
//
//        ListNode ans = merge(head1, head2);
//        return ans;
//    }
//
//    public ListNode merge(ListNode head1, ListNode head2){
//        ListNode ansHead = new ListNode(-1);
//        ListNode ansTail = ansHead;
//
//        while (head1 != null && head2 != null){
//            if (head1.val <= head2.val){
//                ansTail.next = new ListNode(head1.val);
//                head1 = head1.next;
//            }
//            else {
//                ansTail.next = new ListNode(head2.val);
//                head2 = head2.next;
//            }
//            ansTail = ansTail.next;
//        }
//
//        while (head1 != null){
//            ansTail.next = new ListNode(head1.val);
//            head1 = head1.next;
//            ansTail = ansTail.next;
//        }
//
//        while (head2 != null){
//            ansTail.next = new ListNode(head2.val);
//            head2 = head2.next;
//            ansTail = ansTail.next;
//        }
//        ListNode t1 = ansHead;
//        ansHead = ansHead.next;
//        t1.next = null;
//
//        return ansHead;
//    }
//}

class MergeNode{
    int val;
    MergeNode next;

    public MergeNode(int val) {
        this.val = val;
        this.next = null;
    }
}


class MergeSolution {
    public MergeNode sortList(MergeNode head) {
        return mergeSort(head);
    }
    public MergeNode mergeSort(MergeNode head) {
        if (head == null || head.next == null){
            return head;
        }

        MergeNode slow = head;
        MergeNode fast = head;
        MergeNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        MergeNode head1 = mergeSort(head);
        MergeNode head2 = mergeSort(slow);

        MergeNode ans = merge(head1, head2);
        return ans;
    }

    public MergeNode merge(MergeNode head1, MergeNode head2){
        MergeNode ansHead = new MergeNode(-1);
        MergeNode ansTail = ansHead;

        while (head1 != null && head2 != null){
            if (head1.val <= head2.val){
                ansTail.next = new MergeNode(head1.val);
                head1 = head1.next;
            }
            else {
                ansTail.next = new MergeNode(head2.val);
                head2 = head2.next;
            }
            ansTail = ansTail.next;
        }

        while (head1 != null){
            ansTail.next = new MergeNode(head1.val);
            head1 = head1.next;
            ansTail = ansTail.next;
        }

        while (head2 != null){
            ansTail.next = new MergeNode(head2.val);
            head2 = head2.next;
            ansTail = ansTail.next;
        }
        MergeNode t1 = ansHead;
        ansHead = ansHead.next;
        t1.next = null;

        return ansHead;
    }
}

public class Lecture_104 {
    public static MergeNode buildNode(int []arr){
        MergeNode head = null;
        MergeNode temp = null;
        for (int val : arr){
            MergeNode node = new MergeNode(val);
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

    public static void printList(MergeNode head){
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
        int []arr = {4, 5, 2, 3, 1};

        System.out.println("Before List : ");
        MergeNode node = buildNode(arr);
        printList(node);

        System.out.println("After List : ");
        MergeSolution sol = new MergeSolution();
        MergeNode result = sol.mergeSort(node);
        printList(result);
    }
}









