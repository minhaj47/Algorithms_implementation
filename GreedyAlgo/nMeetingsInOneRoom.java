package GreedyAlgo;

public class nMeetingsInOneRoom {
    public static void main(String[] args) {
        int n = 6;
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int ans = maxMeetings(start, end, n);
        System.out.println(ans);

    }

    public static int maxMeetings(int[] start, int[] end, int n) {
        //sort(end);
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (start[i + 1] > end[i])
                ans++;
        }
        return ans;
    }
}
