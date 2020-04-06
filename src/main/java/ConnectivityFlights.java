import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * list of cities = [SFO, SJC, LA, RNO, AUS, LV]
 * hasFlight(SJC, LV) = true
 * hasFlight(RNO, LV) = true
 * isConnected(SJC, LV) = false
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
        return true;
    }
    private void union(String a, String b) {
        if(hasFlight(a, b))
            map.put(b, a);
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
    }

}
