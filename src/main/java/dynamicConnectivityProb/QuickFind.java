package dynamicConnectivityProb;

/**
 * Quick Find Data Structure
 * **************************
 * connected is O(1) = just have to check if values are same
 *
 * union is O(N*N) = for N operations will have to access N values so N^2
 *
 * for very large N = Union will be quadratic
 */

import java.util.Scanner;

public class QuickFind implements QUF {
    private int n;
    private int[] id;

    public QuickFind(int n) {
        this.n = n;
        this.id = new int[n];
        for(int i = 0; i < n; i++)
            this.id[i] = i;
    }

    @Override
    public void union(int p, int q) {
        int a = this.id[p];
        int b = this.id[q];
        for(int i = 0; i < n; i++)
            if(this.id[i] == a)
                this.id[i] = b;
    }

    @Override
    public boolean connected(int p, int q) {
        return this.id[p] == this.id[q];
    }

    @Override
    public int find(int p) {
        return this.id[p];
    }

    @Override
    public int count() {
        int count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(this.id[i] != this.id[j])
                    count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        QuickFind qf = new QuickFind(N);
        while(s.hasNext()) {
            int p = s.nextInt();
            int q = s.nextInt();
            if(!qf.connected(p,q)) {
                System.out.println("Not Connected. Do you want to connect(y/n): ");
                String ans = s.next();
                if(ans.equalsIgnoreCase("y")) {
                    qf.union(p,q);
                    System.out.println(""+p+" -> "+q);
                }
            }
            for(int i : qf.id)
                System.out.print("\t"+i);
            System.out.println("Number of connected components: "+qf.count());
            System.out.println();
        }

    }
}
