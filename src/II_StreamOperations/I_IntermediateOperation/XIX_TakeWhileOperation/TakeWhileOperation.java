package II_StreamOperations.I_IntermediateOperation.XIX_TakeWhileOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TakeWhileOperation {
	// takeWhile() cho phép lấy các phần tử từ Stream cho đến khi
	// gặp một phần tử không thỏa mãn điều kiện nhất định. Khi gặp
	// phần tử đầu tiên không thỏa mãn điều kiện, takeWhile sẽ ngừng
	// lấy thêm phần tử, và các phần tử sau đó sẽ bị bỏ qua, ngay cả khi
	// chúng có thể thỏa mãn điều kiện
	public static void main(String[] args) {
		// Lấy các số nhỏ hơn 5 từ Stream
		List<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9)
				.takeWhile(n -> n < 5) // Lấy phần tử nhỏ hơn 5
				.toList();
		System.out.println(numbers);
		
		// Lấy các chuỗi bắt đầu bằng 1 chữ cái
		List<String> words = Stream.of("apple", "banana", "apricot", "orange", "avocado")
				.takeWhile(word -> word.startsWith("a"))
				.toList();
		System.out.println(words);
	}
}
