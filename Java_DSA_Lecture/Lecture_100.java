/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
//class Solution1 {
//    public static Node findIntersection(Node head1, Node head2) {
//        Node t1 = head1;
//        Node t2 = head2;
//        Node resHead = null;
//        Node resTail = null;
//
//        while (t1 != null && t2 != null){
//            if (t1.data == t2.data){
//                if (resHead == null){
//                    resHead = new Node(t1.data);
//                    resTail = resHead;
//                }
//                else {
//                    resTail.next = new Node(t1.data);
//                    resTail = resTail.next;
//                }
//                t1 = t1.next;
//                t2 = t2.next;
//            }
//            else if(t1.data < t2.data){
//                t1 = t1.next;
//            }
//            else {
//                t2 = t2.next;
//            }
//        }
//        return resHead;
//    }
//}


//class Solution2 {
//    public static Node findIntersection(Node head1, Node head2) {
//        Node t1 = head1;
//        Node t2 = head2;
//        Node resHead = new Node(-1);
//        Node resTail = resHead;
//
//        while (t1 != null && t2 != null){
//            if (t1.data == t2.data){
//                resTail.next = new Node(t1.data);
//                resTail = resTail.next;
//
//                t1 = t1.next;
//                t2 = t2.next;
//            }
//            else if(t1.data < t2.data){
//                t1 = t1.next;
//            }
//            else {
//                t2 = t2.next;
//            }
//        }
//        Node temp = resHead;
//        resHead = resHead.next;
//        temp.next = null;
//        return resHead;
//    }
//}

class InSecListNode{
    int data;
    InSecListNode next;

    InSecListNode(int data){
        this.data = data;
        this.next = null;
    }
}

class InSecSolution1 {
    public static InSecListNode findIntersection(InSecListNode head1, InSecListNode head2) {
        InSecListNode t1 = head1;
        InSecListNode t2 = head2;
        InSecListNode resHead = null;
        InSecListNode resTail = null;

        while (t1 != null && t2 != null){
            if (t1.data == t2.data){
                if (resHead == null){
                    resHead = new InSecListNode(t1.data);
                    resTail = resHead;
                }
                else {
                    resTail.next = new InSecListNode(t1.data);
                    resTail = resTail.next;
                }
                t1 = t1.next;
                t2 = t2.next;
            }
            else if(t1.data < t2.data){
                t1 = t1.next;
            }
            else {
                t2 = t2.next;
            }
        }
        return resHead;
    }
}

class InSecSolution2 {
    public static InSecListNode findIntersection(InSecListNode head1, InSecListNode head2) {
        InSecListNode t1 = head1;
        InSecListNode t2 = head2;
        InSecListNode resHead = new InSecListNode(-1);
        InSecListNode resTail = resHead;

        while (t1 != null && t2 != null){
            if (t1.data == t2.data){
                resTail.next = new InSecListNode(t1.data);
                resTail = resTail.next;

                t1 = t1.next;
                t2 = t2.next;
            }
            else if(t1.data < t2.data){
                t1 = t1.next;
            }
            else {
                t2 = t2.next;
            }
        }
        InSecListNode temp = resHead;
        resHead = resHead.next;
        temp.next = null;
        return resHead;
    }
}



public class Lecture_100 {
    public static InSecListNode buildNode(int []arr){
        InSecListNode head = null;
        InSecListNode temp = null;
        for (int val : arr){
            InSecListNode node = new InSecListNode(val);
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

    public static void printList(InSecListNode head){
        while (head != null){
            System.out.print(head.data);
            if (head.next != null){
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5, 6, 7};
        int []brr = {1, 3, 5, 7};

        System.out.println("Before Node1 : ");
        InSecListNode node1 = buildNode(arr);
        printList(node1);

        System.out.println("Before Node2 : ");
        InSecListNode node2 = buildNode(brr);
        printList(node2);


        System.out.println("After Node1 : ");
        InSecSolution1 sol1 = new InSecSolution1();
        InSecListNode res1 = sol1.findIntersection(node1, node2);
        printList(res1);

        System.out.println("After Node2 : ");
        InSecSolution2 sol2 = new InSecSolution2();
        InSecListNode res2 = sol1.findIntersection(node1, node2);
        printList(res2);
    }
}
