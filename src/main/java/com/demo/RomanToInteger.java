package com.demo;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args){
        RomanToInteger obj = new RomanToInteger();
       /* System.out.println(obj.romanToInt("III"));
        System.out.println(obj.romanToInt("LVIII"));*/
        System.out.println(obj.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {

        HashMap<String, Integer> romanToIntMap = new HashMap<String,Integer>();
        romanToIntMap.put("I", 1);
        romanToIntMap.put("V", 5);
        romanToIntMap.put("X", 10);
        romanToIntMap.put("L", 50);
        romanToIntMap.put("C", 100);
        romanToIntMap.put("D", 500);
        romanToIntMap.put("M", 1000);

        String[] sArray = s.split("");

        int number = 0;
        String previousCharacter = "";
        for(String s1 : sArray){

            String currentCharacter = s1;

            if(("V".equalsIgnoreCase(currentCharacter) && "I".equalsIgnoreCase(previousCharacter)) ||
                    ("X".equalsIgnoreCase(currentCharacter) && "I".equalsIgnoreCase(previousCharacter))){
                number = (number + romanToIntMap.get(currentCharacter)) - 2;
            }else if(("L".equalsIgnoreCase(currentCharacter) && "X".equalsIgnoreCase(previousCharacter)) ||
                    ("C".equalsIgnoreCase(currentCharacter) && "X".equalsIgnoreCase(previousCharacter))){
                number = (number + romanToIntMap.get(currentCharacter)) - 20;
            }else if(("D".equalsIgnoreCase(currentCharacter) && "C".equalsIgnoreCase(previousCharacter)) ||
                    ("M".equalsIgnoreCase(currentCharacter) && "C".equalsIgnoreCase(previousCharacter))){
                number = (number + romanToIntMap.get(currentCharacter)) - 200;
            }else{
                number = (number + romanToIntMap.get(currentCharacter));
            }

            previousCharacter = currentCharacter;
        }

        return number;
    }
}
