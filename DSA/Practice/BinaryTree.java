// FILE: BinaryTree.java

// Define the TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

// Define the BinaryTree class with the maxDepth method
public class BinaryTree {
    public int maxDepth(TreeNode root) {
        // Base case: if the node is null, return 0
        if (root == null) {
            return 0;
        }

        // Recursively find the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is 1 plus the maximum of the depths of its subtrees
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Main method to test the maxDepth function
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of the BinaryTree class and find the maximum depth
        BinaryTree tree = new BinaryTree();
        int depth = tree.maxDepth(root);

        // Print the result
        System.out.println("Maximum depth of the binary tree is: " + depth);
    }
}