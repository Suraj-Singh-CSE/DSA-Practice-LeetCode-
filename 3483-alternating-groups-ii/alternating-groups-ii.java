class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int l = 0;
        int limit = n + k - 1;

        while (l < n) {
            // Find the largest valid window
            int r = l + 1;
            while (r < limit && colors[(r - 1) % n] != colors[r % n]) {
                r++;
            }

            // Count valid windows
            if (r - l >= k) {
                count += (r - l) - k + 1;
            }

            // Set new start point
            l = r;
        }

        return count;
    }
}
