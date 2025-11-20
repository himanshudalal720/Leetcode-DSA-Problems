class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int right = intervals[0][1];
        int left = right - 1;
        int ans = 2;        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= left)
                continue;
            
            if (intervals[i][0] <= right) {
                left = right;
                right = intervals[i][1];
                if (left == right) {
                    left = right - 1;
                }
                ans++;
            }
            else {
                right = intervals[i][1];
                left = right - 1;
                ans += 2;
            }
        }
        
        return ans;
    }
}