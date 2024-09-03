package II_StreamOperations.II_TerminateOperation.XI_NoneMatchOperation;

import java.util.stream.Stream;

public class NoneMatchOperation {
	// boolean noneMatch(Predicate<? super T> predicate)
	// Trả về true nếu không có phần tử nào trong Stream thỏa mãn điều kiện được chỉ định.
	// Ví dụ: boolean noneNegative = stream.noneMatch(n -> n < 0);
	public static void main(String[] args) {
		// Kiểm tra không có số lẻ trong Stream
		Stream<Integer> numbers = Stream.of(2,4,6,8,10);
		boolean noOddNumber = numbers.noneMatch(x -> x % 2 != 0);
		System.out.println("Is stream has odd number? " + noOddNumber);
		// Is stream has odd number? true
		
		// Kiểm xem không có chuỗi nào trong Stream bắt đầu bằng Z
		Stream<String> words = Stream.of("ABC", "BCD", "DEF");
		boolean noWordStartWithZ = words.noneMatch(word -> word.startsWith("Z"));
		System.out.println("Is stream has word starting with Z? " + noWordStartWithZ);
		// Is stream has word starting with Z? true
		
	}
}
