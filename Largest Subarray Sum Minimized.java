
public class Solution {
    public static int largestSubarraySumMinimized(int []arr, int m) {
        int n = arr.length;
        if(m > n) return -1;
        int []range = Range(arr);
        int low = range[0], high = range[1];
        while(low <= high){
            int mid = low + (high - low)/2;
            int students = countStudents(arr, mid);
            if(students > m) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    public static int[] Range(int[] arr){
        int max = -1, sum = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        return new int[]{max, sum};
    }

    public static int countStudents(int[] arr, int pages){
        int students = 1;
        long pagesStudent = 0;
        for(int i = 0;i < arr.length; i++){
            if(pagesStudent + arr[i] <= pages)pagesStudent += arr[i];
            else{
                students += 1;
                pagesStudent = arr[i];
            }
            
        }
        return students;
    }
}
