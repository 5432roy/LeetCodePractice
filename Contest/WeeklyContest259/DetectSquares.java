package WeeklyContest259;
import java.util.*;
public class DetectSquares {

    private TreeMap<Integer,Integer> tree;
    private HashMap<Integer,TreeMap<Integer,Integer>> map; // key is the row, value is col

    public DetectSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        map.putIfAbsent(point[0], new TreeMap<>());
        map.get(point[0]).put(point[0], tree.getOrDefault(point[0], 0) + 1);
    }
    // TODO
    public int count(int[] point) {
        int a;
        int res = 0;
        return res;
    }

    public int find(int[] point, int length){
        int res = 0;
        return res;
    }
}
