package non_linear_data_structure;

public class Main {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);
        tree.insert(6);


        System.out.println(tree.find(18));

    }
}
