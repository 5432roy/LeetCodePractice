package Easy_problem;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int index = 0;
        if(arr.length < 3) return false;
        while(index < arr.length - 1){
            if(arr[index] < arr[index + 1]) index++;
            else if(arr[index] == arr[index + 1]) return false;
            else break;
        }
        if(index == arr.length - 1 || index == 0) return false;
        while(index < arr.length - 1){
            if(arr[index] > arr[index + 1]) index++;
            else return false;
        }
        
        return true;
    }
}
