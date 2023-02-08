package IntervalListIntersections;
import java.util.*;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] nums1, int[][] nums2){
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        ArrayList<int[]> list = new ArrayList<>();

        while(i < n && j < m){
            if(nums1[i][0] < nums2[j][0]){
                while(j < m && nums1[i][1] >= nums2[j][1]){
                    list.add(new int[]{nums2[j][0], nums2[j][1]});
                    j++;
                }
                if(j < m && nums1[i][1] >= nums2[j][0])
                    list.add(new int[]{nums2[j][0], nums1[i][1]});
                i++;
            }
            else {
                while(i < n && nums1[i][1] <= nums2[j][1]){
                    list.add(new int[]{nums1[i][0], nums1[i][1]});
                    i++;
                }
                if(nums1[i][0] <= nums2[j][1])
                    list.add(new int[]{nums1[i][0], nums2[j][1]});
                j++;
            }
        }
        // time consuming
        /*
        int[][] res = new int[list.size()][2];
        for(int k = 0; k < list.size(); k++){
            res[k] = list.get(k);
        }
        */
        // more efficient
        return list.toArray(new int[list.size()][2]);
    }
    
}
