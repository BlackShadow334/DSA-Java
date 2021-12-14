package non_linear_data_structure;

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

    public boolean isEmpty(){
        return root == null;
    }
}
