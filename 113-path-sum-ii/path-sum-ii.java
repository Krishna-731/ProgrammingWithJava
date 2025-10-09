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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode root, int targetSum, int currSum, List<Integer> currPath, List<List<Integer>> result) {
        if (root == null) {
            return;
        }   

        currSum += root.val;
        currPath.add(root.val);

        if (root.left == null && root.right == null && currSum == targetSum) {
            result.add(new ArrayList<>(currPath));
        }

        dfs(root.left, targetSum, currSum, currPath, result);
        dfs(root.right, targetSum, currSum, currPath, result);

        currPath.remove(currPath.size()-1);
    }
}