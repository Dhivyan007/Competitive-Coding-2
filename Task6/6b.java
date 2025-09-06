import java.util.*; 
class RadixSort { 
    void countSort(int arr[], int exp) { 
        int n = arr.length; 
        int[] output = new int[n]; 
        int[] count = new int[10]; 
        for (int i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++; 
        for (int i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
        for (int i = n - 1; i >= 0; i--) { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
            count[(arr[i] / exp) % 10]--; 
        } 
        System.arraycopy(output, 0, arr, 0, n); 
    } 
    void radixSort(int arr[]) { 
        int max = Arrays.stream(arr).max().getAsInt(); 
        for (int exp = 1; max / exp > 0; exp *= 10) 
            countSort(arr, exp); 
   } 
    public static void main(String[] args) { 
        int arr[] = {170, 45, 75, 90, 802, 24}; 
        RadixSort rs = new RadixSort(); 
        rs.radixSort(arr); 
        System.out.println("Sorted array: " + Arrays.toString(arr)); 
    } 
}
