import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * generate frequent itemsets from the given pattern
 *
 * I/p: List<List<String>> input, pattern = 2 or more itemsets
 * o/p: map with patterns and their frequencies
 *
 * e.g: [[apple, banana, lemon], [banana, lemon], [apple, banana], [apple, grapes], ...]
 *
 * apple,banana,lemon   1
 * apple,banana         2
 * banana,lemon         2
 *
 */
public class FrequentItemsets {
    private TrieNode root;
    class TrieNode {
        String word;
        Map<String, TrieNode> children;
        int count = 0;
        TrieNode() {
            this.children = new HashMap<>();
        }
    }
    
    private void add(List<String> items) {
        TrieNode node = root;
        for(String item : items) {
            Map<String, TrieNode> children = node.children;
            if(!children.containsKey(item))
                children.put(item, new TrieNode());
            children.get(item).count++;
            node = children.get(item);
        }
    }

    private Map<String, Integer> dfs(TrieNode node, String items, Map<String,
            Integer> freqMap) {
        if(node == null)
            return freqMap;
        Map<String, TrieNode> neighbors = node.children;
        for(Map.Entry<String, TrieNode> entry : neighbors.entrySet()) {
            items += entry.getKey();
            freqMap.put(items, entry.getValue().count);
            dfs(entry.getValue(), items += ",", freqMap);
            items = "";
        }
        return freqMap;
    }

    public FrequentItemsets() {
        this.root = new TrieNode();
    }

    private void findFrequentItemsets(List<List<String>> input) {
        for(List<String> pattern : input)
            add(pattern);
        Map<String, Integer> frequentItemSets = dfs(root, "", new HashMap<>());
        System.out.println("Frequent Itemsets -->");
        for(Map.Entry<String, Integer> entry : frequentItemSets.entrySet()) {
            if(entry.getKey().split(",").length >= 2)
                System.out.println(entry);
        }
    }

    public static void main(String[] args) {
        FrequentItemsets fi = new FrequentItemsets();
        List<List<String>> input = new ArrayList<>();
        List<String> pattern1 = new ArrayList<>();
        pattern1.add("apple");pattern1.add("banana");pattern1.add("lemon");
        List<String> pattern2 = new ArrayList<>();
        pattern2.add("apple");pattern2.add("lemon");pattern2.add("banana");
        List<String> pattern3 = new ArrayList<>();
        pattern3.add("banana");pattern3.add("lemon");
        List<String> pattern4 = new ArrayList<>();
        pattern4.add("apple");pattern4.add("grapes");pattern4.add("banana");
        List<String> pattern5 = new ArrayList<>();
        pattern5.add("apple");pattern5.add("lemon");
        List<String> pattern6 = new ArrayList<>();
        pattern6.add("apple");pattern6.add("grapes");
        input.add(pattern1);input.add(pattern2);input.add(pattern3);input.add(pattern4);input.add(pattern5);input.add(pattern6);
        fi.findFrequentItemsets(input);
    }

}
