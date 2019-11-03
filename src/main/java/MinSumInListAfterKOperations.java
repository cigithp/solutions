/**
 * Operation is: for every n in input : do ceil of n/2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinSumInListAfterKOperations {

    public static int minSum(List<Integer> input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for(Integer n : input)
            pq.offer(n);
        while(k > 0) {
            Integer r = pq.poll();
            pq.offer((int)Math.ceil((double)r/2));
            k--;
        }
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(2);l.add(10);l.add(7);
        System.out.println("Sun : "+MinSumInListAfterKOperations.minSum(l, 4));
    }
}
