class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        
        // Step 1: Count frequency of each character
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Collect non-zero frequencies
        List<Integer> frequencies = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) {
                frequencies.add(f);
            }
        }

        // Step 3: Sort the frequencies
        Collections.sort(frequencies);

        int minDeletions = Integer.MAX_VALUE;

        // Step 4: Try each frequency as the lower bound 't'
        for (int i = 0; i < frequencies.size(); i++) {
            int t = frequencies.get(i);
            int deletions = 0;

            for (int f : frequencies) {
                if (f < t) {
                    deletions += f; // Delete all characters with frequency < t
                } else if (f > t + k) {
                    deletions += f - (t + k); // Delete the excess part
                }
                // else, within range [t, t + k], do nothing
            }

            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}
