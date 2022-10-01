class User:  
    def __init__(self, name):
        self.name = name
        self.account_balance = 0

    def take_dipposit(self, amount):
        self.account_balance += amount

    def make_withdrawal(self, amount):
        self.account_balance -= amount

    def display_user_balance(self):
        print("User", self.name, "Account", self.account_balance)

    def transfer_money(self, other_user, amount):
        self.account_balance -=amount
        other_user.account_balance=other_user.account_balance+ amount 


print("----------------")
user_1 = User("Shatha")
user_1.take_dipposit(100)
user_1.take_dipposit(200)
user_1.take_dipposit(300)
user_1.make_withdrawal(50)
user_1.display_user_balance()

print("----------------")
user_2=User("Hala")
user_2.take_dipposit(100)
user_2.take_dipposit(200)
user_2.make_withdrawal(30)
user_2.make_withdrawal(50)
user_2.display_user_balance()

print("----------------")
user_3=User("Sura")
user_3.take_dipposit(100)
user_3.make_withdrawal(10)
user_3.make_withdrawal(20)
user_3.make_withdrawal(40)
user_3.display_user_balance()


user_3.transfer_money(user_2,20)
user_3.display_user_balance()
user_3.display_user_balance()