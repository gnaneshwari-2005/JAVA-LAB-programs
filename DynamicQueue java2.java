package BM23AI069;

public class DynamicQueue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public DynamicQueue(int initialCapacity) {
        this.capacity = initialCapacity;
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public DynamicQueue() {
        this(10);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T element) {
        if (size == capacity) {
            resize();
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T element = queue[front];
        queue[front] = null; // Help GC
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        T[] newQueue = (T[]) new Object[newCapacity];

        // Copy elements in correct order
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }

        queue = newQueue;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;

        System.out.println("Queue resized to capacity: " + capacity);
    }

    public static void main(String[] args) {
        DynamicQueue<Integer> intQueue = new DynamicQueue<>(3);

        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);

        intQueue.enqueue(40);

        System.out.println("Front element: " + intQueue.peek());

        while (!intQueue.isEmpty()) {
            System.out.println("Dequeued: " + intQueue.dequeue());
        }

        DynamicQueue<String> stringQueue = new DynamicQueue<>();
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        System.out.println("Dequeued from string queue: " + stringQueue.dequeue());
    }
}

