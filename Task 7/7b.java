import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);  // Base case: one way to have sum = 0
        return dfs(root, 0, targetSum, prefixSum);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSum) {
        if (node == null) return 0;

        currentSum += node.val;
        int count = prefixSum.getOrDefault(currentSum - targetSum, 0);

        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left, currentSum, targetSum, prefixSum);
        count += dfs(node.right, currentSum, targetSum, prefixSum);

        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);

        return count;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        Solution sol = new Solution();
        int result = sol.pathSum(root, 8);
        System.out.println("Number of paths with sum 8 = " + result);
    }
}
