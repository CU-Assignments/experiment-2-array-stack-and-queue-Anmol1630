class MyQueue {
    Deque<Integer> s1 = new LinkedList<>();
    Deque<Integer> s2 = new LinkedList<>();
    public MyQueue() {
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (!s2.isEmpty()) {
            return s2.poll();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.poll());
        }
        return s2.poll();
    }
    
    public int peek() {
        if (!s2.isEmpty()) return s2.peekFirst();
        else return s1.peekLast();
    }
    
    public boolean empty() {
        if (s1.isEmpty() && s2.isEmpty())
            return true;
        return false;
    }
}

