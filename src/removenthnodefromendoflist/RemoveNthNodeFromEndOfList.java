/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package removenthnodefromendoflist;

/**
 *
 * @author kaan
 */
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode (1) ;
        ListNode node2 = new ListNode (2) ;
        ListNode node3 = new ListNode (3) ;
        ListNode node4 = new ListNode (4) ;
        ListNode node5 = new ListNode (5) ;
        node1.next = node2 ;
        node2.next = node3 ;
        node3.next = node4 ;
        node4.next = node5 ;
        removeNthFromEnd(node1,2);
        ListNode currentNode = node1 ;
        while(currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = size(head);
        if (size == n && n == 1) {
            return null;
        }
        if (size == n) {
            head = head.next;
            return head;
        }
        ListNode currentNode = head;
        for (int i = 0; i < size - n - 1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return head;
    }

    private static int size(ListNode head) {
        int result = 0;
        ListNode currentNode = head;
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
