import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * list of cities = [SFO, SJC, LA, RNO, AUS, LV]
 * hasFlight(SJC, LV) = true
 * hasFlight(RNO, LV) = true
 * isConnected(SJC, LV) = true
 *
 *
 * using union-find algorithm
 *
 * optimization = path compression
 */
public class ConnectivityFlights {
    List<String> list = new ArrayList<>();
    HashMap<String, String> map = new HashMap<>();
    private boolean hasFlight(String a, String b) {
        if(a.equals("SJC") && b.equals("LV"))
            return true;
        return a.equals("RNO") && b.equals("LV");
    }

    private void union(String a, String b) {
        if(hasFlight(a, b))
            map.put(a, b);
    }
    private String find(String c) {
        if(map.get(c).equals(c))
            return c;
        return find(map.get(c));
    }

    private boolean isConnected(String p, String q) {
        for(String city : list)
            map.put(city, city);
        return find(p).equals(find(q));
    }

    public static void main(String[] args) {
        ConnectivityFlights cf = new ConnectivityFlights();
        cf.list = Arrays.asList("SFO", "SJC", "LA", "RNO", "AUS", "LV");
        cf.union("SFO", "LA");
        cf.union("LA", "LV");
        System.out.println("Result: " +cf.isConnected("SFO", "LV"));
        List<List<String>> graph = new ArrayList<>();
        for(int i = 0; i < cf.list.size(); i++)
            graph.add(new ArrayList<>());
        for(int i = 0; i < cf.list.size(); i++) {
            for (int j = 0; j < cf.list.size(); j++)
                if (cf.hasFlight(cf.list.get(i), cf.list.get(j))) {
                    graph.get(i).add(cf.list.get(i));
                    graph.get(i).add(cf.list.get(j));
                }
        }
        System.out.println("Graph: "+graph);
    }

}
