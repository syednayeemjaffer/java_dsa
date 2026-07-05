import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {3,4,5,1,2};//rot=3
        System.out.println(s.check(a));

    }
}

//1 2 3 4 5 6
//2 3 4 5 6 1
//3 4 5 6 1 2
//4 5 6 1 2 3
//5 6 1 2 3 4
//6 1 2 3 4 5

class Solution {
    public boolean check(int[] a) {
        int count = 0;
        for(int i = 0;i<a.length;i++){
            if(a[i]>a[(i+1) % a.length]){
                count++;
            }

            if(count>1){
                return false;
            }
        }
        return true;
    }
}

//class Solution {
//    public boolean check(int[] a) {
//        int b [] = Arrays.copyOf(a,a.length);
//        Arrays.sort(b);
//        boolean result = Arrays.equals(a,b);
//        if (result){
//            return result;
//        }
//        for(int i = 0;i<a.length;i++){
//            int arr[] = rotate(b,i);
//            if (Arrays.equals(a,arr)){
//                return true;
//            }
//        }
//
//        return false;
//    }
//    public static int [] rotate(int arr[],int num){
//        int i = num;
//        int j = 0;
//        int result [] = new int[arr.length];
//
//        while(i<arr.length){
//            result[j]=arr[i];
//            i++;
//            j++;
//        }
//        i=0;
//        while(num != 0 && j<arr.length){
//            result[j] = arr[i];
//            j++;
//            i++;
//        }
//        return result;
//    }
//}
