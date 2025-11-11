class Solution {
public:
    int findMaxForm(vector<string>& strs, int m, int n) {
        // dp[i][j] means the max number of strings we can form with i zeros and j ones
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        
        for (auto &s : strs) {
            int zeros = 0, ones = 0;
            
            // Count zeros and ones in the current string
            for (char c : s) {
                if (c == '0') zeros++;
                else ones++;
            }
            
            // Traverse backwards (to avoid recomputation in same iteration)
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
};
