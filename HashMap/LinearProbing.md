**Description**: 
In Linear Probing, if a collision occurs at the hashed index, the algorithm checks the next slot in the array sequentially until it finds an empty slot.

### Coding Explanation

```java

 private int getHash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = getHash(key);

        // Using a for loop to probe for an available slot
        for (int i = 0; i < table.length; i++) {
            index = (getHash(key) + i) % table.length; // Linear probing

            if (table[index] == null || table[index].isDeleted) {
                table[index] = new Entry<>(key, value);
                size++;
                return;
            } else if (table[index].key.equals(key)) {
                table[index].value = value; // Update value for existing key
                return;
            }
        }

        throw new RuntimeException("HashMap is full");
    }

    
```
### Linear Probing Table Structure Example

| Index | Entry              |
|-------|--------------------|
| 0     | Empty              |
| 1     | ("apple", 10)     |
| 2     | ("banana", 20)    |
| 3     | Empty              |
| 4     | ("orange", 30)    |
| 5     | ("grape", 40)     |
| 6     | ("kiwi", 50)      |

### Explanation

1. **Hashing**: The method calculates the initial hash index.
2. **Collision Handling**: It enters a loop that continues until it finds an empty slot:
   - If the current slot is not empty and the key matches, it updates the value and exits.
   - If the slot is occupied and the key does not match, it increments the index and checks the next slot using modulo to wrap around if necessary.
3. **Adding New Entry**: Once an empty slot is found, the new key-value pair is inserted.

### Overall Code

```java
class HashMaps1<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        boolean isDeleted;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }

    private Entry<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMaps1(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        int index = getHash(key);

        // Using a for loop to probe for an available slot
        for (int i = 0; i < table.length; i++) {
            index = (getHash(key) + i) % table.length; // Linear probing

            if (table[index] == null || table[index].isDeleted) {
                table[index] = new Entry<>(key, value);
                size++;
                return;
            } else if (table[index].key.equals(key)) {
                table[index].value = value; // Update value for existing key
                return;
            }
        }

        throw new RuntimeException("HashMap is full");
    }

    public V get(K key) {
        int index = getHash(key);

        // Using a for loop to probe for the key
        for (int i = 0; i < table.length; i++) {
            index = (index + i) % table.length; // Linear probing

            if (table[index] == null) {
                return null; // Key not found
            } else if (!table[index].isDeleted && table[index].key.equals(key)) {
                return table[index].value;
            }
        }

        return null; // Key not found after probing
    }

    public V remove(K key) {
        int index = getHash(key);

        // Using a for loop to probe for the key to remove
        for (int i = 0; i < table.length; i++) {
            index = (index + i) % table.length; // Linear probing

            if (table[index] == null) {
                return null; // Key not found
            } else if (!table[index].isDeleted && table[index].key.equals(key)) {
                V oldValue = table[index].value;
                table[index].isDeleted = true; // Mark as deleted
                size--;
                return oldValue;
            }
        }

        return null; // Key not found
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isDeleted) {
                System.out.println("Key: " + table[i].key + ", Value: " + table[i].value);
            }
        }
    }

    public static void main(String[] args) {
        HashMaps1<Boolean, Integer> h1 = new HashMaps1<>(6);
        h1.put(true, 23);
        h1.put(false, 2);
        h1.put(true, 45);
        h1.display();
        System.out.println("Get 'true': " + h1.get(true));
        System.out.println("Size: " + h1.size());

        HashMaps1<Integer, String> h2 = new HashMaps1<>(6);
        h2.put(1, "One");
        h2.put(2, "Two");
        h2.put(1, "Updated One");
        h2.remove(1);
        h2.display();
        System.out.println("Is empty: " + h2.isEmpty());
    }
}
```
---
