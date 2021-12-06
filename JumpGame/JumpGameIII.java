package JumpGame;

public class JumpGameIII {
    boolean res = false;
    public boolean canReach(int[] arr, int start){
        dfs(arr, start);
        return res;
    }

    public void dfs(int[] arr, int index){
        if(index < 0 || index >= arr.length) return;
        if(res == false){
            if(arr[index] == 0){
                res = true;
                return;
            }
            arr[index] += arr.length; 
            dfs(arr, index + arr[index]);
            dfs(arr, index - arr[index]);
        }
    }
}
