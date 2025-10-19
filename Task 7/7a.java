class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) { 
        this.val = val; 
    }
}

class Solution {
    private int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longest;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int leftPath = 0, rightPath = 0;

        if (node.left != null && node.left.val == node.val) {
            leftPath = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightPath = right + 1;
        }

        longest = Math.max(longest, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(2);

        Solution sol = new Solution();
        int result = sol.longestUnivaluePath(root);
        System.out.println("Longest Univalue Path: " + result);
    }
}
