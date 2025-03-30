

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        
        // Step 1: Record the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        // Step 2: Iterate through the string and partition
        int maxLast = 0, partitionStart = 0;
        for (int i = 0; i < s.length(); i++) {
            maxLast = Math.max(maxLast, lastIndex.get(s.charAt(i)));
            if (i == maxLast) { // If we reach the last occurrence of all chars in this partition
                result.add(i - partitionStart + 1);
                partitionStart = i + 1; // Move to the next partition
            }
        }
        
        return result;
    }
}
