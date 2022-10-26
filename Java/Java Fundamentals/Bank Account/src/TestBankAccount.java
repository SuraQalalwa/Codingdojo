public class TestBankAccount {
    public static void main(String[] args){
        BankAccount userAccount = new BankAccount(2000,1000);
        userAccount.deposit(200,"saving");
        userAccount.withdrawMoney(500, "checking");
        userAccount.withdrawMoney(50, "checking");
        userAccount.deposit(10,"saving");
        userAccount.getSavingsBalance();
        userAccount.getCheckBalance();
        userAccount.withdrawMoney(10000, "checking");


    }

}
