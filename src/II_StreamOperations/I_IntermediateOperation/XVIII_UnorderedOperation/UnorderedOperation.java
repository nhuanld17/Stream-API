package II_StreamOperations.I_IntermediateOperation.XVIII_UnorderedOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class UnorderedOperation {
	public static void main(String[] args) {
		// Sử dụng unordered với Parallel Stream
		// Đếm số lượng phần tử chẵn trong 1 danh sách số nguyên
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		long count = numbers.parallelStream()
				.unordered()
				.filter(x -> x % 2 == 0)
				.count();
		System.out.println("Count of even numbers: " + count);
		
		// Sử dụng unordered() với dữ liệu có thứ tự
		
		// Một stream có thứ tự
		IntStream orderedStream = IntStream.range(1, 1000);
		
		// Biến nó thành 1 Stream không cần giữ thứ tự
		orderedStream.unordered() // Returns: an unordered stream
				.parallel() // Sử dụng Parallel Stream
				.forEach(System.out::println);
	}
}
