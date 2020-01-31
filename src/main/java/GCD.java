public class GCD {

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
    }
}
