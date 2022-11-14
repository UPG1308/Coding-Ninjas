//Recursion

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int fun(int ind, int buy, int cap, ArrayList<Integer> prices)
    {
        if(ind == prices.size() || cap == 0) return 0;
        if(buy == 1)
            return Math.max(-prices.get(ind) + fun(ind + 1, 0, cap, prices), fun(ind + 1, 1, cap, prices));
        else 
            return Math.max(prices.get(ind) + fun(ind + 1, 1, cap - 1, prices), fun(ind + 1, 0, cap, prices));
    }
	public static int maxProfit(ArrayList<Integer> prices, int n) {
		// Write your code here.
        return fun(0, 1, 2, prices);
	}
}



//Tabulation


import java.util.* ;
import java.io.*; 
public class Solution {
    
	public static int maxProfit(ArrayList<Integer> prices, int n) {
		// Write your code here.
        int dp[][][] = new int[n + 1][2][3];
        
        for(int ind = n - 1;ind >= 0 ; ind--)
        {
            for(int buy = 0; buy <= 1; buy++)
            {
                for(int cap = 1; cap <= 2; cap++)
                {
                    if(buy == 1)
                        dp[ind][buy][cap] = Math.max(-prices.get(ind) + dp[ind + 1][0][cap], dp[ind + 1][1][cap]);
                    else 
                        dp[ind][buy][cap] = Math.max(prices.get(ind) + dp[ind + 1][1][cap- 1], dp[ind + 1][0][cap]);
                }
            }
        }        
        return dp[0][1][2];
	}
}



//Space Optimization


