package Algorithms;

public class BubbleSort {

    public static void main(String[] args) {
    
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        // Outer For Loop 1st Iteration
        // 34,64
        // 34,25,64
        // 34,25,12,64
        // 34,25,12,22,64
        // 34,25,12,22,11,64,90
        // Outer For Loop 1st Iter 1
        // 34,25,12,22,11,64,90
        // 25,34
        // 25,12,34
        // 25,12,22,34
        // 25,12,22,11,34,64,90
        // Outer For Loop 2nd Iter
        
        System.out.println("Original array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { 
            for (int j = 0; j < n - i - 1; j++) { 
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
