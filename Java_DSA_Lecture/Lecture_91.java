/*class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    } */

//class Solution {
//    public Node pairwiseSwap(Node head) {
//        Node first = head;
//        Node prev = null;
//        while (first != null && first.next != null){
//            Node second = first.next;
//            first.next = second.next;
//            second.next = first;
//
//            //first swap //swapping head node
//            if (prev == null){
//                head = second;
//            }
//            else {
//                prev.next = second;
//            }
//            prev = first;
//            first = first.next;
//        }
//        return head;
//    }
//}

//if (head == null || head.next == null){
//            return head;
//        }



//class Solution {
//    public Node pairwiseSwap1(Node head) {
//        SwapNode first = head;
//        SwapNode prev = null;
//
//        while(first != null && first.next != null){
//            SwapNode second = first.next;
//
//            first.next = second.next;
//            second.next = first;
//
//            if (prev == null){
//                head = second;
//            }
//            else {
//                prev.next = second;
//            }
//            prev = first;
//            first = first.next;
//        }
//        return head;
//    }
//}

class SwapNode{
    int data;
    SwapNode next;

    SwapNode(int data) {
        this.data = data;
        this.next = null;
    }
}


class SwapSolution {
    public SwapNode pairwiseSwap(SwapNode head) {
        SwapNode first = head;
        SwapNode prev = null;
        while (first != null && first.next != null){
            SwapNode second = first.next;

            first.next = second.next;
            second.next = first;

            //first swap //swapping head node
            if (prev == null){
                head = second;
            }
            else {
                prev.next = second;
            }
            prev = first;
            first = first.next;
        }
        return head;
    }
}


public class Lecture_91 {
    public static void main(String[] args) {
        SwapSolution sol = new SwapSolution();
        SwapNode head = new SwapNode(1);
        head.next = new SwapNode(2);
        head.next.next = new SwapNode(3);
        head.next.next.next = new SwapNode(4);
        head.next.next.next.next = new SwapNode(5);
        head.next.next.next.next.next = new SwapNode(6);
        head.next.next.next.next.next.next = new SwapNode(7);
//        head.next.next.next.next.next.next.next = new SwapNode(8);

        SwapNode swapNode = sol.pairwiseSwap(head);
        while (swapNode != null){
            System.out.print(swapNode.data+" ");
            swapNode = swapNode.next;
        }
    }
}
