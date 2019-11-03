import java.util.Scanner;

/**
 * Complete the function that takes an integer as its argument  and returns the encoded string in base 7 using the
 * following encoding rule:
 * base 10 0 1 2 3 4 5 6
 * base 7  0 a t l s i N
 *
 * Sample Input     1 7
 * Sample Output    1 a0
 */
public class EncodeBase7 {

    public String encodeBase7(int num){
        char[] mapping = {'0', 'a', 't', 'l', 's', 'i', 'N'};
        StringBuilder result = new StringBuilder();
        if(num == 0){
            result.append("0");
            return result.toString();
        }
        int n = Math.abs(num);
        while(n >= 1){
            result.append(mapping[n % 7]);
            n = n / 7;
        }
        if(num < 0)
            result.append("-");
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("RESULT :: "+new EncodeBase7().encodeBase7(n));
    }

}
