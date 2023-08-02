import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> arr, int m)
    {
        int n = arr.size();
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
    public static int[] Range(ArrayList<Integer> arr){
        int max = -1, sum = 0;
        for(int i = 0; i < arr.size(); i++){
            max = Math.max(max, arr.get(i));
            sum += arr.get(i);
        }
        return new int[]{max, sum};
    }


    public static int countStudents(ArrayList<Integer> arr, int pages){
        int students = 1;
        long pagesStudent = 0;
        for(int i = 0;i < arr.size(); i++){
            if(pagesStudent + arr.get(i) <= pages)pagesStudent += arr.get(i);
            else{
                students += 1;
                pagesStudent = arr.get(i);
            }
            
        }
        return students;
    }
}
