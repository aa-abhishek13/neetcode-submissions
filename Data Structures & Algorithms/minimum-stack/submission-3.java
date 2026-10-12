public class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }

        st.push(val);
    }

    public void pop() {
        int ele1 = st.pop();
        int ele2 = min.isEmpty() ? Integer.MIN_VALUE : min.peek();

        if (ele1 == ele2) {
            min.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
