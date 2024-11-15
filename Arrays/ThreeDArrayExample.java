public class ThreeDArrayExample {
    private static int[][][] threeDArray = {
        {
            {1, 2, 3},
            {4, 5, 6}
        },
        {
            {7, 8, 9},
            {10, 11, 12}
        }
    };

    public static void insertElement(int depth, int row, int col, int value) {
        if (depth >= 0 && depth < threeDArray.length && row >= 0 && row < threeDArray[depth].length && col >= 0 && col < threeDArray[depth][row].length) {
            threeDArray[depth][row][col] = value;
            System.out.println("Inserted " + value + " at position (" + depth + ", " + row + ", " + col + ")");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void deleteElement(int depth, int row, int col) {
        if (depth >= 0 && depth < threeDArray.length && row >= 0 && row < threeDArray[depth].length && col >= 0 && col < threeDArray[depth][row].length) {
            
            for (int i = col; i < threeDArray[depth][row].length - 1; i++) {
                threeDArray[depth][row][i] = threeDArray[depth][row][i + 1];
            }
            threeDArray[depth][row][threeDArray[depth][row].length - 1] = 0;
    
            System.out.println("Deleted element at position (" + depth + ", " + row + ", " + col + ")");
        } else {
            System.out.println("Invalid index.");
        }
    }
    

    public static void main(String[] args) {
      
        System.out.println("Initial 3D Array:");
        printArray();

       
        insertElement(1, 0, 2, 99);
        printArray();

       
        deleteElement(0, 1, 1);
        printArray();
    }

   
    public static void printArray() {
        for (int i = 0; i < threeDArray.length; i++) {
            System.out.println("Depth " + i + ":");
            for (int j = 0; j < threeDArray[i].length; j++) {
                for (int k = 0; k < threeDArray[i][j].length; k++) {
                    System.out.print(threeDArray[i][j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
