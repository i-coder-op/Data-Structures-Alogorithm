package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequences {
    public static void main(String[] args) {
        String s = "wyufuvne";
        generateSubsequences(s);
    }

    private static List<String> generateSubsequences(String s) {
        List<String> subSequenceList = new ArrayList<>();
        subSequenceList.add("");

        getSubsequences(s, "", subSequenceList);
        return subSequenceList;
    }

    private static void getSubsequences(String inputString, String outputStringSubsequence, List<String> subSequenceList) {
        //Base Condition
        if(inputString.length() == 0){
            if(!subSequenceList.contains(outputStringSubsequence)){
                subSequenceList.add(outputStringSubsequence);
            }
            return;
        }

        //Induction
        //Choose first alphabet
        String finalOutputSubSequence = outputStringSubsequence.concat(String.valueOf(inputString.charAt(0)));
        String newInputString = removeFirstChar(inputString);
        getSubsequences(newInputString, finalOutputSubSequence, subSequenceList);

        //Do not choose first alphabet
        String newInputString1 = removeFirstChar(inputString);
        getSubsequences(newInputString1, outputStringSubsequence, subSequenceList);
    }

    private static String removeFirstChar(String s) {
        if(s.length() == 1){
            return "";
        }
        String temp[] = s.split("");
        String newS = "";
        for (int i=1;i< temp.length;i++)
            newS= newS.concat(temp[i]);
        return  newS;
    }
}
