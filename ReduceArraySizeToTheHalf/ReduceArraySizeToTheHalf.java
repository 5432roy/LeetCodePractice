package ReduceArraySizeToTheHalf;

import java.util.HashMap;
import java.util.Arrays;

public class ReduceArraySizeToTheHalf {

    public static void main(String[] args){
        int[] case1 = {3,2,3,3,5,5,5,3,2,7};

        System.out.println(minSetSize(case1));
    }

    public static int minSetSize(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }

        int[] value = new int[map.size()];
        int i = 0;
        for(int counts : map.values()){
            value[i] = counts;
            i++; 
        }

        Arrays.sort(value);
        int sum = 0;
        int gap  = arr.length / 2;
        int index = map.size() - 1;
        while(sum < gap){
            sum += value[index];
            index--;
        }
        return map.size() - 1 - index;
    }
    
}
