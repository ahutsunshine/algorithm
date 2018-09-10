package com.algorithm.sword.offer.version1;

import com.algorithm.entity.ListNode;

/**
 * @author Kevin Yao
 */
public class Interview_37_FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node3;
        ListNode common = findFirstCommonNode(node1, node6);
        System.out.println(common.val);

    }

    private static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        int dif = length2 - length1;
        ListNode pNodeShort = pHead1;
        ListNode pNodeLong = pHead2;
        if (length1 > length2) {
            pNodeShort = pHead2;
            pNodeLong = pHead1;
            dif = length1 - length2;
        }
        while (dif > 0) {
            pNodeLong = pNodeLong.next;
            dif--;
        }
        while (pNodeShort != null && pNodeLong != null && pNodeShort != pNodeLong) {
            pNodeShort = pNodeShort.next;
            pNodeLong = pNodeLong.next;
        }
        return pNodeShort;

    }

    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
