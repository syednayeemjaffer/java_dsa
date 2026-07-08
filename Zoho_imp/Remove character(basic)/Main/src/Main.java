import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {//a e i o u
    public static void main(String[] args) {
        int n = 3536;
        Solution s = new Solution();
        System.out.println(s.primeSum(n));
    }
}
class Solution {
    static int primeSum(int n) {
        // code here
        int out = 0;
        while (n>0){
            int add = n%10;
            if(isPrime(n%10)){
                out += add;
            }
            n /= 10;
        }
        return out;
    }
    static boolean isPrime(int n){
        if(n <= 2){
            return false;
        }
        if (n % 2 == 0) {
            return false;
        }
        for(int i = 3;i * i <=n;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}