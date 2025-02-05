class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0; // A mountain requires at least 3 elements
        
        int maxLength = 0;
        int i = 1; // Start from the second element
        
        while (i < n - 1) {
            // Check if the current element is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand to the left
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Expand to the right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the length of the mountain
                int currentLength = right - left + 1;
                maxLength = Math.max(maxLength, currentLength);

                // Move `i` to the end of the current mountain
                i = right;
            } else {
                i++;
            }
        }

        return maxLength;
    }
}
