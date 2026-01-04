
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
//
//class Solution {
//    public boolean isPalindrome(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode prev = null;
//        ListNode newListHead = null;
//
//        while (fast != null && fast.next != null){
//            prev = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//            if (newListHead == null){
//                newListHead = new ListNode(prev.val);
//            }
//            else {
//                ListNode node = new ListNode(prev.val);
//                node.next = newListHead;
//                newListHead = node;
//            }
//        }
//        //if list is odd length, skip the middle
//        if (fast != null){
//            slow = slow.next;
//        }
//        while (slow != null && newListHead != null){
//            if (slow.val != newListHead.val){
//                return false;
//            }
//            slow = slow.next;
//            newListHead = newListHead.next;
//        }
//        return true;
//    }
//}

//class Solution {
//    public ListNode reverseList(ListNode head){
//        ListNode prev = null;
//        ListNode current = head;
//
//        while (current != null){
//            ListNode nextNode = current.next;
//            current.next = prev;
//            prev = current;
//            current = nextNode;
//        }
//        return prev;
//    }
//
//    public ListNode findMiddle(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next==null){
//            return true;
//        }
//        ListNode middle = findMiddle(head);
//        ListNode tail = reverseList(middle);
//        ListNode temp = head;
//
//        while (tail != null){
//            if (tail.val != temp.val){
//                return false;
//            }
//            tail = tail.next;
//            temp = temp.next;
//        }
//        return true;
//    }
//}

class PalListNode{
    int val;
    PalListNode next;

    public PalListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

//Concept 2
//O(N)
class PalSolution1 {
    public boolean isPalindrome(PalListNode head) {
        PalListNode slow = head;
        PalListNode fast = head;
        PalListNode prev = null;
        PalListNode newListHead = null;

        //creating while finding the middle node O(N/2)
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (newListHead == null){
                newListHead = new PalListNode(prev.val);
            }
            else {
                PalListNode node = new PalListNode(prev.val);
                node.next = newListHead;
                newListHead = node;
            }
        }
        //if list is odd length, skip the middle
        if (fast != null){
            slow = slow.next;
        }
        //O(N/2)
        while (slow != null && newListHead != null){
            if (slow.val != newListHead.val){
                return false;
            }
            slow = slow.next;
            newListHead = newListHead.next;
        }
        return true;
    }
}

//Concept 3
//O(3(N/2))
class PalSolution2 {
    public PalListNode reverseList(PalListNode head){
        PalListNode prev = null;
        PalListNode current = head;

        while (current != null){
            PalListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public PalListNode findMiddle(PalListNode head) {
        PalListNode slow = head;
        PalListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public boolean isPalindrome(PalListNode head) {
        if (head == null || head.next==null){
            return true;
        }
        PalListNode middle = findMiddle(head);
        PalListNode tail = reverseList(middle);
        PalListNode temp = head;

        while (tail != null){
            if (tail.val != temp.val){
                return false;
            }
            tail = tail.next;
            temp = temp.next;
        }
        return true;
    }
}




public class Lecture_94 {

    public static PalListNode buildNode(int []arr){
        PalListNode head = null;
        PalListNode temp = null;
        for (int val : arr){
            PalListNode node = new PalListNode(val);
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

    public static void printList(PalListNode head){
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
        int []arr = {1, 2, 2, 1};
        int []brr = {1, 2, 1, 2, 1};

        PalListNode list1 = buildNode(arr);
        printList(list1);
        PalSolution1 p1 = new PalSolution1();
        boolean resultP1 = p1.isPalindrome(list1);
        System.out.println("Method 1 : is palindrome : "+resultP1);


        PalListNode list2 = buildNode(brr);
        printList(list2);
        PalSolution2 p2 = new PalSolution2();
        boolean resultP2 = p2.isPalindrome(list2);
        System.out.println("Method 2 : is palindrome : "+resultP2);
        printList(list2);

    }
}
