package extra_questions;

import java.util.Stack;

class CheckBalancedExpression {
    public static boolean isExpressionBalanced(String expression){
        Stack<Character> stack = new Stack<>();

        for (char ch: expression.toCharArray()){
            if (isLeftBracket(ch)){
                stack.push(ch);
                continue;
            }
            if (isRightBracket(ch)){
                if (stack.empty()) return false;
                if (!doesBracketsMatch(stack.pop(), ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isLeftBracket(char ch){
        return ch == '(' || ch == '<' || ch == '{' || ch == '[';
    }

    private static boolean isRightBracket(char ch){
        return ch == ')' || ch == '>' || ch == '}' || ch == ']';
    }

    private static boolean doesBracketsMatch(char left, char right){
        return  (right == ')' && left == '(') || (right == '>' && left == '<') ||
                (right == '}' && left == '{') || (right == ']' && left == '[');
    }

    public static void main(String[] args){
        String expression = ")(([1] + <2>))[a]";
//        String expression = "()";
        System.out.println(isExpressionBalanced(expression));
    }
}
