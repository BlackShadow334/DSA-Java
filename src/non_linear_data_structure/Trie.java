package non_linear_data_structure;

import java.util.HashMap;
import java.util.LinkedList;

public class Trie {
    private static class Node {
        char value;
        HashMap<Character, Node> children = new HashMap<>();
        boolean is_end_of_word;
        public Node(char character){
            value = character;
            is_end_of_word = false;
        }

        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch){
            return children.get(ch);
        }

        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }

        public boolean hasAnyChild(){
            return !children.isEmpty();
        }

        public void removeChild(char ch){
            children.remove(ch);
        }

        @Override
        public String toString(){
            return "value=" + value;
        }
    }

    private final Node root = new Node(' ');

    public void insert(String word){
        Node current = root;
        for (char ch: word.toLowerCase().toCharArray()){
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.is_end_of_word = true;
    }

    public boolean contains (String word){
        if (word == null)
            return false;
        Node current = root;
        for (char ch: word.toLowerCase().toCharArray()){
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.is_end_of_word;
    }

    public void remove(String word){
        if (word == null || word.equals(""))
            return;
        word = word.toLowerCase();
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index){
        if (index < word.length() && root.hasChild(word.charAt(index))){
            Node child = root.getChild(word.charAt(index));
            remove(child, word, index+1);

            if (child.is_end_of_word && index == word.length() - 1)
                child.is_end_of_word = false;
            if (!child.hasAnyChild())
                root.removeChild(word.charAt(index));
        }
    }

    public LinkedList<String> autoComplete(String prefix){
        if (prefix == null || prefix.equals(""))
            return null;
        LinkedList<String> list = new LinkedList<>();
        prefix = prefix.toLowerCase();

        Node node = root;
        int i = 0;
        while (i < prefix.length() && node.hasChild(prefix.charAt(i))){
            node = node.getChild(prefix.charAt(i));
            i++;
        }
        autoComplete(node, prefix, list);
        return list;
    }

    private void autoComplete(Node root, String prefix, LinkedList<String> list){
        if (root == null)
            return;
        if (root.is_end_of_word)
            list.add(prefix);
        for (Node child : root.getChildren())
            autoComplete(child, prefix + child.value, list);
    }

}
