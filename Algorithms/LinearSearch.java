package Algorithms;

public class LinearSearch {
    public static void main(String[] args) {
        int[]a={2,3,4,5,7,6};

        int target=7;

        for(int i=0;i<a.length;i++){
            if(a[i]==target){
                System.out.println("Target found at Index "+i);
                break;
            }
            else{
                System.out.println("False");
            }
        }
    }
}
