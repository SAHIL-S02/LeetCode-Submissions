class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();

        stack.push(new StringBuilder());

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Start a new substring
                stack.push(new StringBuilder());

            } else if (ch == ')') {
                // Get current substring and reverse it
                StringBuilder current = stack.pop();
                current.reverse();

                // Append it to the previous level
                stack.peek().append(current);

            } else {
                // Normal character
                stack.peek().append(ch);
            }
        }

        return stack.pop().toString();
    }
}