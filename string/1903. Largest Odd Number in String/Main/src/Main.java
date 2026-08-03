public class Main {
    public static void main(String[] args) {
        String num = "35427";
        Solution s = new Solution();
        System.out.println("//");
        System.out.println(s.largestOddNumber(num));

    }
}

class Solution {
    public String largestOddNumber(String num) {
        int i = num.length();
        while (i>0){
            String s = num.substring(0,i);
            int test = s.charAt(i-1) - '0';
            if(test % 2 != 0){
                return s;
            }
            i--;
        }
        return "";
    }
}