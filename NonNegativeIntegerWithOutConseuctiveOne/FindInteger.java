package NonNegativeIntegerWithOutConseuctiveOne;

public class FindInteger {

    public static void main(String[] args){
        System.out.println(findInteger(4));
    }

    public static int findInteger(int num){
        int one = 0, zero = 0, temp;
        boolean isNum = true;
        for(int i = 31; i >= 0; i--){
            temp = zero;
            zero += one;
            one = temp;
            if(isNum && ((num >> i) & 1) == 1){
                zero += 1;
            }
            if(((num >> i) & 1) == 1 && ((num >> i + 1) & 1) == 1){
                isNum = false;
            }
            
        }
        return one + zero + (isNum ? 1 : 0);
    }
    
}
