class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; // Extra space for boundary condition

        for (int i = n - 1; i >= 0; i--) {
            long solveThis = questions[i][0]; // Points if solving this question
            int next = i + questions[i][1] + 1; // Next available index after solving
            
            if (next < n) {
                solveThis += dp[next]; // Add the points from the next available question
            }

            dp[i] = Math.max(solveThis, dp[i + 1]); // Take max of solving or skipping
        }

        return dp[0]; // Maximum points starting from index 0
    }
}
