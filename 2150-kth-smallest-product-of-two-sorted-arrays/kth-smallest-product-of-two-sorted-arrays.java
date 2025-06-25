class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -100000L * 100000L;
        long high = 100000L * 100000L;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = countLessEqual(nums1, nums2, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                // Count number of b in nums2 where a * b <= target => b <= target / a
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= target) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                count += l;
            } else if (a < 0) {
                // Count b in nums2 where a * b <= target => b >= ceil(target / a)
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= target) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                count += (nums2.length - l);
            } else {
                if (target >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }

    public int kthSmallestProduct(int[] nums1, int[] nums2, int k) {
        return (int) kthSmallestProduct(nums1, nums2, (long) k);
    }
}
