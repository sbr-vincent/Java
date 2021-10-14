import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;

    private static int numOfAccounts = 0;
    private static double total = 0;

    public BankAccount(){
        checkingBalance = 0;
        savingBalance = 0;
        numOfAccounts++;
    }

    public static int accountCount() {
        return numOfAccounts;
    }

    //getter
    public double getcheckingBalance() {
        return checkingBalance;
    }

    //getter
    public double getsavingBalance() {
        return savingBalance;
    }

    public void getTotalBalance() {
        System.out.printf("Checking: %s \nSavings: %s\n", checkingBalance, savingBalance);
    }

    //setter
    public void setAccountDeposit(double number, String account) {
        if(account.equals("savings")){
            savingBalance = savingBalance + number;
            total = total + number;
        }else{
            checkingBalance = checkingBalance + number;
            total = total + number;
        }
    }

    public void setAccountWithdrawal(double number, String account) {
        if(account.equals("savings") && savingBalance > number){
            savingBalance = savingBalance - number;
            total = total - number;
        }else if(checkingBalance > number){
            checkingBalance = checkingBalance - number;
            total = total - number;
        }else{
            System.out.println("Insufficient Funds!");
        }
    }    
}