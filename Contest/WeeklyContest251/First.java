package WeeklyContest251;

public class First {

    public int getLucky(String s, int k){
        char[] ch = s.toCharArray();
        int sum = 0;
        for(char cur : ch){
            int i = cur - 'a' + 1;
            sum += i / 10 + i % 10;
        }
        int times = 1;
        while(times > k){
            int newSum = 0;
            while(sum > 0){
                newSum += sum %10;
                sum /= 10;
            }
            times++;
            sum = newSum;
        }
        return sum;
    }
    
}
