import java.util.Arrays;
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return jump(n - 1 , heights, dp);
        //return ans;
    }

    public static int jump(int n, int[] heights,int[] dp)
    {
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        
        int left = jump((n - 1), heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;
        if(n > 1)
            right = jump((n - 2), heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        return dp[n] = Math.min(left,right);
        
    }
}
