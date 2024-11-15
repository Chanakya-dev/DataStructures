public class OneDArrayExample {
    private static int[] oneDArray = {1, 2, 3, 4, 5};

    
    public static void insertElement(int index, int value) {
        if (index >= 0 && index < oneDArray.length) {
            oneDArray[index] = value;
            System.out.println("Inserted " + value + " at index " + index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    
    public static void insertAtStart(int value) {
        // Create a new array with the same length as the original array
        int[] newArray = new int[oneDArray.length];

        // Insert the new value at the start (index 0)
        newArray[0] = value;

        // Shift the existing elements to the right and ensure the last element is omitted
        for (int i = 0; i < oneDArray.length - 1; i++) {
            newArray[i + 1] = oneDArray[i];
        }

        // Update the original array to reference the new array
        oneDArray = newArray;

        // Print that the value was inserted
        System.out.println("Inserted " + value + " at the start");
    }

 
    public static void insertAtEnd(int value) {
        oneDArray[oneDArray.length - 1] = value;
        System.out.println("Inserted at End " + value);
    }
    

  
    public static void deleteElement(int index) {
        if (index >= 0 && index < oneDArray.length) {
           
            for (int i = index; i < oneDArray.length - 1; i++) {
                oneDArray[i] = oneDArray[i + 1];
            }

            oneDArray[oneDArray.length - 1] = 0;

            System.out.println("Deleted element at index " + index);
        } else {
            System.out.println("Invalid index.");
        }
    }
    

    public static void main(String[] args) {
  
        System.out.println("Initial 1D Array: ");
        printArray();

        insertElement(2, 99);
        printArray();

        insertAtStart(0);
        printArray();

        insertAtEnd(100);
        printArray();

        deleteElement(4);
        printArray();
    }

    public static void printArray() {
        for (int i = 0; i < oneDArray.length; i++) {
            System.out.print(oneDArray[i] + " ");
        }
        System.out.println();
    }
}
