public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
        int sum = 0;
        for(int i = 0 ; i < n; i++) sum += arr[i];
        
        if(sum % 2 != 0) return false;
        
        return subsetSumToK(arr.length, sum / 2, arr);
	}
    
    
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
