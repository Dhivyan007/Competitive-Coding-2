import java.util.*;
public class task2b {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++){
            arr2[i] = scan.nextInt();
        }
        int[] merge = new int[n+n];
        for(int i=0;i<n;i++){
            merge[i] = arr1[i];
        }
        for(int i=0;i<n;i++){
            merge[n+i] = arr2[i];
        }
        Arrays.sort(merge);
        for(int i=0;i<n+n;i++){
            System.out.print(merge[i]+" ");
        }
    }
    
}
