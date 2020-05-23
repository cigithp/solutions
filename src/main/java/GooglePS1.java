import java.util.*;

/**
 *
 *
 *
 * You are given an array A of distinct integers, you have to return another array B which transforms the first array such
 * that the minimum element in the new array is 1 and all the other elements maintain their relative ordering
 * i.e. if A[i] > A[j] then it should also be that B[i] > B[j] and similarly for other elements.
 * Also, the maximum number in B should be minimized. Better explanation of this question can be found here.
 *
 * Input: [4, 2, 3, 7]
 * Output: [3, 1, 2, 4]
 *
 * Input: [-4, -2, -3, -7]
 * Output: [2, 4, 3, 1]
 * Follow ups:
 *
 * What if the elements are not distinct?
 * Second question: You have to perform the same operation on a 2D array of distinct elements.
 * What if the matrix has duplicates?
 * Input:
 * 1 5 6
 * 4 3 2
 * 8 7 9
 *
 * Output:
 * 1 3 4
 * 3 2 1
 * 5 4 6
 *
 */
public class GooglePS1 {

    class Data{
        int val;
        int position;
        Data(int val, int position) {
            this.val = val;
            this.position = position;
        }
    }
    //with duplicates in the list
    private List<Integer> transformList2(List<Integer> input) {
        if(input == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(int i = 0; i < input.size(); i++)
            pq.offer(new Data(input.get(i), i));
        int[] result = new int[input.size()];
        int rank = 1;
        while(!pq.isEmpty()) {
            Data d = pq.poll();
            result[d.position] = rank++;
        }
        for(int n : result)
            res.add(n);
        return res;
    }

    //distinct elements in the list
//    private List<Integer> transformList(List<Integer> input) {
//        if(input == null)
//            return new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//        int[] result = new int[input.size()];
//        int index = 1;
//        Map<Integer, Integer> map = new TreeMap<>();
//        for(int i = 0; i < input.size(); i++)
//            map.put(input.get(i), i);
//        for(Map.Entry<Integer, Integer> entry : map.entrySet())
//            result[entry.getValue()] = index++;
//        for(int n : result)
//            res.add(n);
//        return res;
//    }

    public static void main(String[] args) {
        GooglePS1 gps = new GooglePS1();
        //System.out.println("Result = "+gps.transformList(Arrays.asList(-4, -2, -3, -7)));
        System.out.println("Result with dups = "+gps.transformList2(Arrays.asList(-4,-2,-2,-7)));
    }


}
