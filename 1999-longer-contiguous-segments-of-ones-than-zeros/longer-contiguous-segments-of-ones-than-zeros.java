class Solution {
    public boolean checkZeroOnes(String s) {
        int n = s.length();
        int maxOne = 0, maxZero = 0;
        int currOne = 0, currZero = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                currOne++;
                currZero = 0; // reset zero streak
                maxOne = Math.max(maxOne, currOne);
            } else {
                currZero++;
                currOne = 0; // reset one streak
                maxZero = Math.max(maxZero, currZero);
            }
        }
        return maxOne > maxZero;
    }
}
