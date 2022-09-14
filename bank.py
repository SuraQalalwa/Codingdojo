class BankAccount:
    def __init__(self,int_rate, balance):
        self.int_rate = int_rate
        self.account_balance = balance


    def take_deposit(self, amount):
        self.account_balance += amount
        return self

    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self

    def display_account_info(self):
        print(self.int_rate, self.account_balance)
        return self

    def yield_interest(self):
        self.account_balance = self.account_balance+(self.account_balance*self.int_rate)
        return self

n111=BankAccount(0.3,50000)
n111.make_withdrawal(400).make_withdrawal(300).take_deposit(800).yield_interest().display_account_info()

