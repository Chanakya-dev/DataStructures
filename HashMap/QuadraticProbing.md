# Quadratic Probing

1. **Primary Hash Function**:
   - This function determines the initial index for the key.
   - **Example**:
     \[
     \text{Primary Index} = k \mod \text{table size}
     \]

2. **Quadratic Probing**:
   - In case of a collision, this method uses a quadratic function to calculate the next index to check.
   - The probing sequence is defined by:
     \[
     \text{New Index} = (\text{Primary Index} + i^2) \mod \text{table size}
     \]
   - Here, \( i \) is the number of collisions that have occurred, starting from 1.

## Detailed Breakdown of Quadratic Probing

### Example Walkthrough

```java
 private int getHash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int primaryIndex = getHash(key); // Get the primary index for the key

        if (table[primaryIndex] == null) {
            table[primaryIndex] = new Entry<>(key, value);
            size++;
            return;
        }

        // Collision occurred
        for (int i = 1; i < table.length; i++) {
            int newIndex = (primaryIndex + i * i) % table.length; // Quadratic probing

            if (table[newIndex] == null) {
                table[newIndex] = new Entry<>(key, value);
                size++;
                return;
            }
        }
        throw new RuntimeException("HashMap is full");
    }
```

#### Setting Up

- **Hash Table Size**: 10
- **Keys to Insert**: 32, 12, 22, 42
- **Primary Hash Function**: \( k \mod 10 \)

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

2. **Quadratic Probing**:
   - For \( i = 1 \):
     \[
     \text{New Index} = (2 + 1^2) \mod 10 = 3
     \]
   - Insert 12 at index 3.

#### Key 3: Insert 22

1. **Primary Index**:
   \[
   22 \mod 10 = 2
   \]
   - Collision occurs at index 2 (occupied by 32).

2. **Quadratic Probing**:
   - For \( i = 1 \):
     \[
     \text{New Index} = (2 + 1^2) \mod 10 = 3
     \]
   - Collision occurs at index 3 (occupied by 12).
   - For \( i = 2 \):
     \[
     \text{New Index} = (2 + 2^2) \mod 10 = 6
     \]
   - Insert 22 at index 6.

#### Key 4: Insert 42

1. **Primary Index**:
   \[
   42 \mod 10 = 2
   \]
   - Collision occurs at index 2 (occupied by 32).

2. **Quadratic Probing**:
   - For \( i = 1 \):
     \[
     \text{New Index} = (2 + 1^2) \mod 10 = 3
     \]
   - Collision occurs at index 3 (occupied by 12).
   - For \( i = 2 \):
     \[
     \text{New Index} = (2 + 2^2) \mod 10 = 6
     \]
   - Collision occurs at index 6 (occupied by 22).
   - For \( i = 3 \):
     \[
     \text{New Index} = (2 + 3^2) \mod 10 = 1
     \]
   - Insert 42 at index 1.

### Final Hash Table State

After inserting all the keys, the hash table will look like this:

| Index | Value |
|-------|-------|
| 0     | Empty |
| 1     | 42    |
| 2     | 32    |
| 3     | 12    |
| 4     | Empty |
| 5     | Empty |
| 6     | 22    |
| 7     | Empty |
| 8     | Empty |
| 9     | Empty |

### Explanation

1. **Hashing**: 
   - The method calculates the initial hash index using the primary hash function.
   - The primary hash function determines where to start looking for the key in the table.

2. **Collision Handling**: 
   - If a collision occurs (the slot at the calculated index is already occupied), the method enters a loop that continues until it finds an empty slot:
     - For each collision, it calculates a new index using the quadratic probing formula:
       \[
       \text{New Index} = (\text{Primary Index} + i^2) \mod \text{table size}
       \]
       where \( i \) is the number of collisions encountered so far (starting from 1).
     - If the current slot is not empty and the key matches, it updates the value and exits the method.
     - If the slot is occupied and the key does not match, it increments \( i \) to probe the next index.

3. **Adding New Entry**: 
   - Once an empty slot is found (where the entry is `null`), the new key-value pair is inserted into that index, and the size of the hash table is incremented.
   - If the table becomes full without finding an empty slot, an exception is thrown.

### Overall Implementation

```java

public class CustomHashMap<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private int capacity;

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = getHash(key);
        for (int i = 0; i < capacity; i++) {
            int probingIndex = (index + i * i) % capacity;
            if (table[probingIndex] == null) {
                table[probingIndex] = new Entry<>(key, value);
                size++;
                return;
            }
            if (table[probingIndex].key.equals(key)) {
                table[probingIndex].value = value;
                return;
            }
        }
        throw new RuntimeException("HashMap is full");
    }

    public V get(K key) {
        int index = getHash(key);
        for (int i = 0; i < capacity; i++) {
            int probingIndex = (index + i * i) % capacity;
            if (table[probingIndex] == null) {
                return null;
            }
            if (table[probingIndex].key.equals(key)) {
                return table[probingIndex].value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getHash(key);
        for (int i = 0; i < capacity; i++) {
            int probingIndex = (index + i * i) % capacity;
            if (table[probingIndex] == null) {
                return;
            }
            if (table[probingIndex].key.equals(key)) {
                table[probingIndex] = null;
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
