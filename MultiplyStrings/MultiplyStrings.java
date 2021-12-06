package MultiplyStrings;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
       
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
    
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /*
    public String multiply(String num1, String num2){
        String res = "";
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = new char[]{'0','1','2','3','4','5','6','7','8','9'};

        int n = 0; 
        for(char ch : chars) map.put(ch, n++);

        char[] multipliers = num2.toCharArray();
        for(int i = multipliers.length - 1; i >= 0; i--){
            res = add(map, chars, res, mul(map, num1, multipliers[i], (multipliers.length - 1) - i));
        }
        
        System.out.println(add(map, chars, "12345", "234"));
        return res;
    }

    private String mul(HashMap<Character,Integer> map, String str, char ch, int s){
        String res = "";
        int overFlow = 0, multiplier = map.get(ch);
        char[] nums = str.toCharArray();
        String zeros = "0";
        
        for(int i = nums.length - 1; i >= 0; i--){
            int cur = map.get(nums[i]) * multiplier + overFlow;
            overFlow = cur / 10;
            res = cur % 10 + res;
        }

        if(overFlow > 0) res = overFlow + res;
        res = res + zeros.repeat(s); 
        System.out.println(res);
        return res;
    }

    private String add(HashMap<Character,Integer> map, char[] chars,String str1, String str2){
        if(str1.length() == 0 || str2.length() == 0) return str1.length() == 0 ? str2 : str1;

        int n = str1.length(), m = str2.length(), i = 0, overFlow = 0;
        String res = "";

        while(i < n && i < m){
            int cur = map.get(str1.charAt(n - i - 1)) + map.get(str2.charAt(m - 1 - i++)) + overFlow;
            overFlow = cur > 10 ? 1 : 0;
            res = chars[cur % 10] + res;
        }
        
        if(m > i){
            int next = map.get(str2.charAt(m - i++ - 1)) + overFlow;
            res = next % 10 + res;
            overFlow = next > 10 ? 1 : 0;
        }
        else if(n > i){
            int next = map.get(str1.charAt(n - i++ - 1)) + overFlow;
            res = next % 10 + res;
            overFlow = next > 10 ? 1 : 0;
        }

        if(overFlow > 0) res = "1" + res;
        return res;
    }
    */
    
}
