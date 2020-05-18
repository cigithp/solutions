
import java.util.HashSet;
import java.util.Set;

/**
 * ABC = A, B, C, AB, ABC, BAC, BA, BC, CAB, CA, CB
 */
public class AllCombinationsString {
    public static void main(String[] args) {
        AllCombinationsString allCombinationsString = new AllCombinationsString();
        System.out.println("Result: " +allCombinationsString.listCombinations("ABC"));
    }

    private Set<String> listCombinations(String s) {
        Set<String> res = new HashSet<>();
        helper(s, res, "", new HashSet<>());
        return res;
    }

    private void helper(String s, Set<String> res, String chosen, Set<Character> characterSet) {
        if(chosen.length() > s.length())
            return;
        if(!chosen.equals("") && !res.contains(chosen))
            res.add(chosen);
        for(int i = 0; i < s.length(); i++) {
            if(!characterSet.contains(s.charAt(i))) {
                chosen += s.charAt(i);
                characterSet.add(s.charAt(i));
                helper(s, res, chosen, characterSet);
                if(chosen.length() > 1)
                    chosen = chosen.substring(0, chosen.length() - 1);
                else
                    chosen = "";
                characterSet.remove(s.charAt(i));
            }
        }
    }

}
