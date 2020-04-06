import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * generate frequent itemsets from the given pattern
 *
 * I/p: List<String> input
 * o/p: map with patterns and their frequencies
 *
 * e.g: [[apple, banana, lemon], [banana, lemon], [apple, lemon], [apple, grapes], ...]
 *
 * apple,banana,lemon   1
 * apple,banana         1
 * banana,lemon         2
 *
 */
//trying to create a dictionary
public class FrequentItemsets {
    private Map<String, Integer> freqMap;
    private TrieNode root;
    class TrieNode {
        Character val;
        boolean isWord;
        int count = 0;
        Map<Character, TrieNode> map;
        TrieNode(){}
        TrieNode(char c) {
            this.val = c;
            this.map = new HashMap<>();
            this.isWord = false;
        }
    }
    
    private void add(String pattern) {

        
    }
    
    private void search(String pattern) {
        
    }

    public FrequentItemsets() {
        this.root = new TrieNode();
        this.freqMap = new HashMap<>(); 
    }

    private void findFrequentItemsets(List<String> input) {

    }

    public static void main(String[] args) {

    }

}
