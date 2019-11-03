import java.util.ArrayList;
import java.util.List;

/**
 * Implement a method 'find' that will find the starting index (zero based) where the second list occurs as a
 * sub-list in the first list. It should return -1 if the sub-list cannot be found.
 * Arguments are always given, not empty.

    Sample Input 1
    list1 = (1, 2, 3)
    list2 = (2, 3)

    Sample Output 1
    1
 */

public class SublistIndex {
    public int find(List<Integer> l1, List<Integer> l2){
        int index = 0;
        int i = 0, j = 0;
        boolean gotIndex = false;
        while(i < l1.size() && j < l2.size()){
            if(l1.get(i) == l2.get(j)){
                if(!gotIndex){
                    index = i;
                    gotIndex = true;
                }
                i++;
                j++;
            } else {
                i++;
            }
        }
        if(j < l2.size())
            return -1;
        return index;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(4);


        System.out.println("RESULT :: "+new SublistIndex().find(l1,l2));

    }
}
