package sorting;

public class BubbleSort {

    private int[] sort(int[] nums) {
        int m = nums.length, count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m-1; j++) {
                if(nums[j] > nums[j+1]) {
                    count++;
                    int swap = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = swap;
                }
            }
        }
        System.out.println("Total swaps = "+count);
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {5,2,4,1,6,8,3,9,41,24,55,23,21,78,64,34,56,32,11,26,75,40,33,57,23};
        BubbleSort bss = new BubbleSort();
        Long startTime = System.currentTimeMillis();
        int[] res = bss.sort(nums);
        Long endTime = System.currentTimeMillis();
        System.out.println("Result: ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print("\t"+res[i]);
        }
        System.out.println();
        System.out.println("Time (in millis): "+(endTime - startTime));
    }
}
