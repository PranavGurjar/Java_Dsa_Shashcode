import java.util.LinkedList;

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

class ListNode<T>{
    T data;

    ListNode next;

    ListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class Lecture_89 {
    public static void main(String[] args) {
        ListNode head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);

        Solution sol = new Solution();
        ListNode middleNode = sol.middleNode(head);
        System.out.println("Middle Node : "+middleNode.data);
    }
}
