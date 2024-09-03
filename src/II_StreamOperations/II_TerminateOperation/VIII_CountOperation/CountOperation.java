package II_StreamOperations.II_TerminateOperation.VIII_CountOperation;

import java.util.stream.Stream;

public class CountOperation {
	// long count(): đếm số lượng phần tử trong Stream
	public static void main(String[] args) {
		
		// Đếm số lượng phần tử trong Stream
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		long count = numbers.count();
		System.out.println("Number of elements in the stream: " + count);
		// Number of elements in the stream: 10
		
		// Đếm số lượng phần tử sau khi lọc, đếm số chẵn trong 1 Stream
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		long count2 = numbers2.filter(n -> n % 2 == 0).count();
		System.out.println("Number of even elements in the stream: " + count2);
		// Number of even elements in the stream: 5
	}
}
