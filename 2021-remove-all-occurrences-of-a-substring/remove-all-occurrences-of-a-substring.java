class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOccurrences("daabcbaabcbc", "abc")); // Output: "dab"
        System.out.println(solution.removeOccurrences("axxxxyyyyb", "xy"));   // Output: "ab"
    }
}
