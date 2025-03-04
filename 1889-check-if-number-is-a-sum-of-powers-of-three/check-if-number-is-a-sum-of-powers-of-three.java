class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false; // If remainder is 2, we cannot form n using distinct powers of three
            }
            n /= 3; // Reduce n by dividing it by 3
        }
        return true; // If we reach 0, it means n can be represented as a sum of distinct powers of three
    }
}
