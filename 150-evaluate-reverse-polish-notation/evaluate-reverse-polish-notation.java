class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String num : tokens) {
            if (num.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (num.equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            } else if (num.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (num.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(num));
            }
        }
        return stack.peek();
    }
}