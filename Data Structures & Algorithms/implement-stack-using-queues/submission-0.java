class MyStack {
    private Queue<Integer> main, q2;

    public MyStack() {
        this.main = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int x) {
        main.offer(x);
    }

    public int pop() {
        while (main.size() != 1) q2.offer(main.poll());
        int val = main.poll();
        while (!q2.isEmpty()) main.offer(q2.poll());
        return val;
    }

    public int top() {
        while (main.size() != 1) q2.offer(main.poll());
        int val = main.poll();
        q2.offer(val);
        while (!q2.isEmpty()) main.offer(q2.poll());
        return val;
    }

    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */