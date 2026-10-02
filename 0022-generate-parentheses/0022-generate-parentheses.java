import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base Case: If the current string reaches maximum length (2 * n)
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Decision 1: Add an opening bracket if we haven't reached 'n'
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Decision 2: Add a closing bracket if it won't break validity
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
        // Output: [((())), (()()), (())(), ()(()), ()()()]
    }
}