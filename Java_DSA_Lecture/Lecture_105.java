/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

//class Solution {
//    public Pair<Node, Node> splitList(Node head) {
//        // Code here
//
//    }
//}


class CirListNode{
    int data;
    CirListNode next;

    public CirListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Pair<T, U> {
    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}


class CirSolution {
    public Pair<CirListNode, CirListNode> splitList(CirListNode head) {


        CirListNode head1 = null;
        CirListNode head2 = null;

        // Modify these head1 and head2 here, head is the starting point
        CirListNode slow = head;
        CirListNode fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        head1 = head;
        head2 = slow.next;
        if (fast.next == head) {
            fast.next = head2;
        } else {
            fast.next.next = head2;
        }
        slow.next = head1;

        return new Pair<>(head1, head2);
    }
}

public class Lecture_105 {
    public static CirListNode buildNode(int []arr){
        CirListNode head = null;
        CirListNode temp = null;
        for (int val : arr){
            CirListNode node = new CirListNode(val);
            if (head == null){
                head = node;
                temp = node;
            }
            else {
                temp.next = node;
                temp = temp.next;
            }
        }
        temp.next = head;   // 🔥 FIX: make circular
        return head;
    }

    public static void printList(CirListNode head){
        if (head == null) return;

        CirListNode tail = head;    //circular linked list manage head and tail
        //tail is empty then once head print
        do {
            System.out.print(tail.data);
            tail = tail.next;
            if (tail != head) {
                System.out.print("->");
            }
        } while (tail != head);
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("************** Odd Linked List **********************");
        int []odd = {1, 2, 3, 4, 5};

        System.out.println("Before List : ");
        CirListNode node1 = buildNode(odd);
        printList(node1);

        CirSolution sol1 = new CirSolution();
        Pair<CirListNode, CirListNode> listPair1 = sol1.splitList(node1);

        System.out.println("After List 1 : ");
        printList(listPair1.first);

        System.out.println("After List 2 : ");
        printList(listPair1.second);


        System.out.println("************** Even Linked List **********************");
        int []even = {1, 2, 3, 4, 5, 6};

        System.out.println("Before List : ");
        CirListNode node2 = buildNode(even);
        printList(node2);

        CirSolution sol2 = new CirSolution();
        Pair<CirListNode, CirListNode> listPair2 = sol2.splitList(node2);

        System.out.println("After List 1 : ");
        printList(listPair2.first);

        System.out.println("After List 2 : ");
        printList(listPair2.second);
    }
}
