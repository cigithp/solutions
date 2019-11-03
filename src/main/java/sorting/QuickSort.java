package sorting;

/**
 * Divide and Conquer approach
 * best case : O(n)
 * average case : O(n log n)
 * worst case : O(n^2)
 *
 * even though the worst case is O(n^2) quicksort is preferred as against merge sort since purely based on number of comparisons and swaps of elements, quicksort
 * wins.
 * it is in-place
 * the selection of the pivot can improve the performance. if the pivot is randomly selected, quicksort performs efficiently
 *
 */
public class QuickSort {

    int[] input = {5,9,2,3,10,1,7,6};

    public void quickSort(int low, int high){
        if(low > high)
            return;
        else{
            int q = partition(low,high);
            //call quickSort(low, q-1)
            quickSort(low, q-1);
            //call quickSort(q+1, high)
            quickSort(q+1, high);
        }
    }

    public int partition(int low, int high){
        int pivot = input[high];
        int i = low - 1;
        for(int j = low; j <= high - 1; j++){
            if(input[j] <= pivot){
                i++;
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
            }
        }

        //place the pivot in between the two partitions

        //1. move the elements to the right most edge
        for(int j = high; j >= i + 2; j--)
            input[j] = input[j-1];

        //2. place the pivot element
        input[i+1] = pivot;

        //return the index of the pivot element
        return i+1;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int low = 0, high = q.input.length-1;
        q.quickSort(low,high);
        System.out.println();
        for(int i : q.input)
            System.out.print(i+" ");
    }

}
