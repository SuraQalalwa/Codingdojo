class User : 
    def __init__ (self , name , account_balance):
        self.name=name
        self.account_balance = account_balance 
    def make_withdrawl(self , amount):
        self.account_balance -=amount
    def make_deposits(self , amount):
        self.account_balance +=amount
        # print(Ahmed.account_balance)
    # def display_user_balance(self)
    def transfer_money(self, other_user ,amount):
        self.account_balance -= amount
        other_user .account_balance += amount

Ahmed = User('Ahmed' , 100)
Ayman = User('Ayman' , 200)
Ali = User('Ali' , 500)
# print(Ayman.account_balance)
# Ahmed.make_withdrawl(70)
# print(Ahmed.account_balance)
Ahmed.make_deposits(200), Ahmed.make_deposits(100) , Ahmed.make_deposits(400)
Ahmed.make_withdrawl(500)
# print(Ahmed.account_balance)
Ayman.make_deposits(200), Ayman.make_deposits(100)
Ayman.make_withdrawl(300) , Ayman.make_withdrawl(200)
# print(Ayman.account_balance)
Ali.make_deposits(100)
Ali.make_withdrawl(50) , Ali.make_withdrawl(200) , Ali.make_withdrawl(200)
# print(Ali.account_balance)
print(Ali.account_balance)
Ahmed.transfer_money(Ali ,50)
print(Ali.account_balance)