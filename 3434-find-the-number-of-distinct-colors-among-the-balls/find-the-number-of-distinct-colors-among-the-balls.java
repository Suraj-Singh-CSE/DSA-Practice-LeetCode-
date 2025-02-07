import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColorMap = new HashMap<>();  // Stores the color of each ball
        Map<Integer, Integer> colorFrequency = new HashMap<>(); // Tracks the frequency of each color
        int[] result = new int[queries.length];
        int distinctColors = 0;

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColorMap.containsKey(ball)) {
                int oldColor = ballColorMap.get(ball);
                colorFrequency.put(oldColor, colorFrequency.get(oldColor) - 1);
                if (colorFrequency.get(oldColor) == 0) {
                    distinctColors--;  // Remove from distinct colors
                    colorFrequency.remove(oldColor);
                }
            }

            ballColorMap.put(ball, color);
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);
            if (colorFrequency.get(color) == 1) {
                distinctColors++;
            }

            result[i] = distinctColors;
        }

        return result;
    }
}
