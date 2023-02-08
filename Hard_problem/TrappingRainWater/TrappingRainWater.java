package TrappingRainWater;

public class TrappingRainWater {

    public int trap(int[] height){
        return dfs(height, 0, height.length - 1, 0, 0);
    }

    private int dfs(int[] height, int head, int tail, int leftMax, int rightMax){
        if(head > tail) return 0;
        if(head == tail) return Math.max(leftMax - height[head], 0);
        leftMax = Math.max(leftMax, height[head]);
        rightMax = Math.max(rightMax, height[tail]);
        if(leftMax > rightMax){
            return dfs(height, head, tail - 1, leftMax, rightMax) + Math.max(rightMax - height[tail], 0);
        }
        return dfs(height, head + 1, tail, leftMax, rightMax) + Math.max(leftMax - height[head], 0);
    }

}
