/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package removelinkedlistelements;

/**
 *
 * @author kaan
 */
/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:

Input: head = [], val = 1
Output: []

Example 3:

Input: head = [7,7,7,7], val = 7
Output: []

 

Constraints:

    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50


 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode head = removeElements(node1, 6);
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    private static ListNode removeElements(ListNode head, int val) {
        int size = size(head);
        if ((size == 1 && head.val == val) || size == 0) {
            return null;
        }
        if (head.val == val) {
            ListNode current = head;
            while (current != null) {
                if (current.val == val) {
                    current = current.next;
                } else {
                    break;
                }
            }
            head = current;
            size = size(head);
        }
        ListNode current = head;
        ListNode before = head;
        while (current != null) {
            if (current.val == val) {
                current = removeNode(before, current, val);
            }
            if (current != null) {
                before = current;
                current = current.next;
            }

        }
        return head;
    }

    private static ListNode removeNode(ListNode before, ListNode current, int val) {
        while (current != null) {
            if (current.val == val) {
                current = current.next;
            } else {
                break;
            }
        }
        before.next = current;
        return current;
    }

    private static int size(ListNode head) {
        ListNode current = head;
        int result = 0;
        while (current != null) {
            current = current.next;
            result++;
        }
        return result;
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
