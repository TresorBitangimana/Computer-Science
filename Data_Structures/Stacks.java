import java.util.Queue;
import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {

        Stack<Integer> a = new Stack<Integer>();
        Stack<Integer> b = new Stack<Integer>();

        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(6);

        transfer(a, b);

        String opString = "532*+";
        evaluate(opString);
    }

    public static void transfer(Stack<Integer> S, Stack<Integer> T) {
        System.out.println(S);
        while (!S.isEmpty()) {
            T.push(S.peek());
            S.pop();
        }
        System.out.println(T);
    }

    public static void evaluate(String s) {
        // evaluete a postfix expression
        Stack<String> ops = new Stack<String>();
        while (!s.isEmpty()) {
            // if(Integer.parseInt(s[s.length()-1]).)
        }
    }

    public static void reverseQueue(Queue<Integer> S) {
        // reverses a queue
    }

    public static void sortStack() {

    }
}
