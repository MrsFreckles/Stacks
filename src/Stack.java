import java.util.ArrayList;

public class Stack {

    private final ArrayList<Object> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(Object o) {
        stack.add(o);
    }

    public Object pop() {
        return stack.remove(stack.size() - 1);
    }

    public Object top() {
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
