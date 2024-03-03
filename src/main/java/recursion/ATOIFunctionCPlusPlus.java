package recursion;

public class ATOIFunctionCPlusPlus {
    public static void main(String[] args) {
        String s1 = "-0abr032";
        int number = atoi(s1);
        System.out.println(number);
    }

    private static int atoi(String str) {
        str = str.trim();

        String temp = "";
        for (int i=0;i<str.length();i++){
            if(i == 0 && str.charAt(i) == '-'){
                temp = temp.concat(String.valueOf(str.charAt(i)));
                continue;
            }
            if(i != 0 && str.charAt(i) == '-'){
                return 0;
            }
            if(Character.isDigit(str.charAt(i))){
                if(Integer.parseInt(String.valueOf(str.charAt(i))) > 0 && Integer.parseInt(String.valueOf(str.charAt(i))) < 10){
                    temp = temp.concat(String.valueOf(str.charAt(i)));
                }
            }else{
                break;
            }
        }
        if(temp.length() == 1 && temp.contains("-")){
            return 0;
        }
        if(!temp.isBlank()){
          return Integer.parseInt(temp);
        }
        return 0;
    }
}
