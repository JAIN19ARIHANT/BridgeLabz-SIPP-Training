import java.util.Stack;

class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void enqueue(int x) {
        stackIn.push(x);
    }

    public int dequeue() {
        shiftStacks();
        if (!stackOut.isEmpty()) {
            return stackOut.pop();
        }
        throw new RuntimeException("Queue is empty!");
    }

    public int peek() {
        shiftStacks();
        if (!stackOut.isEmpty()) {
            return stackOut.peek();
        }
        throw new RuntimeException("Queue is empty!");
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}

public class QueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println("\nEnqueue 10, 20, 30");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("\nIs queue empty? " + queue.isEmpty());

        queue.enqueue(40);
        System.out.println("\nPeek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("\nIs queue empty? " + queue.isEmpty());
    }
}