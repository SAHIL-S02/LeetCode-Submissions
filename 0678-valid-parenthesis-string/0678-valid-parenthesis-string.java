public class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // treat '*' as ')'
                maxOpen++; // treat '*' as '('
            }

            // If maxOpen is negative, we have more ')' than '(' + '*'
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative (we cannot have a negative count of open brackets)
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // String is valid if minOpen can be 0 at the end
        return minOpen == 0;
    }
}