import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a range of numbers, count of all numbers that have unique digits
 * input: [1-20] output = 19 (as 11 has duplicate digits)
 *
 */

public class PrintUniqueDigits {

    private static List<Integer> countNumbersWithUniqueDigits(List<List<Integer>> input) {
        System.out.println("Input: "+input);
        List<Integer> res = new ArrayList<>();
        for(List<Integer> list : input) {
            int lower = list.get(0), upper =list.get(1), idx = lower;
            Set<Integer> set = null;
            int count = 0;
            while(idx <= upper) {
                int n = idx;
                set = new HashSet<>();
                int k = 0;
                while(n > 0) {
                    int digit = n % 10;
                    if(!set.contains(digit))
                        set.add(digit);
                    n = n / 10;
                    k++;
                }
                if(set.size() == k)
                    count++;
                idx++;
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);temp1.add(2000000232);
        input.add(temp1);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(9);temp2.add(1992384782);
        input.add(temp2);
        System.out.println("Result: "+PrintUniqueDigits.countNumbersWithUniqueDigits(input));
    }
}
