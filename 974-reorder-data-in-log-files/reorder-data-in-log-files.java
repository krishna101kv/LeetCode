class Solution {
    public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) { // Both are letter logs
                int compare = split1[1].compareTo(split2[1]);
                if (compare == 0) { // If the contents are equal, compare identifiers
                    return split1[0].compareTo(split2[0]);
                }
                return compare;
            } else if (isDigit1 && isDigit2) { // Both are digit logs
                return 0; // Maintain their relative order
            } else if (isDigit1) { // Digit log comes after letter log
                return 1;
            } else { // Letter log comes before digit log
                return -1;
            }
        });
        return logs;
    }
}