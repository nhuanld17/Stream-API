package II_StreamOperations.II_TerminateOperation.XII_FindFirstOperation;

import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstOperation {
	// Optional<T> findFirst(): Trả về phần tử đầu tiên trong Stream, nếu có.
	// Ví dụ: Optional<String> first = stream.findFirst();
	public static void main(String[] args) {
		// Tìm phần tử đầu tiên trong Stream số nguyên
		Stream<Integer> numbers = Stream.of(5, 10, 15, 20, 25);
		Optional<Integer> firstNumber = numbers.findFirst();
		firstNumber.ifPresent(integer -> System.out.println(integer));
		// 5
		
		// Tìm phần tử đầu tiên trong Parallel Stream
		Stream<Integer> numbers2 = Stream.of(5, 10, 15, 20, 25).parallel();
		Optional<Integer> firstNumber2 = numbers2.findFirst();
		firstNumber2.ifPresent(integer -> System.out.println(integer)); // 5
	}
}
