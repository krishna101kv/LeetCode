class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Sort the products lexicographically
        List<List<String>> result = new ArrayList<>();
        int l = 0, r = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char search = searchWord.charAt(i);

            // Narrow down the range [l, r] to products that match the prefix
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != search)) {
                l++;
            }
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != search)) {
                r--;
            }

            // Add up to 3 matching products to the result
            List<String> suggestions = new ArrayList<>();
            for (int j = l; j < Math.min(l + 3, r + 1); j++) {
                suggestions.add(products[j]);
            }
            result.add(suggestions);
        }

        return result;
    }
}
