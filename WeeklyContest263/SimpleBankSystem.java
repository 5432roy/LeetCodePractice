package WeeklyContest263;

public class SimpleBankSystem {
    
    long[] balance;

    public SimpleBankSystem(long[] nums) {
        balance = new long[nums.length];
        balance = nums.clone();
        for(long num : balance){
            System.out.println(num);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        System.out.println(balance[account1 - 1]);
        if(valid(account1) && valid(account2) && balance[account1 - 1] >= money){
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(valid(account)){
            balance[account - 1] += money;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(valid(account) && balance[account - 1] >= money){
            balance[account - 1] -= money;
        }
        return false;
    }

    private boolean valid(int account){
        return account > 0 && account <= balance.length; 
    }
}
