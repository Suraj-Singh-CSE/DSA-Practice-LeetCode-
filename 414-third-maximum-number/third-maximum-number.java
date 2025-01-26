import java.util.HashSet;

class Solution {
    public int thirdMax(int[] nums) {
        // Initialize three variables for the top 3 distinct maximum numbers
        Long first = null, second = null, third = null;

        for (int num : nums) {
            long n = num; // Convert to long to handle edge cases with null comparison
            
            // Skip duplicates
            if ((first != null && n == first) || 
                (second != null && n == second) || 
                (third != null && n == third)) {
                continue;
            }
            
            // Update the three maximum values
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }
        
        // Return the third maximum if it exists; otherwise, return the first maximum
        return (third == null) ? first.intValue() : third.intValue();
    }
}
