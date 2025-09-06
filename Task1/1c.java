import java.util.*;
public class task1c {
    public static int product(int[] arr) {
        int product = 1;
        int n = arr.length;
        for(int i=0;i<n;i++){
            product = product*arr[i];
        }
        return product;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(product(arr));
    }
    
}
