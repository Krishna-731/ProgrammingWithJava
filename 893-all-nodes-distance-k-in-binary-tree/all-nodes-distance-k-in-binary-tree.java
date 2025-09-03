/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> visit = new HashSet<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map(root);
        helper(target, k);
        return ans;
    }

    public void map(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
            map(root.left);
        }

        if (root.right != null) {
            map.put(root.right, root);
            map(root.right);
        }
    }


    public void helper(TreeNode target, int k) {
        if (target == null || visit.contains(target)) {
            return;
        }

        visit.add(target);
        if (k == 0) {
            ans.add(target.val);
            return;
        }

        helper(target.left, k-1);
        helper(target.right, k-1);
        helper(map.get(target), k-1);
    }
}