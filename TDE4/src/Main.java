import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // solicitar o tamanho do conjunto de dados
        System.out.print("Digite o tamanho do conjunto de dados: ");
        int n = scanner.nextInt();

        // inicializar a ABB e a tabela hash
        BinarySearchTree bst = new BinarySearchTree();
        HashTable hashTable = new HashTable(n);

        // gerar chaves aleatórias e medir o tempo de inserção na ABB
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int key = random.nextInt(Integer.MAX_VALUE);
            bst.insert(key);
        }
        long bstInsertionTime = System.nanoTime() - startTime;

        // gerar chaves aleatórias e medir o tempo de inserção na tabela hash
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int key = random.nextInt(Integer.MAX_VALUE);
            hashTable.insert(key);
        }
        long hashInsertionTime = System.nanoTime() - startTime;

        // gerar um novo conjunto de chaves aleatórias para busca e medir o tempo na ABB
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int key = random.nextInt(Integer.MAX_VALUE);
            bst.search(key);
        }
        long bstSearchTime = System.nanoTime() - startTime;

        // medir o tempo de busca na tabela hash
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int key = random.nextInt(Integer.MAX_VALUE);
            hashTable.search(key);
        }
        long hashSearchTime = System.nanoTime() - startTime;

        // converter tempo de nanossegundos para segundos com maior precisão
        double bstInsertionSeconds = bstInsertionTime / 1_000_000_000.0;
        double hashInsertionSeconds = hashInsertionTime / 1_000_000_000.0;
        double bstSearchSeconds = bstSearchTime / 1_000_000_000.0;
        double hashSearchSeconds = hashSearchTime / 1_000_000_000.0;

        // exibir resultados
        System.out.printf("Tempo de inserção na ABB: %.9f segundos.%n", bstInsertionSeconds);
        System.out.printf("Tempo de inserção na Tabela Hash: %.9f segundos.%n", hashInsertionSeconds);
        System.out.printf("Tempo de busca na ABB: %.9f segundos.%n", bstSearchSeconds);
        System.out.printf("Tempo de busca na Tabela Hash: %.9f segundos.%n", hashSearchSeconds);

        // somar tempos e exibir
        double totalBstTime = bstInsertionSeconds + bstSearchSeconds;
        double totalHashTime = hashInsertionSeconds + hashSearchSeconds;
        System.out.printf("Tempo total na ABB (inserção + busca): %.9f segundos.%n", totalBstTime);
        System.out.printf("Tempo total na Tabela Hash (inserção + busca): %.9f segundos.%n", totalHashTime);
    }
}