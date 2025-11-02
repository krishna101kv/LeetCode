 class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        
        // 'l' from the image: the left pointer of the sliding window.
        int l = 0;
        
        // 'maxf' from the image: tracks the frequency of the *most frequent*
        // character we have seen in *any* window.
        int maxf = 0;
        
        // 'maxlen' from the image. In this optimized solution, the final
        // window size (s.length() - l) will be the max length.
        // We can also track it explicitly.
        int maxlen = 0;

        // 'r' is the right pointer, which iterates through the string.
        for (int r = 0; r < s.length(); r++) {
            
            // 1. Add the new character (at 'r') to the window.
            // This corresponds to: hash[s[r] - 'A']++
            int rCharIndex = s.charAt(r) - 'A';
            hash[rCharIndex]++;
            
            // 2. Update the max frequency found so far.
            // This corresponds to: maxf = max(maxf, hash[s[r] - 'A'])
            maxf = Math.max(maxf, hash[rCharIndex]);
            
            // 3. Check if the current window is invalid.
            // The number of replacements needed is (windowSize - maxf).
            // windowSize is (r - l + 1).
            // This corresponds to: if ((r - l + 1) - maxf > k)
            int windowSize = r - l + 1;
            if (windowSize - maxf > k) {
                // 4. If invalid, shrink the window from the left.
                // This corresponds to: hash[s[l] - 'A']--
                int lCharIndex = s.charAt(l) - 'A';
                hash[lCharIndex]--;
                
                // This corresponds to: l = l + 1
                l++;
                
                // Note: The 'maxf = 0' in the image is a bug. We don't
                // reset maxf. We only care about the *highest* frequency
                // we've ever seen, as this allows the window to be
                // as large as possible.
            }
            
            // Update the maximum length found.
            // The current window size is always (r - l + 1).
            maxlen = Math.max(maxlen, r - l + 1);
        }
        
        // Return the maximum length found.
        return maxlen;
        
    }
}