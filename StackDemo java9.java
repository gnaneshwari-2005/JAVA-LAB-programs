package BM23AI069;

interface StackOperations {
    void push(int element);
    int pop();
    boolean isEmpty();
    boolean isFull();
    int peek();
}

class FixedLengthStack implements StackOperations {
    private int[] stack;
    private int top;
    private final int maxSize;

    public FixedLengthStack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    @Override
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + element);
        } else {
            stack[++top] = element;
            System.out.println("Pushed " + element + " to FixedLengthStack.");
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == maxSize - 1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack[top];
        }
    }
}

class DynamicLengthStack implements StackOperations {
    private int[] stack;
    private int top;
    private int size;

    public DynamicLengthStack() {
        stack = new int[10];
        top = -1;
        size = 10;
    }

    @Override
    public void push(int element) {
        if (isFull()) {
            resize();
        }
        stack[++top] = element;
        System.out.println("Pushed " + element + " to DynamicLengthStack.");
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == size - 1;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack[top];
        }
    }

    private void resize() {
        size *= 2;
        int[] newStack = new int[size];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
        System.out.println("Stack resized. New size: " + size);
    }
}

public class StackDemo {
    public static void main(String[] args) {
        StackOperations fixedStack = new FixedLengthStack(3);
        StackOperations dynamicStack = new DynamicLengthStack();

        fixedStack.push(10);
        fixedStack.push(20);
        fixedStack.push(30);
        fixedStack.push(40);

        System.out.println("Peek of FixedLengthStack: " + fixedStack.peek());

        System.out.println("Popped from FixedLengthStack: " + fixedStack.pop());
        System.out.println("Popped from FixedLengthStack: " + fixedStack.pop());

        dynamicStack.push(100);
        dynamicStack.push(200);
        dynamicStack.push(300);
        dynamicStack.push(400);
        dynamicStack.push(500);

        System.out.println("Peek of DynamicLengthStack: " + dynamicStack.peek());

        System.out.println("Popped from DynamicLengthStack: " + dynamicStack.pop());
        System.out.println("Popped from DynamicLengthStack: " + dynamicStack.pop());
    }
}
