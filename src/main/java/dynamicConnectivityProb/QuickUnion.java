package dynamicConnectivityProb;

import java.util.Scanner;

/**
 * Quick Union Data Structure
 * ******************************
 * id[i] = parent element of i
 * <p>
 * connected = check of the elements have the same root => finding out the root will need accessing all elements worst case
 * <p>
 * union = merge elements via their roots => change in one value will result in connecting multiple elements
 */
public class QuickUnion implements QUF {
    private int n;
    private int[] id;

    public QuickUnion(int n) {
        this.n = n;
        this.id = new int[n];
        for (int i = 0; i < n; i++)
            this.id[i] = i;
    }

    //recursive
    private int rootR(int i) {
        if (i == this.id[i])
            return i;
        return rootR(this.id[i]);
    }

    //iterative
    private int rootI(int i) {
        while (i != this.id[i])
            i = this.id[i];
        return i;
    }

    @Override
    public void union(int p, int q) {
        int a = rootR(p);
        int b = rootI(q);
        this.id[a] = b;
    }

    @Override
    public boolean connected(int p, int q) {
        return rootI(p) == rootR(q);
    }

    @Override
    public int find(int p) {
        return this.id[p];
    }

    @Override
    public int count() {
        int count = 0;
        for (int i = 0; i < n-1; i++)
            if (rootI(i) != rootI(i+1))
                count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        QuickUnion qu = new QuickUnion(N);
        while (s.hasNext()) {
            int p = s.nextInt();
            int q = s.nextInt();
            if (!qu.connected(p, q)) {
                System.out.println("Not Connected. Do you want to connect(y/n): ");
                String ans = s.next();
                if (ans.equalsIgnoreCase("y")) {
                    qu.union(p, q);
                    System.out.println("" + p + " -> " + q);
                }
            } else
                System.out.println("Already connected. "+"" + p + " -> " + q);
            for (int i : qu.id)
                System.out.print("\t" + i);
            System.out.println();
            System.out.println("Number of disjoint components: "+qu.count());
        }

    }
}
