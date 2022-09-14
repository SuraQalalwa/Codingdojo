#/////////////////Bank Account////////////////////////#
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
#/////////////////User////////////////////////#
class User:  
    def __init__(self, name):
        self.name = name
        self.account_balance = BankAccount(0.02,500)


user_1=User("Ali")
user_1.account_balance.display_account_info()
user_1.account_balance.take_deposit(100)
user_1.account_balance.display_account_info()
