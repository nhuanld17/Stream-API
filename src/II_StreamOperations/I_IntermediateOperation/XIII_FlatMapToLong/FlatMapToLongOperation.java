package II_StreamOperations.I_IntermediateOperation.XIII_FlatMapToLong;

import java.util.Arrays;
import java.util.List;

public class FlatMapToLongOperation {
	public static void main(String[] args) {
		// Tính tổng số giờ làm việc từ danh sách nhân viên
		List<Employee> employees = Arrays.asList(
				new Employee("John", Arrays.asList(8L, 7L, 9L)),
				new Employee("Jane", Arrays.asList(6L, 7L)),
				new Employee("Jack", Arrays.asList(8L, 9L, 10L))
		);
		
		long totalHours = employees.stream()
				.flatMapToLong(e -> e.getHoursWorkedPerShift().stream().mapToLong(h->h.longValue()))
				.sum();
		System.out.println("Total hours: " + totalHours);
		// Total hours: 64
		
		// Tính tổng số tiền trong danh sách tài khoản ngân hàng
		
		List<BankAccount> accounts = Arrays.asList(
				new BankAccount("123", Arrays.asList(200L, 300L, 400L)),
				new BankAccount("456", Arrays.asList(500L, 100L)),
				new BankAccount("789", Arrays.asList(1000L, 2000L))
		);
		
		Long totalAmount = accounts.stream()
				.flatMapToLong(account -> account.getTransactions().stream().mapToLong(amount -> amount.longValue()))
				.sum();
		
		System.out.println("Total amount: " + totalAmount);
		// Total amount: 4500
	}
}
