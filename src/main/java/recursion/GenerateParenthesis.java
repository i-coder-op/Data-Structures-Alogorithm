package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate all parenthesis (Leet Code/Coding Ninjas - Moderate)
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int N = 3;
        List<String> validParenthesisList = new ArrayList<>();
        generateAllValidParenthesis(N-1, N, "(", validParenthesisList);
        System.out.println("");
    }

    private static void generateAllValidParenthesis(int openBracket, int closeBracket, String validParenthesis, List<String> validParenthesisList) {
        //Base Condition
        if(openBracket == 0 && closeBracket == 0){
            validParenthesisList.add(validParenthesis);
            return;
        }

        //Induction

        if(openBracket == closeBracket){
            if(openBracket != 0){
                //Choose Open Bracket
                String newValidParenthesisWithOpenBracket = validParenthesis.concat("(");
                generateAllValidParenthesis(openBracket - 1, closeBracket, newValidParenthesisWithOpenBracket, validParenthesisList);
            }
        }else {
            if(openBracket != 0){
                //Choose Open Bracket
                String newValidParenthesisWithOpenBracket = validParenthesis.concat("(");
                generateAllValidParenthesis(openBracket - 1, closeBracket, newValidParenthesisWithOpenBracket, validParenthesisList);
            }

            if(closeBracket != 0){
                //Choose Close Bracket
                String newValidParenthesisWithCloseBracket = validParenthesis.concat(")");
                generateAllValidParenthesis(openBracket, closeBracket - 1, newValidParenthesisWithCloseBracket, validParenthesisList);
            }
        }
    }
}
