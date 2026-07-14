import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int a[] = {1, 5, 9, 10, 15, 20}, b[] = {2, 3, 8, 13};
        Solution s = new Solution();
        s.mergeArrays(a,b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }
}
class Solution {
    public void mergeArrays(int a[], int b[]) {

        int i = a.length-1;
        while (i>=0){
            if(a[i] > b[b.length-1]){
                int temp = a[i];
                
                Arrays.sort(b);
            }
            i--;
        }
    }
}

