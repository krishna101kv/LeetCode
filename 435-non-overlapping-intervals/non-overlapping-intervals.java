class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        int count = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            // Check for overlap
            if (intervals[i][0] < end) {
                count++; // Overlap, so we remove this interval
            } else {
                end = intervals[i][1]; // No overlap, update the end time
            }
        }
        
        return count;
    }
}
