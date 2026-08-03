public class Main {
    public static void main(String[] args) {
        String s = "abcde", goal = "dceab";
        Solution sol = new Solution();
        System.out.println(sol.rotateString(s,goal));
    }
}

class Solution {
    public boolean rotateString(String s, String goal) {
        return (s+s).contains(goal);
    }
}