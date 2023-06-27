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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if (p == null && q == null) {
        //     return true;
        // }
        // if (p == null || q == null || p.val != q.val) {
        //     return false;
        // }

        // For some reason this uses less memory...
        if (p == null) {
            if (q == null) {
                return true;
            }
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}