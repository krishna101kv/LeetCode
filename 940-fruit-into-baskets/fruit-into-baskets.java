class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r = 0, n = fruits.length, maxlen = 0;
        int k = 2;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > k) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            if (map.size() <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }
        return maxlen;
        // int maxlen=0;
        // for(int i=0;i<fruits.length;i++){
        //     Set<Integer> set=new HashSet<>();
        //     for(int j=i;j<fruits.length;j++){
        //         set.add(fruits[j]);
        //         if(set.size()<=2){
        //             maxlen=Math.max(maxlen,j-i+1);
        //         }else{
        //             break;
        //         }
        //     }
        // }
        // return maxlen;
    }
}