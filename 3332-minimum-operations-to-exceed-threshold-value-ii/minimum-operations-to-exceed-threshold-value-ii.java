class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        // Add all numbers to the min heap
        for (int num : nums) {
            minHeap.add((long) num);
        }
        
        int operations = 0;

        // Process elements until the smallest one is ≥ k
        while (minHeap.peek() < k) {
            long x = minHeap.poll(); // Smallest element
            long y = minHeap.poll(); // Second smallest element

            long newValue = x * 2 + y; // Compute new value
            minHeap.add(newValue);
            operations++;
        }

        return operations;
    }
}