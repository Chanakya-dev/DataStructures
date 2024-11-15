public class TwoDArrayExample {
    private static int[][] twoDArray = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    
    public static void insertElement(int row, int col, int value) {
        if (row >= 0 && row < twoDArray.length && col >= 0 && col < twoDArray[row].length) {
            twoDArray[row][col] = value;
            System.out.println("Inserted " + value + " at position (" + row + ", " + col + ")");
        } else {
            System.out.println("Invalid index.");
        }
    }

    
    public static void deleteElement(int row, int col) {
        if (row >= 0 && row < twoDArray.length && col >= 0 && col < twoDArray[row].length) {
           
            for (int i = col; i < twoDArray[row].length - 1; i++) {
                twoDArray[row][i] = twoDArray[row][i + 1];
            }
           
            twoDArray[row][twoDArray[row].length - 1] = 0;
            
            System.out.println("Deleted element at row " + row + " and column " + col);
        } else {
            System.out.println("Invalid index.");
        }
    }   

    public static void main(String[] args) {
     
        System.out.println("Initial 2D Array:");
        printArray();

      
        insertElement(1, 2, 99);
        printArray();


        deleteElement(2, 1);
        printArray();
    }

   
    public static void printArray() {
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
