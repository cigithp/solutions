package sorting;

/**
 * best, worst, avg case : quadratic
 *
 * invariant : 1. elements to the left are fixed and in asc order
 *             2. no entry to right of pointer is smaller than to left
 */
public class SelectionSort implements MySort<Integer>{
    @Override
    public Integer[] sort(Integer[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = i;//min index of the element
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(arr[i] > arr[min]) {
                int swap = arr[i];
                arr[i] = arr[min];
                arr[min] = swap;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,2,4,1,6,8,3,9,41,24,55,23,21,78,64,34,56,32,11,26,75,40,33,57,23};
        SelectionSort ss = new SelectionSort();
        Long startTime = System.currentTimeMillis();
        Integer[] res = ss.sort(nums);
        Long endTime = System.currentTimeMillis();
        System.out.println("Result: ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print("\t"+res[i]);
        }
        System.out.println();
        System.out.println("Time (in millis): "+(endTime - startTime));
    }
}
