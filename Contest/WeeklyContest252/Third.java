package WeeklyContest252;


public class Third {
    // not compeleted
    public static void main(String[] args){
        minimumPerimeter(100);
    }

    public static long minimumPerimeter(long neededApples) {
        long count = 0, length = 0, sum = 0;
        while(sum < neededApples){
            length += 2;
            count += 4 * (length - 1 + length) + (length + (length / 2 + 1)) * (length - (length / 2 + 1));
            sum += count;
            System.out.println(length+ ", " + count + ", "+sum);
        }
        return length * 4;
    }
    
}
