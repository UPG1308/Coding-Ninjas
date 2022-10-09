//Memoization Method

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int dp[][] = new int[n][k + 1];
        for(int row[]: dp) Arrays.fill(row, -1);
        
        return subsetSumUtil(n - 1, k ,arr, dp);
        
    }
    
    public static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp)
    {
        if(target == 0) return true;
        if(ind == 0) return arr[0] == target;
        
        if(dp[ind][target] != -1) return dp[ind][target] == 0 ? false: true;
        
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);
        
        boolean Taken = false;
        if(arr[ind] <= target)
            Taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        dp[ind][target] = notTaken || Taken ? 1 : 0;
        return notTaken || Taken;
    }
}




//Tabulation Method

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean dp[][] = new boolean[n][k + 1];
        
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(arr[0] <= k) dp[0][arr[0]] = true;
        
        for(int index = 1; index < n; index++)
        {
            for(int target = 1 ; target <= k; target++)
            {
                
                boolean NotTake = dp[index - 1][target];
                boolean Take = false;
                if(arr[index] <= target) Take = dp[index - 1][target - arr[index]];

                dp[index][target] = (Take | NotTake);
    
            }
        }
        return dp[n - 1][k];
    }
}


//Space Optimization

import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean prev[] = new boolean[k + 1];
        prev[0] = true;
        
        if(arr[0] <= k) prev[arr[0]] = true;
        for(int index = 1; index < n; index++)
        {
            boolean curr[] = new boolean[ k + 1];
            curr[0] = true;
            for(int target = 1 ; target <= k; target++)
            { 
                boolean NotTake = prev[target];
                boolean Take = false;
                if(arr[index] <= target) Take = prev[target - arr[index]];

                curr[target] = (Take | NotTake);
            }
            prev = curr;
        }
        return prev[k];
    }
}
