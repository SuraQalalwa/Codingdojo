class BankAccount:
	def __init__(self, int_rate, balance):
		self.int_rate = int_rate
		self.account_balance = balance

    def take_deposit(self, amount):
        self.account_balance += amount

    def make_withdrawal(self, amount):
        self.account -= amount

	def display_account_info(self):
		print("User", self.name, "Account", self.account_balance)
	
	def yield_interest(self):
		self.account_balance = amount *0.1

bank = BankAccount(0.2,500)