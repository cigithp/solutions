package dynamicConnectivityProb;

/**
 * Weighted Quick Union Data Structure
 * ***********************************
 *
 * link the smaller tree to the larger tree, also increment size of larger tree with smaller tree => remember this is logarithmic
 * because we are dealing with size of trees = size of the larger tree DOUBLES AT MOST when we add smaller trees
 *
 * connected = log N
 *
 * union = log N
 *
 *
 * Another improvement = Path compression
 *
 * point all nodes in the path to the root - flatten the tree
 *
 */

import java.util.Scanner;

public class WQU implements QUF {

    private int n;
    private int[] id;
    private int[] size;//

    public WQU(int n) {
        this.n = n;
        this.id = new int[n];
        for (int i = 0; i < n; i++)
            this.id[i] = i;
    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        WQU wqu = new WQU(N);
        while (s.hasNext()) {
            int p = s.nextInt();
            int q = s.nextInt();
            if (!wqu.connected(p, q)) {
                System.out.println("Not Connected. Do you want to connect(y/n): ");
                String ans = s.next();
                if (ans.equalsIgnoreCase("y")) {
                    wqu.union(p, q);
                    System.out.println("" + p + " -> " + q);
                }
            } else
                System.out.println("Already connected. "+"" + p + " -> " + q);
            for (int i : wqu.id)
                System.out.print("\t" + i);
            System.out.println();
            System.out.println("Number of disjoint components: "+wqu.count());
        }

    }
}
