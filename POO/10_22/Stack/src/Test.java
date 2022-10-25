import structures.Stack;

public class Test {
    public static void main(String[] args) {
        Stack s = new Stack(50);

        if (!s.pop())
            System.err.println("Nothing to pop");
        System.err.println("Top with empty stack: " + s.top());

        for (int i = 0; i < 10; i++)
            s.push(i);

        System.out.print("Stack 1: ");
        while (!s.isEmpty()){
            System.out.print(s.top() + " ");
            s.pop();
        }

        Stack v = new Stack();

        for (int i = 0; i < 15; i++)
            v.push(i);

        System.out.print("\nStack 2: ");
        while (!v.isEmpty()){
            System.out.print(v.top() + " ");
            v.pop();
        }
    }
}