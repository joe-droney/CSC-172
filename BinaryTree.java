//Joe Droney

public class BinaryTree {
    private BinaryTree left;
    private int value;
    private BinaryTree right;

    public BinaryTree(BinaryTree left, int value, BinaryTree right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public static BinaryTree binarySearch(BinaryTree root, int target) {
        if (root == null) {
            return null;}
        else {
            if (target < root.getValue()){
                return binarySearch(root.getLeft(), target);
            } else if (target > root.getValue()){
                return binarySearch(root.getRight(), target);
            } else {
                return root;  // target == root.getValue()
            }
        }
    }

    public static BinaryTree insert(BinaryTree root, int value) {
        if (root == null){
            return new BinaryTree(null, value, null);
        } else {
            if (root.getValue() <= value){
                root.setRight(insert(root.getRight(), value));
            } else if (root.getValue() > value) {
                root.setLeft(insert(root.getLeft(), value));
            }
        }
        return root;
    }

    public static BinaryTree findMinNode(BinaryTree tree) {
        if (tree == null)
            return null;

        BinaryTree current = tree;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }   
    public static void printInOrder(BinaryTree tree) {
        if (tree != null) {
            printInOrder(tree.getLeft());
            System.out.print(tree.getValue() + " ");
            printInOrder(tree.getRight());
        }
    }
    public static void printPreOrder(BinaryTree tree) {
        if (tree != null) {
            System.out.print(tree.getValue() + " ");
            printPreOrder(tree.getLeft());
            printPreOrder(tree.getRight());
        }
    }

    public static void printPostOrder(BinaryTree tree) {
        if (tree != null) {
            printPostOrder(tree.getLeft());
            printPostOrder(tree.getRight());
            System.out.print(tree.getValue() + " ");
        }
    }
    public static BinaryTree removeNode(BinaryTree root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.getValue()) {
            root.setLeft(removeNode(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(removeNode(root.getRight(), value));
        } else {
            // Node to be deleted found

            // Case 1: Node has no children or one child
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            // Case 2: Node has two children
            // Find the minimum value in the right subtree
            BinaryTree minNodeRightSubtree = findMinNode(root.getRight());
            // Copy the value of the minimum node to the current node
            root.setValue(minNodeRightSubtree.getValue());
            // Remove the minimum node from the right subtree
            root.setRight(removeNode(root.getRight(), minNodeRightSubtree.getValue()));
        }

        return root;
    }

    public static void main(String[] args) {
        // Example usage:
        BinaryTree root = new BinaryTree(null, 25, null);
        root = insert(root, 15);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 35);
    
    
        System.out.println("Values in the binary search tree (in-order):");
        printInOrder(root);
    
        System.out.println("\nValues in the binary search tree (pre-order):");
        printPreOrder(root);
    
        System.out.println("\nValues in the binary search tree (post-order):");
        printPostOrder(root);
    
        BinaryTree minNode = findMinNode(root);
        if (minNode != null) {
            System.out.println("\nMinimal value in the binary search tree: " + minNode.getValue());
        } else {
            System.out.println("The binary search tree is empty.");
        }
    
        root = removeNode(root, 30);
        System.out.println("\nTree after removing node with value 30:");
        printInOrder(root); // Print the tree after removing the node with value 30
        root = removeNode(root, 10);
        System.out.println("\nTree after removing node with value 10:");
        printInOrder(root); // Print the tree after removing the node with value 10
    }
    
}
