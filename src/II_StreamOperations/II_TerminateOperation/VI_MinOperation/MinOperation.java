package II_StreamOperations.II_TerminateOperation.VI_MinOperation;

import java.util.Optional;
import java.util.stream.Stream;

public class MinOperation {
	// Trả về phần tử nhỏ nhất theo một Comparator cụ thể.
	// Ví dụ: Optional<Integer> min = stream.min(Integer::compare);
	public static void main(String[] args) {
		// Tìm số nhỏ nhất trong 1 Stream số nguyên
		Stream<Integer> numbers = Stream.of(5, 10, 4, 2, 6, 7);
		Optional<Integer> min = numbers.min((o1, o2) -> o1 - o2); // Tìm phần tử nhỏ nhất
		min.ifPresent(System.out::println); // 2
		
		// Tìm chuỗi có độ dài nhỏ nhất trong 1 Stream các chuỗi
		Stream<String> words = Stream.of("Hello", "World", "Java", "API");
		Optional<String> minLengthWord = words.min((s1, s2) -> s1.length() - s2.length());
		minLengthWord.ifPresent(System.out::println); // API
		
		
	}
}
