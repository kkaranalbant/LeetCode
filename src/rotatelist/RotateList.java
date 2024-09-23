/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rotatelist;

/**
 *
 * @author kaan
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = rotateRight(node1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            ListNode newHead = rotate(head);
            head = newHead;
        }
        return head;
    }

    private static ListNode findBeforeOfTail(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.next.next == null) {
                break;
            }
            current = current.next;
        }
        return current;
    }

    private static ListNode findTail(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private static ListNode rotate(ListNode head) {
        ListNode tail = findTail(head);
        ListNode beforeTail = findBeforeOfTail(head);
        tail.next = head;
        beforeTail.next = null;
        return tail;
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
