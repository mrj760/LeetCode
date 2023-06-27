class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

}

class TreeNode {
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

class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lh = root.left == null ? 0 : maxDepth(root.left);
        int rh = root.right == null ? 0 : maxDepth(root.right);
        switch (lh - rh) {
            case (0):
            case (-1):
            case (1):
                return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return left > right ? left : right;
    }
}