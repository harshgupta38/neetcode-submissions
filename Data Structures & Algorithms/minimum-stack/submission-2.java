class MinStack {
    private Stack<Integer> stack, min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val <= min.peek())
            min.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if (min.peek() == val)
            min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
