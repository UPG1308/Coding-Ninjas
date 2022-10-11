// Recursion Method

import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

           return fun(value.length - 1, maxWeight, weight, value);
    }
    
    static int fun(int index, int maxWeight, int[] weight, int[] value)
    {
        if(index == 0) 
        {
            if(maxWeight >= weight[0]) return value[0];
            return 0;
        }
        if(maxWeight == 0) return 0;
        int pick = 0;
        if(maxWeight >= weight[index])
           pick = value[index] + fun(index - 1, maxWeight - weight[index], weight, value);
        int notPick = fun(index - 1, maxWeight, weight, value);
        
        return Math.max(pick, notPick);
    }
}


// Memoization Method

import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            int dp[][] = new int[n][maxWeight + 1];
            for(int[] i:dp) Arrays.fill(i, -1);
           return fun(value.length - 1, maxWeight, weight, value, dp);
    }
    
    static int fun(int index, int maxWeight, int[] weight, int[] value, int[][] dp)
    {
        if(index == 0) 
        {
            if(maxWeight >= weight[0]) return value[0];
            return 0;
        }
        if(dp[index][maxWeight] != -1) return dp[index][maxWeight];
        if(maxWeight == 0) return 0;
        int pick = 0;
        if(maxWeight >= weight[index])
           pick = value[index] + fun(index - 1, maxWeight - weight[index], weight, value,dp);
        int notPick = fun(index - 1, maxWeight, weight, value, dp);
        
        return dp[index][maxWeight] = Math.max(pick, notPick);
    }
}


//Tabulation Method

import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight + 1];
        for(int MaxWeight = weight[0]; MaxWeight <= maxWeight; MaxWeight++)
            dp[0][MaxWeight] = value[0];
        
        for(int index = 1 ;index < n; index++)
        {
            for(int MaxWeight = 0; MaxWeight <= maxWeight; MaxWeight++)
            {
                int pick = 0;
                if(MaxWeight >= weight[index])
                   pick = value[index] + dp[index - 1][MaxWeight - weight[index]];
                int notPick = dp[index - 1] [MaxWeight];

                dp[index][MaxWeight] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][maxWeight];
    }
}


//Space Optimization Method


import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int prev[] = new int[maxWeight + 1];

        for(int MaxWeight = weight[0]; MaxWeight <= maxWeight; MaxWeight++)
            prev[MaxWeight] = value[0];
        
        for(int index = 1 ;index < n; index++)
        {
            for(int MaxWeight = maxWeight; MaxWeight >= 0; MaxWeight--)
            {
                int pick = 0;
                if(MaxWeight >= weight[index])
                   pick = value[index] + prev[MaxWeight - weight[index]];
                int notPick = prev[MaxWeight];

                prev[MaxWeight] = Math.max(pick, notPick);
            }
            
        }
        return prev[maxWeight];
    }
}

