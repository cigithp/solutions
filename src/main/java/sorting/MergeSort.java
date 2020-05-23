package sorting;

/**
 * Divide and Conquer approach.
 * best case : O(n)
 * average case : O(n log n)
 * worst case : O(n log n)
 *
 * invariant = 2 sorted arrays as input
 */
public class MergeSort {

    public void mergeSort(int[] arr, int low, int high) {
        int mid = 0;
        if(low < high) {
            // 1. find the middle element
            mid = low + (high - low) / 2;
            // 2. sort first half
            mergeSort(arr,low, mid);
            // 3. sort second half
            mergeSort(arr, mid + 1, high);
            // 4. merge halves in 2 and 3
            merge(arr, low, mid, high);
        }
    }

    public void display(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    public void merge(int[] arr, int low, int mid, int high) {
        //1. find sizes of the 2 sub arrays
        int n1 = mid - low + 1;
        int n2 = high - mid;

        // 2. create temp arrays
        int[] lowerHalf = new int[n1];
        int[] upperHalf = new int[n2];

        //3. copy into temp arrays
        for(int i = 0; i < n1; i++)
            lowerHalf[i] = arr[low + i];
        for(int j = 0; j < n2; j++)
            upperHalf[j] = arr[mid + 1 + j];

        //4. merge the temp arrays
        int i = 0, j = 0;
        int k = low;
        while(i < n1 && j < n2) {
            if(lowerHalf[i] < upperHalf[j]) {
                arr[k++] = lowerHalf[i];
                i++;
            } else {
                arr[k++] = upperHalf[j];
                j++;
            }
        }

        //copy remaining elements of lowerHalf
        while(i < n1) {
            arr[k++] = lowerHalf[i];
            i++;
        }

        //copy remaining elements of upperHalf
        while(j < n2) {
            arr[k++] = upperHalf[j];
            j++;
        }
    }

    public static void main(String[] args) {
        int[] a = {9,0,1,2,10,4,5};
        MergeSort m = new MergeSort();
        m.mergeSort(a, 0, a.length - 1);
        m.display(a);
    }





}
