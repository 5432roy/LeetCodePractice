package WeeklyContest262;
import java.util.*;
public class TwoOutofThree {
    
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> set1 = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i : nums1){
            set1.add(i);
        }
        for(int i : set1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for(int i : nums2){
            set2.add(i);
        }
        for(int i : set2){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> set3 = new HashSet<>();
        for(int i : nums3){
            set3.add(i);
        }
        for(int i : set3){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i : map.keySet()){
            if(map.get(i) > 1) res.add(i);
        }
        return res;
    }
}
