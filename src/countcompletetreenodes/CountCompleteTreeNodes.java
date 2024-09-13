/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package countcompletetreenodes;

/**
 *
 * @author kaan
 */

/*
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:

Input: root = []
Output: 0

Example 3:

Input: root = [1]
Output: 1

 

Constraints:

    The number of nodes in the tree is in the range [0, 5 * 104].
    0 <= Node.val <= 5 * 104
    The tree is guaranteed to be complete.


 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        root.left = treeNode2;
        root.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        int result = 0;
        if (root == null) {
            System.out.println(result);
            return;
        }
        result = countCompleteTreeNodes(root, 1);
        System.out.println(result);
    }

    private static int countCompleteTreeNodes(TreeNode node, int count) {
        if (node.left != null) {
            count = countCompleteTreeNodes(node.left, count + 1);
        }
        if (node.right != null) {
            count = countCompleteTreeNodes(node.right, count + 1);
        }
        return count;
    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
