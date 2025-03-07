import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        // Step 1: Use Sieve of Eratosthenes to find prime numbers up to 'right'
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Collect primes in the range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 3: Find the closest prime pair
        if (primes.size() < 2) return new int[]{-1, -1};

        int minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i - 1);
                num2 = primes.get(i);
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int left1 = 10, right1 = 19;
        System.out.println(Arrays.toString(sol.closestPrimes(left1, right1))); // Output: [11, 13]

        // Example 2
        int left2 = 4, right2 = 6;
        System.out.println(Arrays.toString(sol.closestPrimes(left2, right2))); // Output: [-1, -1]
    }
}
