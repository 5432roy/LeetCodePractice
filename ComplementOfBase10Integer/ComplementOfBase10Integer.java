package ComplementOfBase10Integer;

public class ComplementOfBase10Integer {

    public static void main(String[] args){
        int n = 200;
        System.out.println(bitwiseComplement(n));
    }
    
    public static int bitwiseComplement(int n){
        int sum = 0;
        double power = 0;

        if(n == 0) return 1;

        while(n > 0){
            int current = (int)Math.pow(2,power);
            int mudulo = n % 2;

            n = (n - mudulo) / 2;
            
            if(mudulo == 0) sum += current; 

            power++;
        }
        return sum;
    }

    
    
}
