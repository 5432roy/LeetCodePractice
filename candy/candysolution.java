package candy;

public class candysolution {
    public static void main(String[] args){
        int[] case1 = {1,2,3,3,3,2,1};
        int[] case2 = {1,0,3};
        candy(case1);
        candy(case2);
    }
    public static void candy(int[] ratings){
        int sum = ratings.length, num = 0;
        int[] candys = new int[ratings.length];
        for(int i = 1; i < ratings.length; i++){
            boolean bigger = ratings[i] > ratings[i-1];
            if(bigger){
                num++;
                candys[i] = num;
                sum += num;
            }
            if(!bigger) num = 0;
        }
        num = 0;
        for(int i = ratings.length - 2; i >= 0; i--){
            boolean bigger = ratings[i] > ratings[i+1];
            if(bigger){
                num++;
                if(candys[i] < num){
                    sum = sum + num - candys[i];
                    candys[i] = num;
                }
            }
            if(!bigger) num = 0;
        }
        for(int i = 0; i< ratings.length; i++){
            System.out.print(candys[i]+", ");
        }
        System.out.println(sum);
    }
}
/*
    public static int candy(int[] ratings){
        int length = ratings.length, sum = ratings.length, head = 0;
        int current = 0, trend = 0;
        for(int i = 1; i < length ; i++){
            if(ratings[i] > ratings[i-1]) current = 1;
            if(ratings[i] < ratings[i-1]) current = -1;
            if(ratings[i] == ratings[i-1]) current = 0;
            if(i == 1) trend = current;

            if(trend == 0) trend = current;
            if(i == length - 1 && trend != current && current != 0) sum++;
            if(current != trend || current == 0){
                 i+", "+head+", "+current+", "+trend);
                sum += (i-head)*(i-head-1)/2;
                head = i; 
                trend = current;
            }
            if(i == length - 1) sum += (i-head)*(i-head+1)/2;
        }
        return sum;
    }
*/
