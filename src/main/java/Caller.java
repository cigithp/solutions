
class Node<K,V>{
    private K key;
    private V value;
    private Node<K,V> next;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return this.key;
    }

    public void setKey(K key){
        this.key = key;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V value){
        this.value = value;
    }

    public Node<K,V> getNext(){
        return this.next;
    }

    public void setNext(Node<K,V> next){
        this.next = next;
    }
}

class MyHashMap<K,V>{

    int size = 256;
    Node<K,V>[] bucketArray = new Node[size];

    public V put(K key, V value){
        int hash = key.hashCode() % 256;
        V ret = null;
        Node<K,V> entry = new Node<K,V>(key,value);
        if(bucketArray[hash] == null){
            bucketArray[hash] = entry;
        } else {
            Node current = bucketArray[hash];
            while(current.getNext() != null){
                if(current.getKey() == key){
                    ret = (V)current.getValue();
                    current.setValue(value);
                    break;
                }
                current = current.getNext();
            }
            current.setNext(entry);
        }
        return ret;
    }

    public V get(K key){
        int hash = key.hashCode() % 256;
        if(bucketArray[hash] == null)
            return null;
        Node<K,V> current = bucketArray[hash];
        if(current.getKey() == key)
            return current.getValue();
        while(current.getNext() != null){
            if(current.getKey() == key)
                return current.getValue();
            current = current.getNext();
        }
        return null;
    }

}

public class Caller {

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> m = new MyHashMap<Integer, Integer>();

        m.put(2,2);
        m.put(3,3);
        m.put(4,4);
        m.put(5,5);
        m.put(6,6);
        m.put(7,7);
        m.put(8,8);
        m.put(9,9);
        m.put(10,10);

        System.out.println("GET 2 :"+m.get(2));

        System.out.println("GET 3 :"+m.get(3));

        System.out.println("GET 4 :"+m.get(4));

        System.out.println("GET 5 :"+m.get(5));

        System.out.println("GET 6 :"+m.get(6));



    }

}
