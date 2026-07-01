import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {2,1,3,4};
        System.out.println(s.check(a));
    }
}
class Solution {
    public boolean check(int[] a) {
        int b [] = Arrays.copyOf(a,a.length);
        Arrays.sort(b);
        boolean result = Arrays.equals(a,b);
        if (result){
            return result;
        }
        for(int i = 0;i<a.length;i++){
            int arr[] = rotate(b,i);
            if (Arrays.equals(a,arr)){
                return true;
            }
        }

        return false;
    }
    public static int [] rotate(int arr[],int num){
        int i = num;
        int j = 0;
        int result [] = new int[arr.length];

        while(i<arr.length){
            result[j]=arr[i];
            i++;
            j++;
        }
        i=0;
        while(num != 0 && j<arr.length){
            result[j] = arr[i];
            j++;
            i++;
        }
        return result;
    }
}