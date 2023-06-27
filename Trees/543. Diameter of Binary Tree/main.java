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

    public int diameterOfBinaryTree(TreeNode root) {

        int thisDiameter = maxDepth(root.left) + maxDepth(root.right);
        int leftDiamter = root.left == null ? 0 : diameterOfBinaryTree(root.left);
        int rightDiamter = root.right == null ? 0 : diameterOfBinaryTree(root.right);

        return max(thisDiameter, max(leftDiamter, rightDiamter));
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