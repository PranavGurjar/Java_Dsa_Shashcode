/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//public class Solution {
//    public boolean hasCycle(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast){
//                return true;
//            }
//        }
//        return false;
//    }
//}


class FloydListNode{
    int val;
    FloydListNode next;

    public FloydListNode(int val) {
        this.val = val;
        this.next = null;
    }
}


class FloydSolution {
    public boolean hasCycle(FloydListNode head) {
        FloydListNode slow = head;
        FloydListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
//        FloydListNode startNode = firstNodeOfCycle(head);
//        if (startNode != null)
//        System.out.println("Found starting node : "+startNode.val);
        return false;
    }

    public FloydListNode firstNodeOfCycle(FloydListNode head){
        FloydListNode slow = head;
        FloydListNode fast = head;
        boolean found = false;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                found = true;
                break;
            }
        }
        if (!found){
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}




//Tortoise and Hare algorithm
//Detect Cycle in linked list | Floyds' cycle detection |
public class Lecture_95 {
    public static void main(String[] args) {
        FloydListNode n1 = new FloydListNode(1);
        FloydListNode n2 = new FloydListNode(2);
        FloydListNode n3 = new FloydListNode(3);
        FloydListNode n4 = new FloydListNode(4);
        FloydListNode n5 = new FloydListNode(5);
        FloydListNode n6 = new FloydListNode(6);
        FloydListNode n7 = new FloydListNode(7);
        FloydListNode n8 = new FloydListNode(8);
        FloydListNode n9 = new FloydListNode(9);

        // Link nodes (1 → 2 → 3 → ... → 9)
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        // Create cycle (9 → 3)
        n9.next = n3;

        FloydSolution fSol = new FloydSolution();
        System.out.println("Has Cycle: " + fSol.hasCycle(n1));

        FloydListNode startNode = fSol.firstNodeOfCycle(n1);
        if (startNode != null) {
            System.out.println("Cycle starts at node: " + startNode.val);
        } else {
            System.out.println("No cycle found");
        }

    }
}
