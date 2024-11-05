# Custom HashMap Implementation with Double Hashing

## Overview of Double Hashing

1. **Primary Hash Function**:
   - This function determines the initial index for the key.
   - **Example**:
     \[
     \text{Primary Index} = k \mod \text{table size}
     \]

2. **Secondary Hash Function**:
   - This function calculates a step size for probing after a collision occurs.
   - To avoid infinite loops and to ensure that every step moves to a different index, we add 1 to the secondary hash result.
   - **Example**:
     \[
     \text{Step Size} = 1 + (k \mod c)
     \]
   - Here, \( c \) is often a prime number less than the table size.

## Detailed Breakdown of Double Hashing

### Example Walkthrough

#### Setting Up

- **Hash Table Size**: 10
- **Keys to Insert**: 32, 12, 22, 42
- **Primary Hash Function**: \( k \mod 10 \)
- **Secondary Hash Function**: \( 1 + (k \mod 7) \)

### Step-by-Step Insertion

#### Key 1: Insert 32

1. **Primary Index**:
   \[
   32 \mod 10 = 2
   \]
   - Insert 32 at index 2.

#### Key 2: Insert 12

1. **Primary Index**:
   \[
   12 \mod 10 = 2
   \]
   - Collision occurs at index 2 (occupied by 32).
   
2. **Secondary Hash Function**:
   \[
   \text{Step Size} = 1 + (12 \mod 7) = 1 + 5 = 6
   \]

3. **Probing**:
   - New index = \( (2 + 6) \mod 10 = 8 \).
   - Insert 12 at index 8.

#### Key 3: Insert 22

1. **Primary Index**:
   \[
   22 \mod 10 = 2
   \]
   - Collision occurs at index 2 (occupied by 32).

2. **Secondary Hash Function**:
   \[
   \text{Step Size} = 1 + (22 \mod 7) = 1 + 1 = 2
   \]

3. **Probing**:
   - New index = \( (2 + 2) \mod 10 = 4 \).
   - Insert 22 at index 4.

#### Key 4: Insert 42

1. **Primary Index**:
   \[
   42 \mod 10 = 2
   \]
   - Collision occurs at index 2 (occupied by 32).

2. **Secondary Hash Function**:
   \[
   \text{Step Size} = 1 + (42 \mod 7) = 1 + 0 = 1
   \]

3. **Probing**:
   - New index = \( (2 + 1) \mod 10 = 3 \).
   - Insert 42 at index 3.

### Final Hash Table State

After inserting all the keys, the hash table will look like this:

| Index | Value |
|-------|-------|
| 0     | Empty |
| 1     | Empty |
| 2     | 32    |
| 3     | 42    |
| 4     | 22    |
| 5     | Empty |
| 6     | Empty |
| 7     | Empty |
| 8     | 12    |
| 9     | Empty |

## Overall Implementation

```java
public class CustomHashMap<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private int capacity;

    // Inner class to represent a key-value pair
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash table
    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    // Hash function to compute the index for the key
    private int getHash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Secondary hash function for double hashing
    private int getStepSize(K key) {
        int prime = 7; // A small prime number
        return prime - (Math.abs(key.hashCode()) % prime);
    }

    public void put(K key, V value) {
        int index = getHash(key); // Get the primary index for the key
        int stepSize = getStepSize(key); // Get the step size for double hashing

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index].value = value; // Update the existing value
                return; // Exit the method after updating
            }
            index = (index + stepSize) % capacity; // Move to the next index using the step size
        }

        table[index] = new Entry<>(key, value); // Add the new entry to the table
        size++; // Increment the size of the hash map
    }

    public V get(K key) {
        int index = getHash(key); // Get the primary index for the key
        int stepSize = getStepSize(key); // Get the step size for double hashing

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value; // Return the value if found
            }
            index = (index + stepSize) % capacity; // Move to the next index using the step size
        }
        return null; // Return null if the key is not found
    }

    public void remove(K key) {
        int index = getHash(key); // Get the primary index for the key
        int stepSize = getStepSize(key); // Get the step size for double hashing

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null; // Remove the entry from the table
                size--; // Decrement the size of the hash map
                return; // Exit the method after removing
            }
            index = (index + stepSize) % capacity; // Move to the next index using the step size
        }
    }

    public int size() {
        return size; // Return the current size of the hash map
    }

    public boolean isEmpty() {
        return size == 0; // Return true if the hash map is empty
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>(10);
        hashMap.put("apple", 10);
        hashMap.put("banana", 20);
        hashMap.put("orange", 30);

        System.out.println(hashMap.get("apple")); // Output: 10
        System.out.println(hashMap.get("banana")); // Output: 20

        hashMap.remove("apple");
        System.out.println(hashMap.get("apple")); // Output: null
    }
}
```
