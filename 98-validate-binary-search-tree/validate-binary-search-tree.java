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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        inOrderTraversal(root, inorder);

        for(int i = 0; i < inorder.size()-1; i++) {
            if (inorder.get(i).compareTo(inorder.get(i + 1)) >= 0) {
                return false;
            }
        }

        return true;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, inorder);
        inorder.add(root.val);
        inOrderTraversal(root.right, inorder);

    }
}