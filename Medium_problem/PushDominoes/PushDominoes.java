package PushDominoes;

public class PushDominoes {

    public String pushDominoes(String str){
        char[] arr = str.toCharArray();
        int length = arr.length;
        int[] tendency = new int[length];

        for (int i = 0, tend = 0; i < length; ++i) {
            if (arr[i] == 'R') tend = length;
            else if (arr[i] == 'L') tend = 0;
            else tend = Math.max(tend - 1, 0);
            tendency[i] = tend;
        }

        for (int i = length-1, tend = 0; i >= 0; --i) {
            if (arr[i] == 'L') tend = length;
            else if (arr[i] == 'R') tend = 0;
            else tend = Math.max(tend - 1, 0);
            tendency[i] = -tend;
        }

        StringBuilder ans = new StringBuilder();
        for (int tend: tendency)
            ans.append(tend > 0 ? 'R' : tend < 0 ? 'L' : '.');

        return ans.toString();
    }
}
