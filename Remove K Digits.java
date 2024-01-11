import java.util.Stack;

class Solution {
    public String removeKdigits(String S, int K) {
        if (S.length() == K) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            while (K > 0 && !stack.isEmpty() && stack.peek() > S.charAt(i)) {
                stack.pop();
                K--;
            }
            stack.push(S.charAt(i));
            i++;
        }
        while (K > 0) {
            stack.pop();
            K--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}