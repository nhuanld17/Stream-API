package II_StreamOperations.II_TerminateOperation.IV_ReduceOperation;

import java.util.Optional;
import java.util.stream.Stream;

public class ReduceOperation {
	// reduce(): Thực hiện phép tính gộp (reducing) trên các phần tử
	// của Stream để tạo ra một kết quả duy nhất.
	public static void main(String[] args) {
		// reduce(BinaryOperator<T> accumulator) trả về 1 Optional
		// Tính tổng các số trong 1 Stream
		
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
		
		Optional<Integer> sum = numbers.reduce((num1, num2) -> num1 += num2);
		
		sum.ifPresent(System.out::println); // 15
		
		// T reduce(T identity, BinaryOperator<T> accumulator)
		// Giống phiên bản đầu tiên nhưng có giá trị khởi tạo, trả về
		// 1 giá trị cụ thể, không phải Optional
		
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		
		int sum2 = numbers2.reduce(0, (integer, integer2) -> integer += integer2);
		
		System.out.println(sum2); // 15
		
		// reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
		// identity: giá trị khởi tạo, accumulator: hàm gộp, combiner: hàm kết hợp dùng để
		// kết hợp các kết quả từ luồng khác nhau trong Parallel Stream (nếu có)
		
		// Tính tổng độ dài các chuỗi kí tự trong Stream
		
		Stream<String> words = Stream.of("Java", "Stream", "API");
		
		int totalLength = words.reduce(
				0,               // Giá trị khởi tạo
				(length, word) -> length += word.length(), // Hàm gộp
				Integer::sum           // hàm kết hợp, kết hợp kết quả từ luồng
				// song song (nếu có)
		);
		System.out.println(totalLength); // 13
	}
}
