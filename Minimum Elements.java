//Recursion Method

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int ans = fun(num.length - 1, x, num);
        if(ans > 100000) return -1;
        return ans;
    }

    public static int fun(int index, int target, int[] num)
    {
        if(index == 0)
        {
            if(target % num[0] == 0) return target/num[0];
            return 10000000;
        }
        int notTake = 0 + fun(index - 1, target, num);
        int Take = Integer.MAX_VALUE;
        if(num[index] <= target)
            Take = 1 + fun(index, target - num[index], num);
        return Math.min(Take, notTake);
        
    }
}

//Memoization Method

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int dp[][] = new int[num.length][x + 1];
        for(int[] row:dp)Arrays.fill(row, -1);
        int ans = fun(num.length - 1, x, num,dp);
        if(ans > 100000) return -1;
        return ans;
    }

    public static int fun(int index, int target, int[] num, int[][] dp)
    {
        if(index == 0)
        {
            if(target % num[0] == 0) return target/num[0];
            return 10000000;
        }
        if(dp[index][target] != -1) return dp[index][target];
        int notTake = 0 + fun(index - 1, target, num,dp);
        int Take = Integer.MAX_VALUE;
        if(num[index] <= target)
            Take = 1 + fun(index, target - num[index], num, dp);
        return dp[index][target] = Math.min(Take, notTake);
        
    }
}

//Tabulation Method

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n = num.length;
        int dp[][] = new int[n][x + 1];
        
        for(int i = 0; i <= x; i++)
        {
           if(i % num[0] == 0) dp[0][i] = i/num[0];
            else dp[0][i] = 1000000;
        }
        for(int index = 1;index < n; index++)
        {
            for(int target = 0; target <= x; target++)
            {
                int notTake = 0 + dp[index - 1][target];
                int Take = Integer.MAX_VALUE;
                if(num[index] <= target)
                    Take = 1 + dp[index][target - num[index]];
                 dp[index][target] = Math.min(Take, notTake);
            }
        }     
        if(dp[n - 1][x] > 100000) return -1;
        return dp[n - 1][x];
    }
}

//Space Optimization Method

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n = num.length;
        int prev[] = new int[x + 1];
        int curr[] = new int[x + 1];
        
        for(int i = 0; i <= x; i++)
        {
           if(i % num[0] == 0) prev[i] = i/num[0];
            else prev[i] = 1000000;
        }
        for(int index = 1;index < n; index++)
        {
            for(int target = 0; target <= x; target++)
            {
                int notTake = 0 + prev[target];
                int Take = Integer.MAX_VALUE;
                if(num[index] <= target)
                    Take = 1 + curr[target - num[index]];
                 curr[target] = Math.min(Take, notTake);
            }
            prev = curr;
        }     
        if(prev[x] > 100000) return -1;
        return prev[x];
    }
}
