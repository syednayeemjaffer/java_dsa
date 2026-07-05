
public class Main {
    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2};
        Solution s = new Solution();
        System.out.println(s.majorityElement(nums));
    }
}
//2,2,1,1,1,2,2
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}