package Algorithms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[]a={2,3,4,5,75,12,34};
        // 2,3,4,5,12,34,75
        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
        int target=12;
       int low=0; int high=a.length-1;  
        while(low<=high){
            // 2 -> low -> 0
            // 75 -> high -> 6
            // 0+(6-0)/2
            // 6/2*3-
            //0+3=

            // low=3+1=4
            // 4+(6-4)/2
            // 4+2/2=1
            // 5

            // 4+(5-4)/2
            // 4+(1)/2
            // 4+1=5
            // 4+(4-4)/2
            // 4=mid
            int mid=low+(high-low)/2;
            if(a[mid]==target){
                System.out.println("Target found at Index "+mid);
                break;
            }
            else{
                if(a[mid]>target){
                    high=mid-1;
                    System.out.println("Moving Towards Left");
                }
                else{
                    low=mid+1;
                    System.out.println("Moving Towards Right");
                }
            }
        }
    }
}
