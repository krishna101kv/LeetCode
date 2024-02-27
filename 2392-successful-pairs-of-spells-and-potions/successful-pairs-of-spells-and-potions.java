class Solution {
    public int binaryS(int s,int[] potions, long success){
        int c=0;
        for(int i=0;i<potions.length;i++){
            if(s*potions[i]>=success){
                c++;
            }
        }
        return c;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // int[] arr=new int[spells.length];
        // for(int i=0;i<spells.length;i++){
        //     arr[i]=binaryS(spells[i],potions,success);
        // }
        // return arr;
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];
                if (product >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            pairs[i] = m - left;
        }
        return pairs;
    }
}