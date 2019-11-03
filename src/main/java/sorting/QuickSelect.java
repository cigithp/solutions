package sorting;

/**
 * selection algorithm
 * selection algos are modified sorting algorithms. this particular algorithm is modified quicksort
 * time complexity : O(n) where n = number of elements
 *
 * used to find the kth smallest or largest element in the array
 */
public class QuickSelect {

    public int quickSelect(int[] input, int low, int high, int k){
        if(low > high){
           //base case
            return Integer.MIN_VALUE;

        } else {
            //recursive case
            int pivotIndex = partition(input, low, high);
            if(pivotIndex == k)
                return input[k];
            else if(pivotIndex <= k)
                return quickSelect(input, pivotIndex + 1, high, k);
            else
                return quickSelect(input, low, pivotIndex - 1, k);
        }
    }

    public int partition(int[] input, int low, int high){
        int pivot = input[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(input[j] < pivot){
                i++;
                swap(input, i, j);
            }
        }
        swap(input, ++i, high);
        return i;
    }

    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void main(String[] args) {
        int[] input = {5,9,2,3,10,1,7,6};
        int k = 1;
        System.out.println("Res : "+new QuickSelect().quickSelect(input, 0, input.length - 1, input.length - k));
    }


}
