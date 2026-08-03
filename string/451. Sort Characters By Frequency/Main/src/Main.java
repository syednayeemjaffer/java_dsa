import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String s = "tree";
        Solution sol = new Solution();
        System.out.println(sol.frequencySort(s));
    }
}

class Solution {
    public String frequencySort(String s) {
        char res[]=new char[s.length()];
        int freq[]=new int[128];
        for(char ch:s.toCharArray()){
            freq[ch]++;
        }
        int ind=0;
        while(ind<s.length()){
            int max=0;
            char maxch=0;
            for(int i=0;i<128;i++){
                if(freq[i]>max){
                    max=freq[i];
                    maxch=(char)i;
                }
            }
            while(max-->0){
                res[ind++]=maxch;
            }
            freq[maxch]=0;
        }
        return new String(res);
    }
}