package Test;

class test {
    public static void main(String[] args) {
        get_gradient_at_m(new int[]{1, 2, 3}, new int[]{1, 2, 4}, -1, 0);
    }

    private static void get_gradient_at_m(int[] x, int[] y, int m, int b) {
        double diff = 0;
        for(int i = 0; i < x.length; i++){
            diff += x[i] * (y[i] - (m * x[i] + b));
        }
        double m_gradient = -2 / x.length * diff;
        System.out.println(diff * -2 / x.length + ", " + (double)-2 / (double)x.length * diff);
    }
} 