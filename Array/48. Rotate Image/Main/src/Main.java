import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution s = new Solution();
        s.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0;i<matrix.length;i++){
            for (int j = i+1;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0;i<matrix.length;i++){
            reverse(matrix[i]);
        }
    }
    public void reverse(int[] arr){
        int i =0,j=arr.length-1;
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
}