package ComplexNumberMultiplication;

public class ComplexNumberMultiplication {

    public String complexNumberMultiplication(String num1, String num2){
        String[] first = num1.split("\\+|i"), second = num2.split("\\+|i");
        int real1 = Integer.parseInt(first[0]), img1 = Integer.parseInt(first[1]);
        int real2 = Integer.parseInt(second[0]), img2 = Integer.parseInt(second[1]);

        int real = real1 * real2 - img1 * img2;
        int img = real1 * img2 + real2 * img1;
        return real + "+" + img + "i";
    }
    
}
