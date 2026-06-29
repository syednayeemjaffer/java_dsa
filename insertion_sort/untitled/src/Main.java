import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int arr[] = {4,2,-1,5,1,3};

        for(int i = 1;i< arr.length;i++){
            int j = i-1;
            int key = arr[i];

            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]= key;
        }
        System.out.println(Arrays.toString(arr));
    }
}
