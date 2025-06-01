import java.util.*;

public class DetectSquares {
    private Map<String, Integer> ptsCount;
    private List<int[]> pts;

    public DetectSquares() {
        ptsCount = new HashMap<>();
        pts = new ArrayList<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        ptsCount.put(key, ptsCount.getOrDefault(key, 0) + 1);
        pts.add(point);
    }
    public int count(int[] point) {
        int res = 0;
        int px = point[0], py = point[1];
        for (int[] p : pts) {
            int x = p[0], y = p[1];

            // Skip if not a diagonal of a square or if aligned
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) continue;

            String p1 = x + "," + py;
            String p2 = px + "," + y;

            res += ptsCount.getOrDefault(p1, 0) * ptsCount.getOrDefault(p2, 0);
        }

        return res;
    }
}
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */