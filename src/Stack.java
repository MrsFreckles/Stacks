import java.util.ArrayList;

public class Stack<T> {

    private final ArrayList<T> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(T o) {
        stack.add(o);
    }

    public T pop() {
        return stack.remove(stack.size() - 1);
    }

    public T top() {
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}