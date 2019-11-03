import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class MapMerger {

    public static <K, V> Map<K, V> mergeInPlace(Map<K, V> map1, Map<K, V> map2,
                                           BinaryOperator<V> combiner) {
        Map<K, V> map3 = new HashMap<K, V>(map1);
        map2.forEach((k, v) -> map3.merge(k, v, combiner::apply));
        return map3;
    }

    public static void main(String[] args) {
        MapMerger m = new MapMerger();
        Map<Long, Integer> map1 = new HashMap<Long, Integer>();
        map1.put(1L,10);
        map1.put(2L,20);
        map1.put(3L,30);
        map1.put(4L,40);
        map1.put(5L,50);
        map1.put(6L,60);
        map1.put(7L,70);

        Map<Long, String> map3 = new HashMap<Long, String>();
        map3.put(1L,"This");
        map3.put(2L,"is");
        map3.put(3L,"Verizon");

        Map<Long, String> map4 = new HashMap<Long, String>();
        map4.put(1L,"This");
        map4.put(2L,"is");


        Map<Long, Integer> map2 = new HashMap<Long, Integer>();
        map2.put(1L,90);
        map2.put(2L,80);
        map2.put(3L,70);
        map2.put(4L,60);
        map2.put(5L,50);
        map2.put(6L,40);
        map2.put(7L,30);

        System.out.println("MAP :: "+m.mergeInPlace(map1, map2, (n1,n2) -> n1 + n2));

        System.out.println("MAP :: "+m.mergeInPlace(map1, map2, (n1,n2) -> n1 * n2));

        System.out.println("MAP :: "+m.mergeInPlace(map3, map4, (n1,n2) -> n1 + n2));
    }



}
