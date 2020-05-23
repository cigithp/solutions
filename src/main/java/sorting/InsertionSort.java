package sorting;

/**
 * already sorted - linear - best case
 * partially sorted/not sorted  - quadratic
 *
 * improvement = do a binary search for comparisons
 * n logn for compares, n*n for sorts
 *
 * invariant : 1. elements to the left of pointer (including pointer) are in order
 *             2. elements to the right are not yet seen
 */
public class InsertionSort implements MySort<Integer>{
    @Override
    public Integer[] sort(Integer[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    int swap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = swap;
                } else
                    break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,2,4,1,6,8,3,9,41,24,55,23,21,78,64,34,56,32,11,26,75,40,33,57,23};
        InsertionSort iss = new InsertionSort();
        Long startTime = System.currentTimeMillis();
        Integer[] res = iss.sort(nums);
        Long endTime = System.currentTimeMillis();
        System.out.println("Result: ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print("\t"+res[i]);
        }
        System.out.println();
        System.out.println("Time (in millis): "+(endTime - startTime));
    }
}
