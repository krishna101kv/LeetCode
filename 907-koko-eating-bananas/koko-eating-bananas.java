// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int low = 1, high = Integer.MIN_VALUE;
//         for (int pile : piles) {
//             high = Math.max(high, pile);
//         }
//         while (low <= high) {
//             int mid = low + (high - low) / 2; 
//             int time = totalTime(piles, mid);

//             if (time <= h) {
//                 high = mid - 1;  // Try smaller speed
//             } else {
//                 low = mid + 1;   // Need more speed
//             }
//         }
//         return low;
//     }
//     public int totalTime(int[] piles, int k) {
//         int tt = 0;
//         for (int pile : piles) {
//             tt += (pile + k - 1) / k;  // Ceiling of integer division
//         }
//         return tt;
//     }
// }
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canEatAll(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile - 1) / speed + 1; // calculate the time required to eat this pile
            if (time > h) {
                return false; // if the total time is greater than h, return false
            }
        }
        return true; // if all piles can be eaten within h hours, return true
    }
}
