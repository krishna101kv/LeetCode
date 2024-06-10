class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;

        // Step 1: Replace negative numbers with 0
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                A[i] = 0;
            }
        }

        // Step 2: Use the array index as a hash key
        for (int i = 0; i < n; i++) {
            int val = Math.abs(A[i]);
            if (val >= 1 && val <= n) {
                if (A[val - 1] > 0) {
                    A[val - 1] = -A[val - 1];
                } else if (A[val - 1] == 0) {
                    A[val - 1] = -(n + 1);
                }
            }
        }

        // Step 3: Find the first index which is not negative
        for (int i = 1; i <= n; i++) {
            if (A[i - 1] >= 0) {
                return i;
            }
        }

        // If all indices from 1 to n are negative, return n + 1
        return n + 1;
    }
}
