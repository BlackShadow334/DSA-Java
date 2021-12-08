package data_structure;

public class Main {
    public static void main(String[] args){
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(0);
        stack.push(1);
        stack.push(2);
//        stack.push(3);
        stack.pop();
        stack.pop();

        System.out.println(stack);
    }
}
