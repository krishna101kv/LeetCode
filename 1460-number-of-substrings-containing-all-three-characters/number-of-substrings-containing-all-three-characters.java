class Solution {
    public int numberOfSubstrings(String s) {
      int n = s.length();
        int[] lastSeen = {-1, -1, -1}; // tracks last seen index of 'a','b','c'
        int count = 0;

        for (int i = 0; i < n; i++) {
            // update last seen position of current character
            lastSeen[s.charAt(i) - 'a'] = i;

            // if all three chars have been seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                int minIndex = Math.min(lastSeen[0], 
                                Math.min(lastSeen[1], lastSeen[2]));
                count += (1 + minIndex);
            }
        }
        return count;  
    }
}
