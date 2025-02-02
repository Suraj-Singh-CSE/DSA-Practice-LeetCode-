import java.util.Random;

class Solution {
    private int[][] rects;
    private int[] areas;
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.rand = new Random();
        this.areas = new int[rects.length];


        int cumulativeArea = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            cumulativeArea += area;
            areas[i] = cumulativeArea;
        }
    }

    public int[] pick() {

        int target = rand.nextInt(areas[areas.length - 1]);
        int rectIndex = binarySearch(target);


        int[] rect = rects[rectIndex];
        int x = rand.nextInt(rect[2] - rect[0] + 1) + rect[0];
        int y = rand.nextInt(rect[3] - rect[1] + 1) + rect[1];
        return new int[]{x, y};
    }

    private int binarySearch(int target) {
        int left = 0, right = areas.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (areas[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */