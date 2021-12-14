package linear_data_structure;

public class Main {
    public static void main(String[] args){
        UserHashTable hash_table = new UserHashTable();

        hash_table.put(0, "Zero");
        hash_table.put(1, "One");
        hash_table.put(2, "Two");
        hash_table.put(9, "Nine");
        hash_table.put(10, "Ten");
        hash_table.put(11, "Eleven");

        hash_table.remove(9);
        hash_table.remove(8);
        hash_table.put(1, "one-one");

        System.out.println(hash_table.get(0));
        System.out.println(hash_table.get(1));
        System.out.println(hash_table.get(9));
        System.out.println(hash_table.get(10));
        System.out.println(hash_table.get(11));
        System.out.println(hash_table.get(6));

    }
}
