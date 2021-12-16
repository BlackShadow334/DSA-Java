package non_linear_data_structure;

public class Main {
    public static void main(String[] args){
        AVLTree avl_tree = new AVLTree();

        // left heavy --> right rotation (50)
//        avl_tree.insert(50);
//        avl_tree.insert(30);
//        avl_tree.insert(20);

        // left heavy --> left rotation (30) + right rotation (50)
//        avl_tree.insert(50);
//        avl_tree.insert(30);
//        avl_tree.insert(40);


        // right heavy --> left rotation (10)
//        avl_tree.insert(10);
//        avl_tree.insert(20);
//        avl_tree.insert(30);

        // right heavy --> right rotation (30) + left rotation (10)
        avl_tree.insert(10);
        avl_tree.insert(30);
        avl_tree.insert(20);


        System.out.println();
    }
}
