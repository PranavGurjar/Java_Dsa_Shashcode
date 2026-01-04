
//Definition for singly-linked list.
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) {
//        this.val = val;
//    }
//    ListNode(int val, ListNode next) {
//        this.val val;
//        this.next = next; }
//}

//class Solution {
//    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
//        ListNode head = null;
//        ListNode temp = null;
//        int carry = 0;
//        while (l1 != null || l2 != null || carry != 0){
//            int val1 = (l1==null)?0:l1.val;
//            int val2 = (l2==null)?0:l2.val;
//            int value = val1 + val2 + carry;
//            ListNode newNode = new ListNode(value%10);
//            carry = value/10;   //maintain carry
//            if (head == null){
//                head = newNode;
//                temp = newNode;
//            }
//            else {
//                temp.next = newNode;
//                temp = temp.next;
//            }
//            if (l1 != null){
//                l1 = l1.next;
//            }
//            if (l2 != null){
//                l2 = l2.next;
//            }
//        }
//        return head;
//    }
//}

class AddListNode {
    int val;
    AddListNode next;
    AddListNode(int val) {
        this.val = val;
        this.next = null; }
}

class AddSolution {
    public AddListNode addTwoNumbers (AddListNode l1, AddListNode l2) {
        AddListNode head = null;
        AddListNode temp = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            int val1 = (l1==null)?0:l1.val;
            int val2 = (l2==null)?0:l2.val;
            int value = val1 + val2 + carry;
            AddListNode newNode = new AddListNode(value%10);
            carry = value/10;   //maintain carry
            if (head == null){
                head = newNode;
                temp = newNode;
            }
            else {
                temp.next = newNode;
                temp = temp.next;
            }
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        return head;
    }

}


public class Lecture_92 {
    // Helper: build linked list from array
    static AddListNode buildList(int[] arr) {
        AddListNode head = null, temp = null;

        for (int val : arr) {
            AddListNode node = new AddListNode(val);
            if (head == null) {
                head = node;
                temp = node;
            } else {
                temp.next = node;
                temp = temp.next;   //temp = node;
            }
        }
        return head;
    }

    // Helper: print linked list
    static void printList(AddListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 1, 4};
        int[] brr = {9, 5, 6, 8};

        AddListNode l1 = buildList(arr);
        AddListNode l2 = buildList(brr);

        AddSolution aSol = new AddSolution();
        AddListNode result = aSol.addTwoNumbers(l1, l2);

        printList(result);
    }

}