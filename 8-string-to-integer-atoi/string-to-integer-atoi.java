class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading and trailing whitespaces
        if (s.length() == 0) {
            return 0;
        }
        boolean neg = false; // Flag to indicate if the number is negative
        long ans = 0;
        int i = 0;
        // Check if the first character is a sign
        if (s.charAt(0) == '-') {
            neg = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }
        // Process numerical digits
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int dig = s.charAt(i) - '0';
            ans = ans * 10 + dig;
            // Check for overflow
            if (neg && -ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!neg && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            i++;
        }
        // Apply the negative sign if applicable
        if (neg) {
            ans = -ans;
        }
        return (int) ans;
    }
}
