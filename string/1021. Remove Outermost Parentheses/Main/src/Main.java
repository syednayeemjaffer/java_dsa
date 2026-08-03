public class Main {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        Solution sol = new Solution();
        System.out.println(sol.removeOuterParentheses(s));
    }
}

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                if (count > 0) {
                    ans.append(ch);
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}