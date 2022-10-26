public class BankAccount {
     private double  checkBalance;
     private double savingsBalance;
     public int accountCounter =0;
     public static int numbersOfAccounts;
     public static double amountOfMoneyStored;

     public BankAccount(double balance,double savingsBalance){
         this.checkBalance= balance;
         this.savingsBalance=savingsBalance;
         amountOfMoneyStored = balance+savingsBalance;
         accountCounter++;
     }

    public double getCheckBalance() {
        System.out.println(checkBalance);
        return checkBalance;
    }

    public double getSavingsBalance() {
        System.out.println(savingsBalance);
        return savingsBalance;
    }

    public double deposit(double depositMoney,String accountType){
         if (accountType == "saving") {
             savingsBalance +=depositMoney;
             amountOfMoneyStored += depositMoney;
             System.out.println("Your total amount of money" + amountOfMoneyStored);
         }
        else if (accountType == "checking") {
            checkBalance += depositMoney;
            amountOfMoneyStored += depositMoney;
            System.out.println("Your total amount of money" + amountOfMoneyStored);
        }
         return amountOfMoneyStored;
    }

    public double withdrawMoney(double withdraw, String accountType) {
        if (accountType == "saving") {
            if (withdraw > amountOfMoneyStored) {
                System.out.println("the Stored Money is not enough");
            }
            if (withdraw < amountOfMoneyStored) {
                savingsBalance -= withdraw;
                amountOfMoneyStored -= withdraw;
                System.out.println("Your total amount of money" + amountOfMoneyStored);
            }
        }
        else if (accountType == "checking") {
            if (withdraw > amountOfMoneyStored) {
                System.out.println("the Stored Money is not enough");
            }
            if (withdraw < amountOfMoneyStored) {
                checkBalance -= withdraw;
                amountOfMoneyStored -= withdraw;
                System.out.println("Your total amount of money" + amountOfMoneyStored);
            }
        }
        return amountOfMoneyStored;
    }


}
