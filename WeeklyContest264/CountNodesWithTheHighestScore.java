package WeeklyContest264;
import java.util.*;
public class CountNodesWithTheHighestScore {
    public int countHighestScoreNodes(int[] parents) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = parents.length;
        int[] size = new int[n];

        for(int i = 1; i < n; i++){
            map.putIfAbsent(parents[i], new ArrayList<>());
            map.get(parents[i]).add(i);
        }

        for(int i = 0; i < n; i++){
            size[i] = getSize(map, size, i);
        }
        TreeMap<Long,Integer> count = new TreeMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(i)){

            long temp = Math.max(1, (n - size[i]));
            temp *= size[map.get(i).get(0)];
            if(map.get(i).size() > 1){
                temp *= size[map.get(i).get(1)];
                count.put(temp, count.getOrDefault(temp, 0) + 1);
                continue;
            }
            count.put(temp, count.getOrDefault(temp, 0) + 1);
            }
            else count.put((long)n - 1, count.getOrDefault((long)n - 1, 0) + 1);
        }
        System.out.println(count.toString());
        System.out.println(Arrays.toString(size));

        return count.lastEntry().getValue();     
    }

    private int getSize(HashMap<Integer, List<Integer>> map, int[] size, int cur){
        if(size[cur] != 0) return size[cur];
        if(!map.containsKey(cur)) return size[cur] = 1;
        int count = 0;
        for(int i : map.get(cur)){
            count += getSize(map, size, i);
        }
        return count + 1;
    }
    
}
