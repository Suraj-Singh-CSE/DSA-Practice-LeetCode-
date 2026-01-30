class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        final long INF = (long) 1e18;

        // Step 1: Map strings to indices
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (String s : original) {
            if (!id.containsKey(s)) id.put(s, idx++);
        }
        for (String s : changed) {
            if (!id.containsKey(s)) id.put(s, idx++);
        }

        int m = idx;
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Initial edges
        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Step 2: Floyd–Warshall
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < m; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Step 3: DP
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            // Case 1: no operation
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            // Case 2: try transformations
            for (String orig : id.keySet()) {
                int len = orig.length();
                if (i + len > n) continue;

                if (!source.substring(i, i + len).equals(orig)) continue;

                String tgt = target.substring(i, i + len);
                if (!id.containsKey(tgt)) continue;

                int u = id.get(orig);
                int v = id.get(tgt);

                if (dist[u][v] != INF && dp[i + len] != INF) {
                    dp[i] = Math.min(dp[i], dist[u][v] + dp[i + len]);
                }
            }
        }

        return dp[0] == INF ? -1 : dp[0];
    }
}