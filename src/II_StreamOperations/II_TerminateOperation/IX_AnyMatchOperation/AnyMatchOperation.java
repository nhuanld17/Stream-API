package II_StreamOperations.II_TerminateOperation.IX_AnyMatchOperation;

import java.util.stream.Stream;

public class AnyMatchOperation {
	// boolean anyMatch(Predicate<? super T> predicate): Kiểm tra xem bất kì phần tử nào
	// trong stream có thỏa mãn điều kiện cụ thể nào không
	// Trả về true nếu có ít nhất một phần tử trong Stream thỏa mãn điều kiện được chỉ định.
	// Ví dụ: boolean hasEven = stream.anyMatch(n -> n % 2 == 0);
	public static void main(String[] args) {
		// Kiểm tra xem có số chẵn trong Stream hay không
		Stream<Integer> numbers = Stream.of(1, 3, 5, 7, 8, 9);
		boolean hasEvenNumber = numbers.anyMatch(integer -> integer % 2 == 0);
		System.out.println("Is Stream has even number ?:" + hasEvenNumber);
		// Is Stream has even number ?:true
		
		// Kiểm tra xem có chuỗi nào bắt đầu bằng chữ J hay không
		Stream<String> names = Stream.of("Alice", "Bob", "John", "Doe");
		boolean hasNameStartWithJ = names.anyMatch(name -> name.startsWith("J"));
		System.out.println("Is Stream has name startWith J ?:" + hasNameStartWithJ);
		// Is Stream has name startWith J ?:true
		
		
	}
}
