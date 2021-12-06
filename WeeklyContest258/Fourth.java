package WeeklyContest258;
import java.util.*;
//not compeleted
public class Fourth {
    int[] res;
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = nums.length;
        res = new int[n];
        HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.putIfAbsent(parents[i], new ArrayList<>());
            tree.get(parents[i]).add(i);
            list.add(nums[i]);
        }
        for(int i = 0; i < n; i++){
            subTree(tree, list, nums, i);
        }
        return res;
    }

    public void subTree(HashMap<Integer, ArrayList<Integer>> tree, List<Integer> list, int[] nums, int node){
        if(res[node] != 0) return;
        if(!tree.containsKey(node)){
            res[node] = nums[node] == 1 ? 2 : 1;
            return;
        }
        list.remove(new Integer(nums[node]));
        for(int i : tree.get(node)){
            subTree(tree, list, nums, i);
        }
        list.add(nums[node]);
        int i = 1;
        while(list.contains(i)){
            i++;
        }
        res[node] = i;
    }
    
}
