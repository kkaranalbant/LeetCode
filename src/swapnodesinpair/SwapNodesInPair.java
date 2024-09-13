/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swapnodesinpair;

/**
 *
 * @author kaan
 */

/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:

Input: head = [1,2,3,4]

Output: [2,1,4,3]

Explanation:

Example 2:

Input: head = []

Output: []

Example 3:

Input: head = [1]

Output: [1]

Example 4:

Input: head = [1,2,3]

Output: [2,1,3]

 

Constraints:

    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100


 */
public class SwapNodesInPair {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = swapPairs(node1);
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val + "\n");
            current = current.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        int swapNumber = size(head) / 2;
        ListNode result = head;
        if (swapNumber >= 1) {
            result = result.next;
        }
        ListNode currentNode = head;
        ListNode beforeNode = null;
        for (int i = 0; i < swapNumber; i++) {
            swap(beforeNode, currentNode, currentNode.next);
            beforeNode = currentNode;
            currentNode = currentNode.next;
        }
        return result;
    }

    private static void swap(ListNode beforeNode, ListNode currentNode, ListNode nextNode) {
        currentNode.next = nextNode.next;
        nextNode.next = currentNode;
        if (beforeNode != null) {
            beforeNode.next = nextNode;
        }
    }

    private static int size(ListNode head) {
        ListNode currentNode = head;
        int result = 0;
        while (currentNode != null) {
            result++;
            currentNode = currentNode.next;
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
