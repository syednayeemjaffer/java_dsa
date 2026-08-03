import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int nums[] = {3,1,-2,-5,2,-4};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.rearrangeArray(nums)));
    }// 3 ,
}

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int result[] = new int[nums.length];
        int i = 0,j = 1;
        for (int num:nums){
            if(num>-1){
                result[i] = num;
                i+=2;
            }else {
                result[j] = num;
                j+=2;
            }
        }
        return result;
    }
}