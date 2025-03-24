
class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int freeDays = days, lastEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // If a new range starts after the last covered range
            if (start > lastEnd + 1) {
                freeDays -= (end - start + 1);
            } else if (end > lastEnd) {
                freeDays -= (end - lastEnd);
            }

            lastEnd = Math.max(lastEnd, end);
        }

        return freeDays;
    }
}
