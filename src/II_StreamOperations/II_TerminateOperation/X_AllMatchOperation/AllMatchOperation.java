package II_StreamOperations.II_TerminateOperation.X_AllMatchOperation;

import java.util.stream.Stream;

public class AllMatchOperation {
	// boolean allMatch(Predicate<? super T> predicate): kiểm tra all phần tử có thỏa mãn
	// điều kiện cụ thể hay không
	// Trả về true nếu tất cả các phần tử trong Stream thỏa mãn điều kiện được chỉ định.
	// Ví dụ: boolean allEven = stream.allMatch(n -> n % 2 == 0);
	public static void main(String[] args) {
		// Kiểm tra tất cả các số trong Stream có phải là số chẵn hay không
		Stream<Integer> numbers = Stream.of(2,4,6,8,10);
		boolean isAllEven = numbers.allMatch(x -> x % 2 == 0);
		System.out.println("Is All Even: " + isAllEven);
		// Is All Even: true
		
		// Kiểm tra tất cả các chuỗi trong Stream có bắt đầu bằng chữ A hay không
		Stream<String> names = Stream.of("Alice", "Adam", "Alex");
		boolean allStartWithA = names.allMatch(name -> name.startsWith("A"));
		System.out.println("Is All Start With A: " + allStartWithA);
		// Is All Start With A: true
	}
}
