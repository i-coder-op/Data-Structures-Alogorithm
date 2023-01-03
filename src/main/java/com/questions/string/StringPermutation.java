package com.questions.string;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static void main(String[] args) {
        String x = "Anand";
        String y = "Shiva";

        if(x.length() == y.length()){
            Map<Character, Integer> characterIntegerMapX = new HashMap<>();
            Map<Character, Integer> characterIntegerMapY = new HashMap<>();

            for(int i=0;i<x.length();i++){
                if(!characterIntegerMapX.containsKey(x.charAt(i))){
                    characterIntegerMapX.put(x.charAt(i), 1);
                }else if(characterIntegerMapX.containsKey(x.charAt(i))){
                    int count = characterIntegerMapX.get(x.charAt(i));
                    characterIntegerMapX.put(x.charAt(i), count+1);
                }
            }

            for(int i=0;i<y.length();i++){
                if(!characterIntegerMapY.containsKey(y.charAt(i))){
                    characterIntegerMapY.put(y.charAt(i), 1);
                }else if(characterIntegerMapY.containsKey(y.charAt(i))){
                    int count = characterIntegerMapY.get(y.charAt(i));
                    characterIntegerMapY.put(y.charAt(i), count+1);
                }
            }

            int matchCountInXString = 0;
            for (Map.Entry<Character, Integer> entry : characterIntegerMapY.entrySet()){
                if(characterIntegerMapX.containsKey(entry.getKey())){
                    int count = characterIntegerMapX.get(entry.getKey());
                    if(entry.getValue() == count){
                        matchCountInXString++;
                    }
                }
            }

            if(matchCountInXString == characterIntegerMapY.size()){
                System.out.println("YES");
            }else{
                System.out.println("No");
            }
        }else{
            System.out.println("String permutation cannot be performed");
        }

    }
}
