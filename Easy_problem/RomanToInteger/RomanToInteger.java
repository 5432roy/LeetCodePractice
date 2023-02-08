package RomanToInteger;

class RomanToInteger{
    public static void main(String[] args){
        String case1 = "MCMXCIV";
        System.out.println(RomanToInt(case1));
    }

    public static int RomanToInt(String s){
        int cur = 0;
        int sum = 0;
        char[] roman = {'I','V','X','L','C','D','M'};
        int[] number = {1, 5, 10, 50, 100, 500, 1000};
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = 0; j < roman.length; j++){
                if(s.charAt(i) == roman[j]){
                    sum += (j >= cur) ? number[j]: -number[j];
                    cur = Math.max(cur, j);
                    break;
                }
            }
        }
        return sum;
    }
}