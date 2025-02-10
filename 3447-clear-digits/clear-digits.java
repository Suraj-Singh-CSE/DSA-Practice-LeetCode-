import java.util.Stack;

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Remove the closest non-digit character to the left
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    stack.pop();
                    break; // Remove only one non-digit character
                }
            } else {
                stack.push(ch); // Push non-digit character to stack
            }
        }

        // Construct the final result string from stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.clearDigits("abc"));   // Output: "abc"
        System.out.println(sol.clearDigits("cb34"));  // Output: ""
        System.out.println(sol.clearDigits("a1b2c3"));// Output: ""
        System.out.println(sol.clearDigits("d3c2b1a"));// Output: ""
    }
}
