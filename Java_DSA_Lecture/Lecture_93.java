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

class RevListNode{
    int val;
    RevListNode next;

    RevListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class RevNodeSolution1 {
    public RevListNode reverseList(RevListNode head) {
        //Iterative Approach
        RevListNode current = head;
        RevListNode prev = null;
        while (current != null){
            RevListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}

class RevNodeSolution2 {
    public RevListNode reverseList(RevListNode head) {
        //Recursive Approach
        if (head == null || head.next == null){
            return head;
        }
        //rc
        RevListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

    //Reverse the linked list | Iterative and Recursive
public class Lecture_93 {
    static RevListNode iterNode(int []arr){
        RevListNode head = null;
        RevListNode temp = null;

        for (int val : arr){
            RevListNode node = new RevListNode(val);
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

    static void printList(RevListNode head){
        while (head!=null){
            System.out.print(head.val);
            if (head.next != null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Iterative Approach
        int []arr = {4, 5, 7, 11, 6, 14};

        RevListNode revListNode1 = iterNode(arr);

        RevNodeSolution1 revNSol1 = new RevNodeSolution1();
        RevListNode revNode1 = revNSol1.reverseList(revListNode1);

        printList(revNode1);


        //Recursive Approach
        int []brr = {4, 5, 7, 11, 6, 14};
//        int []brr = {2, 7, 1, 8, 6};

        RevListNode revListNode2 = iterNode(brr);

        RevNodeSolution2 revNSol2 = new RevNodeSolution2();
        RevListNode revNode2 = revNSol2.reverseList(revListNode2);

        printList(revNode2);
    }
}
