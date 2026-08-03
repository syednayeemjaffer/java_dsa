//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [] prices = {7,6,4,3,1};
        Solution s = new Solution();
        System.out.println(s.maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int minP = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if(minP > price){
                minP = price;
            }else{
                maxProfit = Math.max(price - minP,maxProfit);
            }
        }
        return maxProfit;
    }
}