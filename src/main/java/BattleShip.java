import java.util.HashMap;

/**
 *
 * Given N = 12, S = "1A 2A,12A 12A" and T = "12A", your function should return "1,0", because one
 * ship was hit and sunk.
 * Assume that:
 *
 * N is an integer within the range [1..26];
 * string S contains the descriptions of rectangular ships of area not greater than 4 cells;
 * there can be at most one ship located on any map cell (ships do not overlap);
 * each map cell can appear in string T at most once;
 * string S and string T contains only valid positions given in specified format.
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the
 * assessment.
 *
 *
 */

public class BattleShip {
    public String solution(int N, String S, String T) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> hitCounter = new HashMap<>();
        int sunk = 0, hit = 0;
        String[] ships = S.split(",");
        for(int i = 0; i < ships.length; i++) {
            String[] coord = ships[i].split(" ");
            hitCounter.put("S"+i, coord.length);
            for(String co : coord) {
                if(map.containsKey(co)) {
                    return "";
                }
                map.put(co, "S"+i);
            }
        }
        String[] hits = T.split(" ");
        for(String h : hits) {
            if(map.containsKey(h)) {
                //ship is hit
                String ship = map.get(h);
                if(hitCounter.get(ship) == 0) {
                    sunk++;
                    continue;
                }
                hit++;
                hitCounter.put(ship, hitCounter.get(ship) - 1);
            }
        }
        return "" + sunk + ", "+hit;
    }

    public static void main(String[] args) {
        BattleShip bs = new BattleShip();
        //N = 4, S = "1B 2C,2D 4D" and T = "2B 2D 3D 4D 4A"
        System.out.println("Result: "+bs.solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));

    }
}
