package non_linear_data_structure;

public class AVLTree {
    private static class AVLNode{
        int value;
        AVLNode left_child;
        AVLNode right_child;
        int height;
        AVLNode(int value, int height){
            this.value = value;
            this.height = height;
        }
        @Override
        public String toString(){
            return "value=" + value;
        }
    }

    private AVLNode root;

    public void insert(int value){
        root = insert(value,  root);
    }

    private AVLNode insert(int value, AVLNode node){
        if (node == null){
            return new AVLNode(value, 0);
        }
        if (value < node.value)
            node.left_child = insert(value, node.left_child);
        else
            node.right_child = insert(value, node.right_child);

        setHeight(node);
        return balanced(node);
    }



    private AVLNode balanced(AVLNode node){
        // Self Balancing Algorithm
        if (isLeftHeavy(node)){
            if (balanceFactor(node.left_child) < 0){
                // System.out.println("rotate left " + node.left_child.value);
                node.left_child = rotateLeft(node.left_child);
            }
            //System.out.println("rotate right " + node.value);
            node = rotateRight(node);
        }
        else if (isRightHeavy(node)){
            if (balanceFactor(node.right_child) > 0) {
                // System.out.println("rotate right " + node.right_child.value);
                node.right_child = rotateRight(node.right_child);
            }
            // System.out.println("rotate left " + node.value);
            node = rotateLeft(node);
        }
        return node;
    }

    private AVLNode rotateLeft(AVLNode node){
        AVLNode new_root_node = node.right_child;
        node.right_child = new_root_node.left_child;
        new_root_node.left_child = node;

        setHeight(node);
        setHeight(new_root_node);
        return new_root_node;
    }

    private AVLNode rotateRight(AVLNode node){
        AVLNode new_root_node = node.left_child;
        node.left_child = new_root_node.right_child;
        new_root_node.right_child = node;

        setHeight(node);
        setHeight(new_root_node);
        return new_root_node;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(height(node.left_child), height(node.right_child)) + 1;
    }

    private int height(AVLNode node){
        return (node == null)? -1 : node.height;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }
    private int balanceFactor(AVLNode node){
        // > 1 ==> left heavy
        // < -1 ==> right heavy
        if (node == null) return 0; // balance factor of empty tree is 0;
        return height(node.left_child) - height(node.right_child);
    }
}
