
package WeeklyContest259;

public class First {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;

        for(String str : operations){
            for(char ch : str.toCharArray()){
                if(ch != 'X'){
                    res += ch == '+' ? 1 : -1;
                    break; 
                } 
            }
        }
        return res;
    }
}
