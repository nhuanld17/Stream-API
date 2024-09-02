package II_StreamOperations.I_IntermediateOperation.XVII_SequentialOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SequentialOperation {
	public static void main(String[] args) {
		// Chuyển 1 Parallel Stream thành 1 Sequential Stream
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		numbers.stream()
				.parallel()
				.sequential()
				.forEach(System.out::println);
		
		// Sử dụng Sequential Stream khi cần đảm bảo thứ tự xử lí
		IntStream.range(1,10)
				.parallel()
				.sequential()
				.forEach(System.out::println);
	}
}
