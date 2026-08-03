import java.util.Arrays;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Solution sol = new Solution();
        System.out.println(sol.isAnagram(s,t));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        char arr1[] =s.toCharArray();
        char arr2[] =t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return (new String(arr1).equals(new String(arr2)) ? true : false);
    }
}