
public class BankAccount {
    public static int yue = 0;
    public static int qu = 0;
    public static int cun = 0;
    public static Object lock = new Object();

    public static void main(String[] args) {
        withdraw();
        deposit();
    }

    public static void deposit(){
        DepositThread dt = new DepositThread();
        dt.start();
    }
    public static void withdraw(){
        WithdrawThread wt = new WithdrawThread();
        wt.start();
    }
}
