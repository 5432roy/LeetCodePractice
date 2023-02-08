package FIndMedianFromDataStream;

public class Solution {

    public static void main(String[] args){
        MedianFinder obj = new MedianFinder();
        obj.addNum(5);
        obj.addNum(4);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }

    
}
