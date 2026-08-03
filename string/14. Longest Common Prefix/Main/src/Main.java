//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String strs[] = {"","flowe","f"};
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(strs));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1;i<strs.length;i++){
            while (!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);

                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}