
class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        
        // Construct adjacency list representation of the tree
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        
        // Bob's path tracking
        Map<Integer, Integer> bobTime = new HashMap<>();
        int[] bobDepth = new int[n];
        Arrays.fill(bobDepth, -1);
        findBobPath(tree, bob, -1, 0, bobDepth, bobTime);
        
        // Alice's DFS to find max profit
        return dfs(tree, 0, -1, 0, bobDepth, amount);
    }

    private boolean findBobPath(List<Integer>[] tree, int node, int parent, int depth, int[] bobDepth, Map<Integer, Integer> bobTime) {
        bobDepth[node] = depth;
        if (node == 0) { // Root reached
            bobTime.put(0, depth);
            return true;
        }
        
        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            if (findBobPath(tree, neighbor, node, depth + 1, bobDepth, bobTime)) {
                bobTime.put(node, depth);
                return true;
            }
        }
        
        bobDepth[node] = -1; // Reset if Bob didn't pass through
        return false;
    }

    private int dfs(List<Integer>[] tree, int node, int parent, int depth, int[] bobDepth, int[] amount) {
        int profit = 0;
        
        if (bobDepth[node] == -1 || depth < bobDepth[node]) { 
            profit = amount[node]; // Alice gets full amount
        } else if (depth == bobDepth[node]) { 
            profit = amount[node] / 2; // Alice and Bob share
        } 
        
        int maxProfit = Integer.MIN_VALUE;
        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            maxProfit = Math.max(maxProfit, dfs(tree, neighbor, node, depth + 1, bobDepth, amount));
        }
        
        return (maxProfit == Integer.MIN_VALUE) ? profit : profit + maxProfit;
    }
}
