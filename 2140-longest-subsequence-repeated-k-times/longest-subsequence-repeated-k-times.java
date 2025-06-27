
class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        // Count frequency of characters
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        
        // Build usable characters list (must appear at least k times)
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (freq[i] >= k) sb.append((char)(i + 'a'));
        }
        String usable = sb.toString();

        // Store result
        String res = "";
        
        // Try lengths up to 7 (safe limit for constraints)
        Queue<String> q = new LinkedList<>();
        q.add("");
        while (!q.isEmpty()) {
            String curr = q.poll();
            for (char c : usable.toCharArray()) {
                String next = curr + c;
                if (isKSubsequence(s, next, k)) {
                    if (next.length() > res.length() || 
                       (next.length() == res.length() && next.compareTo(res) > 0)) {
                        res = next;
                    }
                    q.add(next);
                }
            }
        }
        return res;
    }
    
    // Helper to check if target * k is a subsequence of s
    private boolean isKSubsequence(String s, String target, int k) {
        int idx = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == target.charAt(idx)) {
                idx++;
                if (idx == target.length()) {
                    count++;
                    if (count == k) return true;
                    idx = 0;
                }
            }
        }
        return false;
    }
}
