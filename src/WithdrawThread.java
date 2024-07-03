import java.util.Random;

public class WithdrawThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        while(i < 1000){
            synchronized (BankAccount.lock)
            {
                Random r = new Random();
                int output = r.nextInt(100);
                if (BankAccount.yue < output) {
                    try {
                        if(DepositThread.j < 1000) {
                            BankAccount.lock.wait();
                        }else{
                            break;
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    BankAccount.yue -= output;
                    BankAccount.qu += output;
                    i++;
                    System.out.println("第" + i + "取了" + output + "元");
                }
            }
        }
        System.out.println( "存了" + BankAccount.cun);
        System.out.println( "取了" + BankAccount.qu);
        System.out.println( "余额" + BankAccount.yue);
    }
}
