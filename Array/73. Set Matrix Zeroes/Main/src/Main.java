import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [][]matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Solution s = new Solution();
        s.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean hasZero = false;
        boolean col [] = new boolean[matrix[0].length];

        for (int i =0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j] == 0){
                    hasZero = true;
                    col[j] = true;
                }
            }
            if (hasZero){
                Arrays.fill(matrix[i],0);
            }
            hasZero = false;
        }
        for (int i = 0 ;i<col.length;i++){
            if(col[i] == true){
                int j = 0;
                while (j<matrix.length){
                    matrix[j++][i] = 0;
                }
            }
        }

    }
}