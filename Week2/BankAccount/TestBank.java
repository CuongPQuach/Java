public class TestBank {
    public static void main(String [] args) {
        BankAccount saving1 = new BankAccount(42431111,333.00);
        BankAccount saving2 = new BankAccount(42341222,212.00);
        BankAccount saving3 = new BankAccount(42314444,455.00);
        saving1.Deposit(3333);
        saving2.Deposit(3333);

        System.out.println(saving2.getNummberOfAccount());
        
        System.out.println(saving3.getTottalBallance());

    }
}