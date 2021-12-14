package non_linear_data_structure;

public class Main {
    public static void main(String[] args){
        Tree tree0 = new Tree();
        tree0.insert(5);
        tree0.insert(2);
        tree0.insert(3);
        tree0.insert(8);
        tree0.insert(7);
        tree0.insert(6);
//        System.out.println(tree.height());
//        System.out.println(tree.minValue());

//        Tree tree1 = new Tree();
//        tree1.insert(5);
//        tree1.insert(2);
//        tree1.insert(3);
//        tree1.insert(8);
//        tree1.insert(7);
//        tree1.insert(4);
//        System.out.println(tree0.equals(tree1));

        tree0.traverseLevelOrder();
//        System.out.println(tree0.height());
        System.out.println(tree0.isBinarySearchTree());
    }
}
