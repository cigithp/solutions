
import java.util.*;

/**
 * ABC?D?E
 * ABE, ABCDE, ABCE, ABDE
 */
public class OptionalCharInString {
    public static void main(String[] args) {
        System.out.println("Result: " +OptionalCharInString.getCombinationsString("ABC?D?E"));
    }

    private static List<String> getCombinationsString(String s) {
        Set<String> uniqueComb = new HashSet<>();
        int n = s.length() - 1, i = 0;
        while(i < n) {
            char key = s.charAt(i++);
            if(key == '?') {
                String t = s.substring(0,i-1).replaceAll("\\?", "");
                String t1 = s.substring(0,i-2).replaceAll("\\?", "");
                if(!uniqueComb.contains(t)) uniqueComb.add(t);
                if(!uniqueComb.contains(t1)) uniqueComb.add(t1);
            }
        }
        return new ArrayList<>(uniqueComb);
    }
}
