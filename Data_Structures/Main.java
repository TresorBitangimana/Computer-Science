import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> a = new Stack<Integer>();

        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.push(6);

        // for (int i = 0; i < a.size(); i++) {
        // System.out.println(a.peek());
        // a.pop();
        // }

        System.out.println(a.peek());
        System.out.println(a.peek());
        System.out.println(a.isEmpty());
    }
}
