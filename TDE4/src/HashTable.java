import java.util.*;
import java.util.concurrent.TimeUnit;

// classe para tabela hash com encadeamento
class HashTable {
    private LinkedList<Integer>[] table;
    private int size;

    HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // função de hash
    private int hash(int key) {
        return Math.abs(key % size);
    }

    // inserir na tabela hash
    void insert(int key) {
        int hashIndex = hash(key);
        table[hashIndex].add(key);
    }

    // buscar na tabela hash
    boolean search(int key) {
        int hashIndex = hash(key);
        return table[hashIndex].contains(key);
    }
}