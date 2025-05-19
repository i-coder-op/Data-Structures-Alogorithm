package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LetterTileProblem {

    Set<String> set;

    public static void main(String[] args) {
        LetterTileProblem letterTileProblem = new LetterTileProblem();
        System.out.println(letterTileProblem.numTilePossibilities("AAABBC"));
    }
    public int numTilePossibilities(String tiles) {
        set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(tiles.split("")));
        compute(0, list, "");
        return set.size();
    }

    void compute(int index, ArrayList<String> tiles, String result) {
        //Base Condition
        if(tiles.isEmpty()) {
            return;
        }

        while (index < tiles.size()) {
            //Consider ith Character in result
            String og = tiles.get(index);
            result = result.concat(og);
            set.add(result);
            tiles.remove(index);

            compute(0, tiles, result);

            result = result.length() > 1 ? result.substring(0, result.length()-1) : "";
            tiles.add(index, og);
            index++;
        }
        return;
    }
}


