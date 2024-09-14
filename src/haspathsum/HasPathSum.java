/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package haspathsum;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaan
 */
/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:

Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.

 

Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -1000 <= Node.val <= 1000
    -1000 <= targetSum <= 1000


*/
public class HasPathSum {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode (5) ;
        TreeNode node2 = new TreeNode (4) ;
        TreeNode node3 = new TreeNode (8) ;
        TreeNode node4 = new TreeNode (11) ;
        TreeNode node5 = new TreeNode (13) ;
        TreeNode node6 = new TreeNode (4) ;
        TreeNode node7 = new TreeNode (7) ;
        TreeNode node8 = new TreeNode (2) ;
        TreeNode node9 = new TreeNode (1) ;
        node1.left = node2 ;
        node1.right = node3 ;
        node2.left = node4 ;
        node4.left = node7 ;
        node4.right = node8 ;
        node3.left = node5 ;
        node3.right = node6 ;
        node6.right = node9 ;
        System.out.println(hasPathSum(node1, 22));
        
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        List<Integer> sums = new ArrayList();
        addRootToLeafSums(root, targetSum, sums, 0);
        return sums.contains(targetSum);
    }

    private static void addRootToLeafSums(TreeNode node, int targetSum, List<Integer> sums, int sum) {
        sum += node.val;
        if (node.left == null && node.right == null) {
            sums.add(sum);
            return;
        }
        if (node.left != null) {
            addRootToLeafSums(node.left, targetSum, sums, sum);
        }
        if (node.right != null) {
            addRootToLeafSums(node.right, targetSum, sums, sum);
        }
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
