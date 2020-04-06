import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConnectRoads {

    int[][] roadsBuilding(int cities, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < cities; i++)
            graph.add(new ArrayList<>());
        for (int[] r : roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        for (int w = 0; w < graph.size(); w++) {
            List<Integer> edges = graph.get(w);
            for (int t = 0; t < graph.size(); t++) {
                if (t == w)
                    continue;
                if (!edges.contains(t)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(w);
                    temp.add(t);
                    Collections.sort(temp);
                    if (!res.contains(temp))
                        res.add(temp);
                }
            }
        }
        System.out.println("row size: "+res.size()+", col size: "+res.get(0).size());
        int[][] result = new int[res.size()][res.get(0).size()];
        for(int i = 0, r = 0; i < res.size(); i++, r++) {
            for (int j = 0, c = 0; j < res.get(i).size(); j++, c++) {
                result[r][c] = res.get(i).get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] roads = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Result : " + new ConnectRoads().roadsBuilding(4, roads));
    }

}
