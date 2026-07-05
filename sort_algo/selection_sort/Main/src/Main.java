import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
       int arr [] = {4,2,1,6,0};

       for (int i = 0 ;i< arr.length;i++){
           int min = i;
           for(int j = i+1;j< arr.length;j++){
               if (arr[min]>arr[j]){
                   min = j;
               }
           }
           int temp = arr[i];
           arr[i] = arr[min];
           arr[min] = temp;
       }
       System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public String maxValue(String n, int x) {
        String str = n;
        boolean neg = false;
        System.out.println("== "+str);
        if(str.charAt(0) == '-'){
            str = str.substring(1);
            neg=true;
        }
        System.out.println("== "+ str);

        String s = str + String.valueOf(x);
        BigInteger big = new BigInteger(s);
        for(int i = 0;i<s.length();i++){
            BigInteger num = new BigInteger(str.substring(0, i) + String.valueOf(x) + str.substring(i));
            int result = big.compareTo(num);
            if(neg) {
                if(result > 0){
                    big = num;
                }
            }else {
                if(result < 0){
                    big = num;
                }
            }
        }
        System.out.println("== "+str);

        if(neg){
            return '-'+String.valueOf(big);
        }else {
            return String.valueOf(big);
        }
    }
}
