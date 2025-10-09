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
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int start, int end) {

        List<TreeNode> ans = new LinkedList<TreeNode>();

        if (start > end) {
            ans.add(null);
            return ans;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> leftTree = buildTree(start, i-1);
            List<TreeNode> rightTree = buildTree(i+1, end);


            for(TreeNode left : leftTree) {
                for(TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    root.left = left;
                    ans.add(root);
                }
            }
        }

        return ans;
    }
}