/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static class Pair {
        int depth;
        TreeNode node;

        Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;
    }

    public Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        if (left.depth == right.depth) {
            return new Pair(left.depth+1, root);
        }

        if (left.depth > right.depth) {
            return new Pair(left.depth+1, left.node);
        }
        else {
            return new Pair(right.depth+1, right.node);
        }
    }
}