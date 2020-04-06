package sorting;

/**
 *
 * sort an array h-sorted = similar to insertion instead of going 1
 *                          element back swap with 'h' elements
 *
 * best, avg and worst = quadratic
 *
 * increment sequence for h = 1. ^2 (not a good idea)
 *                            2. ^2 - 1 ok
 *                            3. 3x+1 = good one
 *                            4.
 */
public class ShellSort implements MySort<Integer>{
    @Override
    public Integer[] sort(Integer[] arr) {
        int N = arr.length;
        int h = 1;
        while(h < N/3) {
            h = 3 * h + 1;
        }
        while(h >= 1) {
            for(int i = h; i < N; i++) {
                for(int j = i; j >= h; j-=h) {
                    if(arr[j] < arr[j-h]) {
                        int swap = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = swap;
                    }
                }
            }
            h = h/3;
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,2,4,1,6,8,3,9,41,24,55,23,21,78,64,34,56,32,11,26,75,40,33,57,23};
        ShellSort sss = new ShellSort();
        Long startTime = System.currentTimeMillis();
        Integer[] res = sss.sort(nums);
        Long endTime = System.currentTimeMillis();
        System.out.println("Result: ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print("\t"+res[i]);
        }
        System.out.println();
        System.out.println("Time (in millis): "+(endTime - startTime));
    }
}
