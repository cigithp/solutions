import java.util.ArrayList;
import java.util.List;

/**
 * print all sublists of [Cigith, Pratik, Adi, Kondu]
 *
 * output will be :     [Cigith, Pratik, Adi, Kondu],
 *                      [Cigith, Pratik, Adi],
 *                      [Cigith, Pratik, Kondu],
 *                      [Cigith, Adi, Kondu],
 *                      [Cigith, Kondu],
 *                      [Cigith, Pratik],
 *                      [Cigith, Adi],
 *                      [Cigith],
 *                      [],
 *                      [Pratik, Adi, Kondu],
 *                      [Pratik, Adi],
 *                      [Pratik,Kondu],
 *                      [Adi, Kondu],
 *                      [Kondu],
 *                      [Pratik],
 *                      [Adi]
 *
 */
public class Sublists {

    public List<List<String>> sublists(List<String> input){
        List<List<String>> result = new ArrayList<List<String>>();
        sublistsHelper(input, new ArrayList<>(), result, 0);
        return result;
    }

    public void sublistsHelper(List<String> input, List<String> chosen, List<List<String>> result, int start) {
        //System.out.println("sublistsHelper(input ::"+input+", chosen ::"+chosen+", result ::"+result+", start ::"+start+")");
        if(!result.contains(chosen)) {
            //base case
            result.add(new ArrayList<>(chosen));
        }
            //recursive case
            for(int i = start; i < input.size(); i++) {
                String temp = input.get(i);
                chosen.add(temp);
                sublistsHelper(input, chosen, result, i+1);
                chosen.remove(chosen.size() - 1);
            }
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();
        input.add("Cigith");
        input.add("Adi");
        input.add("Pratik");
        input.add("Kondu");
        System.out.println("Result ::"+new Sublists().sublists(input));
    }
}
