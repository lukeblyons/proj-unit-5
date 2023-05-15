import java.util.Stack;

public class BalancedBrackets {
    public static boolean hasBalancedParentheses(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean hasBalancedBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else if (isCloseBracket(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }

    private static boolean isCloseBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']' || ch == '>';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']') ||
                (open == '<' && close == '>');
    }

    public static void main(String[] args) {
        String parenthesesInput1 = "((()))";
        String parenthesesInput2 = "()()";
        String parenthesesInput3 = "((())";
        String parenthesesInput4 = "())(";

        System.out.println(hasBalancedParentheses(parenthesesInput1));
        System.out.println(hasBalancedParentheses(parenthesesInput2));
        System.out.println(hasBalancedParentheses(parenthesesInput3));
        System.out.println(hasBalancedParentheses(parenthesesInput4));

        String bracketsInput1 = "({})";
        String bracketsInput2 = "[<>()]";
        String bracketsInput3 = "({[}])";
        String bracketsInput4 = "({})]";

        System.out.println(hasBalancedBrackets(bracketsInput1));
        System.out.println(hasBalancedBrackets(bracketsInput2));
        System.out.println(hasBalancedBrackets(bracketsInput3));
        System.out.println(hasBalancedBrackets(bracketsInput4));
    }
}

//Both Step 1 and Step 2 solutions have a runtime complexity of O(n), where n is the length of the input string.
//The runtime complexity of each solution is O(n), where n is the length of the input string.
//The provided solutions are similar to yours, using a stack to check for balanced symbols. Step 2 handles multiple types of brackets, while your solution focuses on parentheses only. Improvements to your solution could include handling multiple types of brackets and providing more detailed comments.
//To implement a stack as a queue, use two stacks. For enqueue, push elements onto the first stack. For dequeue, transfer elements from the first stack to the second stack (if it's empty), then pop from the second stack to dequeue elements in FIFO order.
