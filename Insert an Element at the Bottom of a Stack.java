import java.util.Stack;

class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        int[] arr = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            arr[i] = st.peek();
            st.pop();
            i++;
        }
        st.push(x);
        for (int j = i - 1; j >= 0; j--) {
            st.push(arr[j]);
        }
        return st;
    }
}