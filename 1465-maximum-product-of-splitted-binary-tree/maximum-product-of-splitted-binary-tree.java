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
    long result = 0;
    int totalSum = 0;
    public int maxProduct(TreeNode root) {
        totalSum = calcTotalSum(root);
        int mod = 1_000_000_007;
        dfs(root);
        return (int)(result % mod);
    }

    int calcTotalSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + calcTotalSum(root.left) + calcTotalSum(root.right);
    }

    int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        int subTreeSum = root.val + leftSum + rightSum;

        result = Math.max(result, (long)(totalSum-subTreeSum)*subTreeSum);

        return subTreeSum;
    }
}