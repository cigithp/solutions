import java.util.TreeSet;

public class FindNthUglyNumber {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for(int i = 2; i <= n; i++) {
            long val = set.pollFirst();
            set.add(val * 2);
            set.add(val * 3);
            set.add(val * 5);
        }
        return set.first().intValue();
    }

    public static void main(String[] args) {
        FindNthUglyNumber f = new FindNthUglyNumber();
        System.out.println("Result = "+f.nthUglyNumber(10));
    }
}
