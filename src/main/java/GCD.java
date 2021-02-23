public class GCD {

    /**
     * the parameters preferably in increasing order
     * if the parameters are in decreasing order then additional cycles required
     *
     * e.g: a=22, b=77 => gcd(22, 77) => gcd(11, 22) => gcd(0, 11) => 11
     *      a=77, b=22 => gcd(77,22) => gcd(22, 77) => gcd(11, 22) => gcd(0, 11) => 11
     *
     * @param a
     * @param b
     * @return
     */
    static int gcd(int a, int b) {
        if(a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int findGCD(int[] arr) {
        int result = arr[0];
        for(int n : arr) {
            result = gcd(n, result);
            if(result == 1)
                return 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("GCD : "+findGCD(new int[]{2,4,6,8,10}));
        System.out.println("GCD : "+findGCD(new int[]{11,13,17,19,23}));
        System.out.println("GCD : "+findGCD(new int[]{2000000000,1450000000}));
    }
}
