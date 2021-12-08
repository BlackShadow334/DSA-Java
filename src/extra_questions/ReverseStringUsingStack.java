package extra_questions;

import java.util.Stack;

class ReverseStringUsingStack {

    public static String reverseString(String str){
        if (str == null) throw new IllegalArgumentException();
        Stack<Character> stack1 = new Stack<>();

        for (char ch : str.toCharArray())
            stack1.push(ch);

        StringBuilder reverse_str = new StringBuilder();
        for(int i = 0; i < str.length(); i++)
            reverse_str.append(stack1.pop());

        return reverse_str.toString();
    }

    public static  void main(String[] args){
        String str = "abcd";
        System.out.println(reverseString(str));

    }
}
