class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        int meet[][] = new int[n][2];
        int count = 1;
        for (int i = 0; i < n; i++) {
            meet[i][0] = start[i];
            meet[i][1] = end[i];
        }
        Arrays.sort(meet, Comparator.comparingDouble(a -> a[1]));
        int prev = meet[0][1];
        for (int i = 1; i < n; i++) {
            if (meet[i][0] > prev) {
                count++;
                prev = meet[i][1];
            }
        }
        return count;
    }
}
