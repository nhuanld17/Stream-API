package II_StreamOperations.I_IntermediateOperation.XV_BoxedOperation;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoxedOperation {
	public static void main(String[] args) {
		// Chuyển đổi IntStream thành Stream<Integer>
		// Giả sử bạn có một IntStream và bạn muốn chuyển đổi nó thành một
		// Stream<Integer> để có thể sử dụng các phương thức của Stream mà chỉ
		// làm việc với đối tượng.
		IntStream intStream = IntStream.range(1,5); // tạo IntStream từ 1 đến 4
		
		Stream<Integer> boxedStream = intStream.boxed();
		
		boxedStream.forEach(System.out::println);
		
		// Tạo danh sách từ 1 IntStream
		// Giả sử bạn muốn chuyển đổi 1 IntStream thành 1 List<Integer> để
		// lưu trữ và sử dụng sau này
		
		List<Integer> integerList = IntStream.range(1,5) // Tạo 1 IntStream từ 1 đến 4
				.boxed() // Chuyển đổi 1 IntStream thành 1 Stream<Integer>
				.toList(); // Thu thập các phần tử trong Stream thành 1 List
		
		System.out.println(integerList);
		// [1, 2, 3, 4]
		
		Optional<Integer> max = IntStream.of(10,20,30,40,50)
				.boxed() // Chuyển đổi IntStream thành 1 Stream<Integer>
				.max(((o1, o2) -> o1.compareTo(o2))); // Tìm giá trị lớn nhất
		
		max.ifPresent(System.out::println);
	}
}
