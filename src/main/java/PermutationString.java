
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationString {

    List<String> permute(String s) {
        if(s == null || s == "")
            return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(s, res, "", new HashSet<>());
        return res;
    }

    private void helper(String s, List<String> res, String chosen, Set<Integer> set) {
        if(chosen.length() == s.length() && !res.contains(chosen)) {
            res.add(chosen);
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            if(!set.contains(i)) {
                set.add(i);
                chosen += s.charAt(i);
                helper(s, res, chosen, set);
                chosen = chosen.substring(0, chosen.length() - 1);
                set.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        PermutationString permutationString = new PermutationString();
        System.out.println("Result: "+permutationString.permute("agfers"));
    }
}
