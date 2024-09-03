package II_StreamOperations.II_TerminateOperation.VII_MaxOperation;

import java.util.Optional;
import java.util.stream.Stream;

public class MaxOperation {
	// Optional<T> max(Comparator<? super T> comparator)
	// Dùng để tìm phần tử lớn nhất trong một Stream
	public static void main(String[] args) {
		
		// Tìm số lớn nhất trong một Stream các số nguyên
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Optional<Integer> max = numbers.max((o1, o2) -> o1 - o2);
		max.ifPresent(System.out::println); // 10
		
		// Tìm chuỗi có độ dài lớn nhất trong 1 Stream chứa các chuỗi
		Stream<String> words = Stream.of("Nhuan", "Quang", "Quoc Hoang");
		Optional<String> maxLengthWord = words.max((o1, o2) -> o1.length() - o2.length());
		maxLengthWord.ifPresent(System.out::println); // Quoc Hoang
	}
}
