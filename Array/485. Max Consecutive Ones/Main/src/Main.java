//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int []nums = {1,1,0,1,1,1};
        Solution s = new Solution();
        System.out.println(s.findMaxConsecutiveOnes(nums));
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int ini = 0;

        for (int i :nums){
            if(i == 1){
                ini++;
            }else {
                max = Math.max(max,ini);
                ini = 0;
            }
        }
        max = Math.max(max,ini);
        return max;
    }
}