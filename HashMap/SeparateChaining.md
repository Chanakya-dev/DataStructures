**Description**: 
In Separate Chaining, each index of the hash table contains a linked list (or another collection). When multiple keys hash to the same index, they are stored in that list.

### Code Explanation

```java
public void put(K key, V value) {
    int index = getHash(key); // Get the hash index for the key

    // Initialize the list if it doesn't exist at the index
    if (table[index] == null) {
        table[index] = new LinkedList<>(); // Create a new list for this index
    }

    // Check if the key already exists in the list
    for (Entry<K, V> entry : table[index]) {
        if (entry.key.equals(key)) {
            entry.value = value; // Update the existing value
            return; // Exit the method after updating
        }
    }

    // If the key doesn't exist, add a new entry to the list
    table[index].add(new Entry<>(key, value));
}
```

### Separate Chaining Table Example

| Index | Linked List                |
|-------|----------------------------|
| 0     | Empty                      |
| 1     | ("apple", 10)             |
| 2     | ("banana", 20)            |
| 3     | Empty                      |
| 4     | ("orange", 30)            |
| 5     | ("grape", 40) -> ("kiwi", 50) |
| 6     | Empty                      |

### Explanation

1. **Hashing**: The method begins by calculating the index for the given key using the `getHash` method.
2. **List Initialization**: If the list at that index is `null`, a new linked list is created.
3. **Searching for Existing Key**: The method iterates through the entries in the list to check if the key already exists.
   - If it finds the key, it updates the value and exits the method.
4. **Adding New Entry**: If the key is not found, a new entry (key-value pair) is added to the list.

---

### Overall Implementation

```java
import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public CustomHashMap(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = getHash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getHash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getHash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
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
