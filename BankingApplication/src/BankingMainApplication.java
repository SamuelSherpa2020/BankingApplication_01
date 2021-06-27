import java.util.Scanner;

public class BankingMainApplication {

	public static void main(String[] args) {
		BankAccount obj = new BankAccount("Samuel Sherpa","19031860");
		obj.showMenu();
	}

}

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname, String cid){
		this.customerName = cname;
		this.customerId  = cid;
	}
	
	void deposit(int amount) {
		if(amount !=0) {
			balance = balance + amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount !=0 && amount >= this.balance) {
			balance = balance - amount;
			previousTransaction = amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction !=0) {
			System.out.println("WithDrawn: "+ previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn: "+ Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction Occured yet");
		}
	}
	
	void showMenu() {
		
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome "+ customerName);
		System.out.println("Your Id is "+ customerId);
		System.out.println("\n");
		System.out.println("A, Check Balance");
		System.out.println("B, Deposit");
		System.out.println("C, WithDraw");
		System.out.println("D, Previous transaction");
		System.out.println("E, Exit");
		
		do {
			System.out.println("================================");
			System.out.println("Enter an option");
			System.out.println("================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			case 'A':
				System.out.println("============================");
				System.out.println("Balance = "+ balance);
				System.out.println("============================");
				System.out.println("\n");
				break;
				
			
			case 'B':
				System.out.println("============================");
				System.out.println("Enter an amount to deposit:");
				System.out.println("============================");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
			
			case 'C':
				System.out.println("=============================");
				System.out.println("Enter an amount to withdraw:");
				System.out.println("=============================");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("============================");
				getPreviousTransaction();
				System.out.println("============================");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("*****THE END******");
				break;
				
			default:
				System.out.println("Invalid Option!!. Please Enter again");
				break;
			}
		}
		while (option != 'E');
	}
}




































