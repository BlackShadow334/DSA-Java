package non_linear_data_structure;


public class Main {
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("care");
        trie.insert("card");
        trie.insert("careful");
        trie.insert("apple");
        trie.insert("egg");

//        trie.remove("care");

        System.out.println(trie.contains("car"));
        for (String word: trie.autoComplete("ca")){
            System.out.println(word);
        }
    }
}
