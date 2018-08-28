package com.algorithm.common;

public class CircleAndEntryPoint {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next= node3;
        node3.next=node4;
        node4.next=node2;
        System.out.println(hasCircle(node1));
    }

    private static boolean hasCircle(Node node) {
        if (node == null) {
            return false;
        }
        Node fast = node, slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node point = slow;
                int count = 1;
                slow = slow.next;
                while (point != slow) {
                    count++;
                    slow = slow.next;
                }
                System.out.println(count);
                return true;
            }
        }
        return false;
    }

    public Node findLoopPort(Node head){
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        System.out.print("NoLoop !");
        return null;
    }
}
class Node{
    Node next;
    int value;

    Node(int value) {
        this.value = value;
    }
}
