

class Solution {
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        
        // Step 1: Count frequency of each character
        for (char c : tiles.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Start backtracking
        return backtrack(countMap);
    }

    private int backtrack(HashMap<Character, Integer> countMap) {
        int sum = 0;

        for (char c : countMap.keySet()) {
            if (countMap.get(c) > 0) {
                // Use the character
                countMap.put(c, countMap.get(c) - 1);
                
                // Count the current sequence and continue recursion
                sum += 1 + backtrack(countMap);
                
                // Backtrack (restore the count)
                countMap.put(c, countMap.get(c) + 1);
            }
        }
        return sum;
    }
}
