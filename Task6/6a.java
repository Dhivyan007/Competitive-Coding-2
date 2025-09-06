import java.util.*; 
class CountingSort { 
    void countSort(int arr[]) { 
        int n = arr.length; 
        int max = Arrays.stream(arr).max().getAsInt(); 
        int[] count = new int[max + 1]; 
        for (int num : arr) count[num]++; 
        for (int i = 1; i <= max; i++) count[i] += count[i - 1]; 
        int[] output = new int[n]; 
        for (int i = n - 1; i >= 0; i--) { 
            output[count[arr[i]] - 1] = arr[i]; 
            count[arr[i]]--; 
        } 
        System.arraycopy(output, 0, arr, 0, n); 
    } 
    public static void main(String[] args) { 
        int arr[] = {4, 2, 2, 8, 3, 3}; 
        CountingSort cs = new CountingSort(); 
        cs.countSort(arr); 
        System.out.println("Sorted array: " + Arrays.toString(arr)); 
    } 
} 
