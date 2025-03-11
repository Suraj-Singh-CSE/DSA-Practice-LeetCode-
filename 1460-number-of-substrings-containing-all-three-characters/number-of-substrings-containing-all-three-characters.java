class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0, count = 0;
        int[] freq = new int[3]; // To store occurrences of 'a', 'b', and 'c'

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++; // Increment frequency of current char

            // If all characters are in the window, count substrings
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - right; // Count substrings starting from 'left'
                freq[s.charAt(left) - 'a']--; // Reduce frequency of leftmost char
                left++; // Move left pointer to shrink the window
            }
        }
        return count;
    }
}
