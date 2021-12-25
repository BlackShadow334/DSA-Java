package non_linear_data_structure;

import java.util.ArrayList;

public class Tree {
    private static class Node {
        private int value;
        private Node left_child;
        private Node right_child;
        public Node(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node= " + value;
        }
    }
    private Node root;

    public Tree(){
    }

    public void insert(int value){
        Node node = new Node(value);
        if (isEmpty()){
            root = node;
            return;
        }
        Node current = root;
        while (true){
            if (current.value > value){
                if (current.left_child == null){
                    current.left_child = node;
                    break;
                }
                current = current.left_child;
            }
            else if (current.value < value){
                if (current.right_child == null){
                    current.right_child = node;
                    break;
                }
                current = current.right_child;
            }
            else break;
        }
    }

    public boolean find(int value){
        if (isEmpty()) throw new IllegalStateException();
        Node current = root;
        while (current!= null)
            if (current.value == value) return true;
            else if (current.value > value)
                current = current.left_child;
            else
                current = current.right_child;
        return false;
    }


    // Pre-order traversal
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if (root == null) return;

        System.out.println(root.value);
        traversePreOrder(root.left_child);
        traversePreOrder(root.right_child);
    }

    // In-order traversal
    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if (root == null) return;

        traverseInOrder(root.left_child);
        System.out.println(root.value);
        traverseInOrder(root.right_child);
    }

    // Post-Order traversal
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root){
        if (root == null) return;

        traversePostOrder(root.left_child);
        traversePostOrder(root.right_child);
        System.out.println(root.value);
    }

    // Finding Height of tree
    public int height(){
        if (isEmpty()) throw new IllegalStateException();
        return height(root);
    }

    private int height(Node root){
        if (root == null) return -1;
        if (isLeaf(root)) return 1;
        return 1 + Math.max(height(root.left_child), height(root.right_child));
    }

    // Finding minimum value
    public int minValue(){
        if (isEmpty()) throw new IllegalStateException();
        return minValue(root);
    }

    private int minValue(Node root){
        if (root == null) return Integer.MAX_VALUE;
        if (isLeaf(root)) return root.value;
        int min = Math.min(minValue(root.left_child), minValue(root.right_child));
        return Math.min(min, root.value);
    }

    // Checking if other tree is equal to this.
    public boolean equals(Tree other_tree){
        if (other_tree == null) return false;
        return equals(root, other_tree.root);
    }

    private boolean equals(Node root1, Node root2){
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;

        boolean is_root_equal = root1.value == root2.value;
        boolean is_left_equal = equals(root1.left_child, root2.left_child);
        boolean is_right_equal = equals(root1.right_child, root2.right_child);
        return is_root_equal && is_left_equal && is_right_equal;
    }

    // Checking if it is a Binary Search Tree.
    public boolean isBinarySearchTree(){
        // searching according to range.
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if (root == null) return true;

        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.left_child , min , root.value)
                && isBinarySearchTree(root.right_child, root.value, max);
    }

    // Finding Node at Kth Distance
    public ArrayList<Integer> getNodesAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if (root == null) return;
        if (distance == 0){
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.left_child, distance -1, list);
        getNodesAtDistance(root.right_child, distance -1, list);
    }

    // Level-Order Traversal
    public void traverseLevelOrder(){
        for (int i = 0; i < height(); i++)
            for (int value: getNodesAtDistance(i))
                System.out.println(value);
    }

    public boolean isEmpty(){
        return root == null;
    }

    private boolean isLeaf(Node root){
        return root.left_child == null && root.right_child == null;
    }
}
