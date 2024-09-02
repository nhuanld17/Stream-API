package II_StreamOperations.I_IntermediateOperation.XIII_FlatMapToLong;

import java.util.List;

public class BankAccount {
	private String accountNumber;
	private List<Long> transactions;
	
	public BankAccount(String accountNumber, List<Long> transactions) {
		this.accountNumber = accountNumber;
		this.transactions = transactions;
	}
	
	public List<Long> getTransactions() {
		return transactions;
	}
}
