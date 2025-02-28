class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        
        // Step 1: Compute LCS using DP
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Construct the SCS by backtracking
        StringBuilder scs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                scs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(str1.charAt(i - 1));
                i--;
            } else {
                scs.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Append remaining characters
        while (i > 0) {
            scs.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            scs.append(str2.charAt(j - 1));
            j--;
        }

        return scs.reverse().toString();
    }
}
