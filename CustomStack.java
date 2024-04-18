//Joe Droney

public class CustomStack<T> {
    private Node<T> top;
    private int size;

    // Constructor
    public CustomStack() {
        top = null;
        size = 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomStack<Bunny> stack = new CustomStack<>();

        stack.push(new Bunny("Fluffy", "White"));
        stack.push(new Bunny("Bugs", "Gray"));
        stack.push(new Bunny("Garry", "Brown"));

        System.out.println("Bunny Stack:");
        while (!stack.isEmpty()) {
            Bunny bunny = stack.pop();
            System.out.println(bunny);
        }
    }

    // Bunny class
    private static class Bunny {
        private String name;
        private String furColor;

        public Bunny(String name, String furColor) {
            this.name = name;
            this.furColor = furColor;
        }

        public String getName() {
            return name;
        }

        public String getFurColor() {
            return furColor;
        }

        @Override
        public String toString() {
            return "A " + furColor.toLowerCase() + " bunny named " + name + " jumped out of a burrow.";
        }
    }
}
