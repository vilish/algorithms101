package exercise.algorithms;

public class BinarySearchTree {

    class Node {
        int key;
        String value;
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node min() {
            if (left == null) {
                return this;
            } else {
                return left.min();
            }
        }

        @Override
        public String toString() {
            return "[ " + key + ", " + value + " ]";
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key, String value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, int key, String value) {
        // create the new node to be inserted
        Node newNode = new Node(key, value);

        // if this node is null, attach the new node and return
        if (node == null) {
            node = newNode;
            return node;
        }

        // Else walk doen till we find a node in BST which is null
        if (key < node.key) {
            // Go Left child
            node.left = insert(node.left, key, value);
        } else {
            // Go Right child
            node.right = insert(node.right, key, value);
        }

        // return our fully constructed tree
        return node;
    }

    public String find(int key) {
        return find(root, key);

//        return null;
    }

    private String find(Node node, int key) {

        if (node == null) {
            return null;
        }

        if (key == node.key) {
            return node.value;
        } else if (key < node.key) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }

    }

    public void delete(int key) {
//        if (root == null) {
//            return;
//        }
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {

        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else { // we have found the node to be deleted.
            //Case 1. No child
            if (node.left == null && node.right == null) {
                node = null;
            }
            //Case2. One Child
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }
            //Case3. Two Child
            else {
                // find the min node
                Node minNode = node.right.min();
                //Duplicate it by copying its value here
                node.key = minNode.key;
                minNode.value = minNode.value;

                // Now go ahead nad delete the node we have duplicated
                node.right = delete(node.right, key);
            }
        }

        return node;
    }

    public void prettyPrint() {

    }

    public int findMinKey() {
        if (root == null) {
            throw new IllegalStateException("Empty Tree");
        }
//        // Go the leftMost node
//        Node node = root;
//        while (node.left != null) {
//            node = node.left;
//        }
        return root.min().key;
    }

    public void printPostOrderTraversal() {

    }
}
