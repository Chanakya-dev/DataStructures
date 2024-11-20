package Algorithms;

public class SelectionSort {
    public static void main(String[] args) {
  
        int arr[] = {64, 25, 12, 22, 11};
        // 64 
        // 25 64
        int n = arr.length;
        
       
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;   
            // minIndex=0 
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    // minIndex=1
                    // minIndex=2
                    // minIndex=4
                }
            }
            int temp = arr[minIndex];
            // temp=11
            arr[minIndex] = arr[i];
            // 4Index=64
            arr[i] = temp;
            // 0Index=11
        }


        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
