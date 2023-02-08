package WeeklyContest250;
import java.util.*;
public class Fourth {

    public static void main(String[] args){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("", 0);
        System.out.println('0' - 0);
        System.out.println('A' - 0);
        System.out.println('z' - 0);
        List<Integer> list = new ArrayList<>();
        test(list, 5);
        List<List<Integer>> l = new ArrayList<>();
        l.add(list);

        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        System.out.println(l);

        list.remove(0);

        System.out.println(l);


        System.out.println(list2);
    }

    public static void test(List<Integer> list, int i){
        if(i < 0) return;

        list.add(i);

        test(list, i - 1);
    }
    
}
