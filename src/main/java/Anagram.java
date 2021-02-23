import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Anagram {

    private static List<String> getAllSubStrings(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, "", res);
        //res = helperSubString(s);
        return res;
    }

    private static List<String> helperSubString(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = 1; j <= s.length() - i; j++) {
                String subPart = s.substring(i, i+j);
                res.add(subPart);
            }
        }
        return res;
    }

    private static void helper(String s, int start, String temp, List<String> res) {
        if(!temp.equals("") && !res.contains(temp))
            res.add(temp);
        for(int i = start; i < s.length(); i++) {
            temp += s.charAt(i);
            helper(s, i+1, temp, res);
            if(temp.length() > 1)
                temp.substring(0, temp.length() - 1);
            else
                temp = "";
        }
    }

    private static boolean isAnagram(String a, String b) {
        if(a.length() != b.length())
            return false;
        int[] arr = new int[26];
        for(char c : a.toCharArray())
            arr[c - 'a']++;
        for(char c : b.toCharArray()) {
            if(arr[c - 'a'] == 0)
                return false;
            arr[c - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println("res: " +isAnagram("ab", "bb"));
        System.out.println("res: "+getAllSubStrings("abcd"));
    }
}
