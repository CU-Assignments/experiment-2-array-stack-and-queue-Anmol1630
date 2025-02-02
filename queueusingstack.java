package exp2;
import java.util.Stack;
import java.util.Scanner;

class MyQueue {
    private Stack<Integer> stack1; 
    private Stack<Integer> stack2; 

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void push(int x) {
        stack1.push(x);
    }
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

public class QueueUsingStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue myQueue = new MyQueue();

        while (true) {
            System.out.println("\nChoose an operation: push <x>, pop, peek, empty, exit");
            String command = scanner.next();

            if (command.equals("push")) {
                int x = scanner.nextInt();
                myQueue.push(x);
                System.out.println("Pushed: " + x);
            } else if (command.equals("pop")) {
                System.out.println("Popped: " + myQueue.pop());
            } else if (command.equals("peek")) {
                System.out.println("Front: " + myQueue.peek());
            } else if (command.equals("empty")) {
                System.out.println("Queue is empty: " + myQueue.empty());
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
        scanner.close();
    }
}
