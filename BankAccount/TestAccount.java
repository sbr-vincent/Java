public class TestAccount {

    public static void main(String[] args) {
        BankAccount bankTest1 = new BankAccount();
        BankAccount bankTest2 = new BankAccount();

        System.out.println(BankAccount.accountCount());

        bankTest1.setAccountDeposit(1500.75, "savings");
        bankTest1.setAccountDeposit(200.5, "checking");
        
        double savingsTotal = bankTest1.getsavingBalance();
        double checkingTotal = bankTest1.getcheckingBalance();

        System.out.println("Bank Test 1: Savings: " + savingsTotal + " Checking: " + checkingTotal + "\n");
        bankTest1.getTotalBalance();

        bankTest1.setAccountWithdrawal(1001.50, "savings");
        bankTest1.getTotalBalance();

        bankTest1.getTotalBalance();
    }
}