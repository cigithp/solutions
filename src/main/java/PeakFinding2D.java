import java.util.stream.IntStream;

/**
 * peak finding in a 2D array
 *
 *  recursive approach (selecting columns to traverse, we can select rows also)
 * 1. from 0 -> n/2 cols
 * 2. find global max -> grid[i][n/2]
 * 3. compare grid[i][n/2 - 1], grid[i][n/2], grid[i][n/2 + 1]
 * 4. choose one direction either left or right
 * 5. final grid[i][j] will be the peak in 2D
 *
 * O(m log n) where m = no of rows and n = no of cols
 */

public class PeakFinding2D {

    private int findPeak(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        int n = grid[0].length, peak = -1;
        int low = 0, high = n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int rowIndex = findPeak(getCol(grid, mid));
            if(mid == 0 && grid[rowIndex][mid] >= grid[rowIndex][mid + 1]) //check for edges
                peak = Math.max(grid[rowIndex][mid], peak);
            else if (mid == n - 1 && grid[rowIndex][mid] >= grid[rowIndex][mid - 1]) //check for edges
                peak = Math.max(grid[rowIndex][mid], peak);
            else if (grid[rowIndex][mid] >= grid[rowIndex][mid - 1] && grid[rowIndex][mid] >= grid[rowIndex][mid + 1]) //if mid element is higher than neighbors then return mid
                 peak = Math.max(grid[rowIndex][mid], peak);
            if(grid[rowIndex][mid - 1] > grid[rowIndex][mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return peak;
    }

    private int[] getCol(int[][] grid, int col) {
        return IntStream.range(0, grid.length).map(i -> grid[i][col]).toArray();
    }

    private int findPeak(int[] arr) {
        int max = Integer.MIN_VALUE, index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    private int findPeakRecursive(int[][] grid, int cols, int mid) {
        int maxIndex = findPeak(getCol(grid, mid));
        int max = grid[maxIndex][mid];
        if(mid == 0 || mid == cols - 1)
            return max;
        if(max >= grid[maxIndex][mid - 1] && max >= grid[maxIndex][mid + 1])
            return max;
        if(max < grid[maxIndex][mid - 1])
            return findPeakRecursive(grid, cols, (int) (mid - Math.ceil((double)mid / 2)));
        return findPeakRecursive(grid, cols, (int) (mid + Math.ceil((double)mid / 2)));
    }

    public static void main(String[] args) {
        int[][] grid = {{10,8,10,10}, {14,13,12,11}, {25,9,11,21}, {16,17,19,20}};
        PeakFinding2D p = new PeakFinding2D();
        System.out.println("Result = "+p.findPeak(grid));
        System.out.println("Rec result = "+p.findPeakRecursive(grid, grid[0].length, (grid[0].length - 1)/2));
    }
}
