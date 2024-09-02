package II_StreamOperations.II_TerminateOperation.II_ForEachOrderedOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachOrderedOperation {
	// Tương tự forEach, nhưng đảm bảo rằng các phần tử được xử lý theo thứ tự
	// trong Stream, đặc biệt hữu ích khi làm việc với Parallel Stream.
	
	public static void main(String[] args) {
		// In ra các phần tử trong Stream theo thứ tự
		IntStream.range(1, 10)
				.parallel()
				.forEachOrdered(System.out::println);
		
		// So sánh forEach và forEachOrdered trong Parallel Stream
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("Using forEach:");
		numbers.parallelStream()
				.forEach(System.out::println); // Kết quả có thể không theo thứ tự
		
		System.out.println("\nUsing forEachOrdered:");
		numbers.parallelStream()
				.forEachOrdered(System.out::println); // Kết quả sẽ theo thứ tự
	}
}
