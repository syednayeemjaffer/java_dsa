//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s = "aaabbb";
        Solution sol = new Solution();
        System.out.println(sol.checkString(s));
    }
}

class Solution {
    public boolean checkString(String s) {
        if (s.length() == 1){
            return true;
        }
        for (int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == 'b' && s.charAt(i+1) == 'a'){
                return false;
            }
        }
        return true;
    }
}

class Best {
    public boolean checkString(String s) {
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)<s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}