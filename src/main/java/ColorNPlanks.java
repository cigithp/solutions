/**
 * Problem : Given N planks and fixed buckets of color (R-3, G-2, B-1) color them such that no two colors are adjacent.
 *
 * Input : N, quantities of Red, Green and Blue color
 * Output : all possible combinations. eg :
 *  RGR,
 *  RGB,
 *  RBG,
 *  RBR,
 *
 *  GBR,
 *  GRB,
 *  GRG,
 *  GBG,
 *
 *  BGR,
 *  BRG
 */


import java.util.*;
public class ColorNPlanks {

    public List<List<String>> colorFence(int n, Map<String, Integer> m) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n == 0 || n < 0)
            return result;
        return colorFenceHelper(n, m, new ArrayList<String>(), result);
    }

    public List<List<String>> colorFenceHelper(int n, Map<String, Integer> m, List<String> chosen, List<List<String>> result) {
        if(chosen.size() == n) {
           //base case
            result.add(new ArrayList<String>(chosen));
        } else {
            //recursive case
            for(String key : m.keySet()) {
                if(m.get(key) > 0) {
                    m.put(key, m.get(key) - 1);
                    if(chosen.size() == 0 || !chosen.get(chosen.size() - 1).equals(key)) {
                        chosen.add(key);
                        colorFenceHelper(n, m, chosen, result);
                        chosen.remove(chosen.size() - 1);
                    }
                    m.put(key, m.get(key) + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ColorNPlanks cn = new ColorNPlanks();
        int n = 3; //number of planks
        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("Red", 3);
        m.put("Green", 2);
        m.put("Blue", 1);
        System.out.println("OUTPUT :: ----------------");
        for(List<String> list : cn.colorFence(n,m)) {
            System.out.println(list);
        }
        System.out.println("----------------");
    }



}
