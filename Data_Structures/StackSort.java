import java.util.Stack;

public class StackSort {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(8);
        stack.push(5);
        stack.push(1);
        stack.push(7);
        stack.push(3);

        System.out.println(stack);
        System.out.println(sortStack(stack));

    }

    public static Stack<Integer> sortStack(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<Integer>();
        int count = stack.size();
        for (int i = 0; i < stack.size(); i++) {
            int largest = stack.peek();

            if (!(stack.isEmpty())) {
                for (int j = 0; j > count; j--) {
                    if (stack.peek() > largest) {
                        largest = stack.peek();
                    }
                    tempStack.push(stack.peek());
                    stack.pop();
                }
                stack.push(largest);
            } else {
                for (int j = tempStack.size(); j > i; j--) {
                    if (tempStack.peek() > largest) {
                        largest = tempStack.peek();
                    }
                    stack.push(tempStack.peek());
                    tempStack.pop();
                }
            }

            // if (i % 2 != 0) {
            // for (int j = tempStack.size(); j > i; j--) {
            // if (tempStack.peek() > largest) {
            // largest = tempStack.peek();
            // }
            // stack.push(tempStack.peek());
            // tempStack.pop();
            // }
            // } else {
            // for (int j = stack.size(); j > i; j--) {
            // if (stack.peek() > largest) {
            // largest = stack.peek();
            // }
            // tempStack.push(stack.peek());
            // stack.pop();
            // }
            // stack.push(largest);
            // }

        }

        return stack;
    }
}
