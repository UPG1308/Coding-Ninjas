//Recursion Method
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here..
        return Sum(num.length - 1, tar, num);
    }
    
    public static int Sum(int index, int target, int[] arr)
    {
        if(target == 0) return 1;
        if(index == 0) return arr[index] == target ? 1 : 0;
        
        int notPick = Sum(index - 1, target, arr);
        int pick = 0;
        if(arr[index] <= target) pick = Sum(index - 1, target - arr[index], arr);
        
        return pick + notPick;
    }
}


// Memoization Method

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int dp[][] = new int[num.length][tar + 1];
        for(int[] i: dp) Arrays.fill(i, -1);
        return Sum(num.length - 1, tar, num, dp);
    }
    
    public static int Sum(int index, int target, int[] arr, int[][] dp)
    {
        if(target == 0) return 1;
        if(index == 0) return arr[index] == target ? 1 : 0;
        if(dp[index][target] != -1) return dp[index][target];
        int notPick = Sum(index - 1, target, arr , dp);
        int pick = 0;
        if(arr[index] <= target) pick = Sum(index - 1, target - arr[index], arr, dp);
        
        return dp[index][target] = pick + notPick;
    }
}


//Tabulation Method

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int n = num.length;
        int dp[][] = new int[n][tar + 1];
        for(int i = 0; i < n; i++) dp[i][0] = 1;
        if(num[0] <= tar) dp[0][num[0]] = 1;
        
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j <= tar; j++)
            {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if(num[i] <= j) pick = dp[i - 1][j - num[i]];
        
                dp[i][j] = pick + notPick;
            }
        }
        return dp[n - 1][tar];
    }
}


