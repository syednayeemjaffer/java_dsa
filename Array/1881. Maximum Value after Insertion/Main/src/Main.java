public class Main {
    public static void main(String[] args) {
        String n = "131152";
        int x = 2;
        Solution s = new Solution();

        System.out.println("Out: "+ s.maxValue(n,x));
    }
}

class Solution {
    public String maxValue(String n, int x) {
        boolean neg = false;
        if(n.charAt(0) == '-'){
            neg = true;
            n = n.substring(1);
        }
        for (int i = 0;i<n.length();i++){
            int current = n.charAt(i) - '0';
            if(!neg && current<x || neg && current>x){
                return (neg ? "-" : "") + n.substring(0,i) + x + n.substring(i);
            }
        }
        return (neg ? "-": "") + n + x;
    }
}