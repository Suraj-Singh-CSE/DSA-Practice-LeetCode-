class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] targetFrequency = new int[26];
        for (String word : words2) {
            int[] frequency = getFrequency(word);
            for (int i = 0; i < 26; i++) {
                targetFrequency[i] = Math.max(targetFrequency[i], frequency[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] wordFrequency = getFrequency(word);
            if (isUniversal(wordFrequency, targetFrequency)) {
                result.add(word);
            }
        }

        return result;
    }

    private int[] getFrequency(String word) {
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }
        return frequency;
    }

    private boolean isUniversal(int[] wordFrequency, int[] targetFrequency) {
        for (int i = 0; i < 26; i++) {
            if (wordFrequency[i] < targetFrequency[i]) {
                return false;
            }
        }
        return true;
    }
}
