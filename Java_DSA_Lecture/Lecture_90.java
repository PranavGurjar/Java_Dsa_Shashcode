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

class DelListNode{
    int val;
    DelListNode next;

    public DelListNode(int val) {
        this.val = val;
        this.next = null;
    }
}


class DelSolution {
    public DelListNode deleteMiddle(DelListNode head) {
        if (head == null){
            return head;
        }

        DelListNode slow = head;
        DelListNode fast = head;
        DelListNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev == null){
            head = head.next;   //head = null;
        }
        else {
            prev.next = slow.next;
            slow.next = null;
        }
        return head;
    }
}


public class Lecture_90 {
    public static void printList(DelListNode head){
        while (head!=null){
            System.out.print(head.val);
            if (head!=null){
                System.out.print(", ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DelListNode d1 = new DelListNode(1);
        DelListNode d2 = new DelListNode(2);
        DelListNode d3 = new DelListNode(3);
        DelListNode d4 = new DelListNode(4);

        d1.next = d2;
        d2.next = d3;
        d3.next = d4;

        DelSolution dSol = new DelSolution();
        dSol.deleteMiddle(d1);

        printList(d1);
    }
}
