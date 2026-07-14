import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int [] nums = {5,7,8,8,10};int target = 8;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(nums,target)));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstSearch(nums,target,0,nums.length-1);
        if(first == -1){
            return new int[] {-1,-1};
        }
        int second = lastSearch(nums,target,first+1,nums.length-1);
        return new int[] {first,second};
    }
    public int firstSearch(int []nums,int target,int low , int high){
        int result = -1;
        while (low<=high){
            int mid = low + ((high - low)/2);
            if(nums[mid] == target){
                result = mid;
                high = mid-1;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }else {
                low = mid +1;

            }
        }
        return result;
    }

    public int lastSearch(int []nums,int target,int low , int high){
        int result = -1;
        while (low<=high){
            int mid = low + ((high - low)/2);
            if(nums[mid] == target){
                result = mid;
            }
            if(nums[mid] > target){
                high = mid-1;
            }else {
                low = mid +1;
            }
        }
        return result;
    }
}
