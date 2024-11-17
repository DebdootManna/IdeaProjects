class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class KthSmallestElementInBST {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementInBST finder = new KthSmallestElementInBST();
        int k = 2;
        System.out.println("The " + k + "-th smallest element is " + finder.kthSmallest(root, k));
    }
}