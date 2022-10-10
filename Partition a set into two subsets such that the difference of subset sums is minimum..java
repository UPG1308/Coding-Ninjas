import java.util.* ;
import java.io.*; 
public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
        int TotalSum = 0;
        for(int i = 0; i < n; i++) TotalSum += arr[i];
        int k = TotalSum;
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
        int dif = Integer.MAX_VALUE;
        for(int i = 0; i <= TotalSum ; i++)
        {
            if(prev[i])
            {
                int s1 = i;
                int s2 = TotalSum - s1;
                dif = Math.min(dif, Math.abs(s2 - s1));
            }
        }
        return dif;
	}
}
