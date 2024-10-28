public class LazyBinarySearchTree {

    private class TreeNode {
        int key;
        TreeNode left, right;
        boolean deleted;

        TreeNode(int key) {
            this.key = key;
            this.deleted = false;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    // constructor
    public LazyBinarySearchTree() {
        root = null;
    }

  
    public boolean insert(int key) {
        if (key < 1 || key > 99) {
            throw new IllegalArgumentException("IllegalArgumentException raised");
        }

        if (root == null) {
            root = new TreeNode(key);
            return true;
        }
        return insertRec(root, key);
    }

    private boolean insertRec(TreeNode node, int key) {  // recursively
        if (node.key == key) {
            if (node.deleted) {
                node.deleted = false; // undelete if duplicate of a deleted item
                return true;
            }
            return false; // do nothing if it is a duplicate
        }

        if (key < node.key) {
            if (node.left == null) {
                node.left = new TreeNode(key);
                return true;
            }
            return insertRec(node.left, key);  // insert left
            
        } else {
            if (node.right == null) {
                node.right = new TreeNode(key);
                return true;
            }
            return insertRec(node.right, key);  // insert right
        }
    }

 
    public boolean delete(int key) {
        if (key < 1 || key > 99) {
            throw new IllegalArgumentException("IllegalArgumentException raised");
        }

        TreeNode node = findNode(root, key);
        if (node != null && !node.deleted) {
            node.deleted = true;  // marked as logically deleted
            return true;
        }
        return false; // element is not in the tree or it has already been marked as logically deleted
    }

    private TreeNode findNode(TreeNode node, int key) {
        if (node == null) return null;
        if (node.key == key) return node;

        if (key < node.key) {
            return findNode(node.left, key);
        } else {
            return findNode(node.right, key);
        }
    }

    // find the minimum non-deleted element
    public int findMin() {
        TreeNode current = root;
        int min = -1;
        while (current != null) {
            if (!current.deleted) {
                min = current.key;
            }
            current = current.left;
        }
        return min; // returns -1 if none exists.
    }

    // find the maximum non-deleted element
    public int findMax() {
        TreeNode current = root;
        int max = -1;
        while (current != null) {
            if (!current.deleted) {
                max = current.key;
            }
            current = current.right;
        }
        return max;
    }

    // Check if the tree contains a given key
    public boolean contains(int key) {
        TreeNode node = findNode(root, key);
        return node != null && !node.deleted; // checks both if it exists and if it is non-deleted
    }

    // toString method for pre-order traversal
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTrav(root, sb);
        return sb.toString().trim();
    }

    private void preOrderTrav(TreeNode node, StringBuilder sb) {
        if (node != null) {
            if (node.deleted) {
                sb.append("*"); // adds an asterisk to items that are logically deleted.
            }
            sb.append(node.key).append(" ");
            preOrderTrav(node.left, sb);
            preOrderTrav(node.right, sb);
        }
    }

    public int height() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    public int size() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}