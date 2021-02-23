import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

    class Node {
        K key;
        V value;
        Node next, prev;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<K, Node> map = new HashMap<>();
    Node head, tail = null;

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private void setHead(Node node) {
        if(head == null && tail == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    private void remove(Node node) {
        if(head == node && tail == node) {
            head = tail = null;
            return;
        }
        if(head == node) {
            head = head.next;
            return;
        }
        if(tail == node) {
            tail = tail.prev;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add(K k, V v) {
        if(map.containsKey(k)) {
            Node node = map.get(k);
            node.value = v;
            remove(node);
            setHead(node);
        } else {
            Node n = new Node(k, v);
            if(map.size() == capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            map.put(k, n);
            setHead(n);
        }
    }

    public V get(K k) {
        if(!map.containsKey(k))
            return null;
        Node n = map.get(k);
        remove(n);
        setHead(n);
        return n.value;
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(2);
        cache.add("1", "1");
        cache.add("2", "2");
        cache.add("3", "3");
        cache.add("4", "4");
        System.out.println(""+cache.get("1")+", "+cache.get("2")+"," +
                " "+cache.get("3")+", "+cache.get("4"));
    }
}
