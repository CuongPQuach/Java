import java.util.ArrayList;

public class BankAccount {
    private static int numberofaccount = 0;
    private static double tottalballance = 0.00;
    private int Accountnumber;
    private double Accountballance;

    public BankAccount (
         int Accountnumber,
         double Accountballance
    ) {
        this.Accountnumber = Accountnumber;
        this.Accountballance = Accountballance;
        this.numberofaccount = setNumberOfAccount();
        this.tottalballance = setTottalBallance(this.Accountballance);
    }

    //  getter
    public int getAccountNumber() {
        return Accountnumber;
    }
    public double getAccountBallance(){
        return Accountballance;
    }
    public int getNummberOfAccount () {
        return numberofaccount;
    }
    public double getTottalBallance () {
        return tottalballance;
    }


    // Setter
    // for class 
    public int setNumberOfAccount() {
        this.numberofaccount ++;
        return numberofaccount;
    }
    public double setTottalBallance (double currentballance) {
        this.tottalballance = this.tottalballance + currentballance;
        return tottalballance;
    }


    // for instance 
    public void Deposit (double deposit) {
        this.Accountballance = this.Accountballance + deposit;
        this.tottalballance = this.tottalballance + deposit;
    }
    public void Withdraw (double withdraw ) {
        if (this.Accountballance >= withdraw){
        this.Accountballance = this.Accountballance - withdraw;
        this.tottalballance = this.tottalballance - withdraw;
        } else {
            System.out.println("Not Enough Fun");
        }
    }
}