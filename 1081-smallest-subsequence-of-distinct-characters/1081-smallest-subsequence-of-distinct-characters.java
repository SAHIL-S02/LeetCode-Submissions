class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        // Store the last occurrence of each character
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] inStack = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Skip if already included
            if (inStack[ch - 'a']) {
                continue;
            }

            // Maintain lexicographically smallest order
            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch &&
                   last[stack.charAt(stack.length() - 1) - 'a'] > i) {

                inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(ch);
            inStack[ch - 'a'] = true;
        }

        return stack.toString();
    }
}