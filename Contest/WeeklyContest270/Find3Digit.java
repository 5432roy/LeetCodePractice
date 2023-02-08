package WeeklyContest270;
import java.util.*;
public class Find3Digit {

    public int[] findEvenNumbers(int[] digits) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] options = new int[10];
        for(int i : digits){
            options[i]++;
        }

        for(int i = 0; i < 5; i++){
            if(options[i * 2] > 0){
                options[i]--;
                add(res, digits, 1, i);
                options[i]++;
            }
        }
        Collections.sort(res);
        return res.stream().mapToInt(i->i).toArray();
    }

    private void add(ArrayList<Integer> res, int[] options, int i, int cur){
        for(int digit = 0; digit < 10; digit++){
            if(options[digit] > 0){
                options[digit]--;
                last(res, options, 2, cur + digit * 10);
                options[digit]++;
            }
        }
    }

    private void last(ArrayList<Integer> res, int[] options, int i, int cur){
        for(int digit = 1; digit < 10; digit++){
            if(options[digit] > 0){
                res.add(digit * 100 + cur);
            }
        }
    }
    
}
