import java.util.Random;

public class DepositThread extends Thread{
    public static int j =0;
    @Override
    public void run() {

        while(j < 1000){
            synchronized (BankAccount.lock){
                Random r = new Random();
                int input = r.nextInt(100);
                j++;
                System.out.println("第" + j + "存了" + input + "元");
                BankAccount.yue += input;
                BankAccount.cun += input;
                BankAccount.lock.notify();
            }
        }
        System.out.println( "存了" + BankAccount.cun);
    }
}
