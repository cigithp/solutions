import java.util.ArrayList;
import java.util.List;

/**
 * 1. Print all possible outcomes of rolling the given number of six-sided dice in [#,#,#] format
 * 2. Accepts a desired sum and prints out only the combinations that add upto that sum
 */
public class DiceRolls {

    public void diceRolls(int dice) {
        List<Integer> chosen = new ArrayList<Integer>();
        diceRollsHelper(dice, chosen);
    }

    public void diceRollsHelper(int dice, List<Integer> chosen) {
        if(dice == 0) {
            //base case
            System.out.println(chosen);
        } else {
            //recursive case
            for(int i = 1; i <= 6; i++) {
                //choose
                chosen.add(i);

                //explore
                diceRollsHelper(dice - 1, chosen);

                //un-choose
                chosen.remove(chosen.size() - 1);
            }

        }

    }

    public void diceRollsSum(int dice, int target) {
        List<Integer> chosen = new ArrayList<Integer>();
        diceRollsSumHelper(dice, chosen, target, 0);
    }

    /**
     *
     * @param chosen
     * @return
     *
     * this is not a good idea. looping thru entire list for just the sum
     */
    public int addAll(List<Integer> chosen) {
        int sum = 0;
        for(int n : chosen)
            sum += n;
        return sum;
    }

    public void diceRollsSumHelper(int dice, List<Integer> chosen, int target, int sumSoFar) {
        //System.out.println("diceRollsSumHelper (dice : "+dice+", chosen : "+chosen+", target : "+target+")");
        //recursive case
        if(dice == 0) {
            //base case
            if(sumSoFar == target)
                System.out.println(chosen);
        } else {
            for (int i = 1; i <= 6; i++) {
                //to eliminate bad decision trees
                int min = sumSoFar + i + (dice - 1);
                int max = sumSoFar + i + 6 * (dice - 1);
                //if target lies between the min and max values then only proceed
                if(min <= target && target <= max) {
                    //choose
                    chosen.add(i);

                    //explore
                    diceRollsSumHelper(dice - 1, chosen, target, sumSoFar + i);

                    //un-choose
                    chosen.remove(chosen.size() - 1);
                }
            }
        }
    }


    public static void main(String[] args) {
        //new DiceRolls().diceRolls(3);
        new DiceRolls().diceRollsSum(3, 10);

    }


}
