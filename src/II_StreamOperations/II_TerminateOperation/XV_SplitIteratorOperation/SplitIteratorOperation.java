package II_StreamOperations.II_TerminateOperation.XV_SplitIteratorOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SplitIteratorOperation {
	// Spliterator<T> spliterator()
	// Trả về một Spliterator cho các phần tử trong Stream
	// Ví dụ: Spliterator<T> spliterator = stream.spliterator();
	public static void main(String[] args) {
		// Phân tách và duyệt qua các phần tử với SplitIterator
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");
		
		Stream<String> namesStream = names.stream();
		
		// Lấy 1 SplitIterator từ Stream
		Spliterator<String> namesSpliterator1 = namesStream.spliterator();
		
		// Chia SplitIterator đầu tiên thành 2 phần, tạo ra nameSplitIterator2
		Spliterator<String> namesSpliterator2 = namesSpliterator1.trySplit();
		
		// Duyệt qua các phần tử còn lại trong nameSplitIterator1 và in ra
		System.out.println("Elements from nameSpliterator1:");
		namesSpliterator1.forEachRemaining(System.out::println);
		
		// Duyệt qua các phần tử còn lại trong nameSplitIterator2 và in ra
		System.out.println("Elements from nameSpliterator2:");
		namesSpliterator2.forEachRemaining(System.out::println);
		
		// Kết hợp SplitIterator với Stream để xử lí dữ liệu song song
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Stream<Integer> numbersStream = numbers.stream();
		Spliterator<Integer> numbersSpliterator1 = numbersStream.spliterator();
		
		Spliterator<Integer> numbersSpliterator2 = numbersSpliterator1.trySplit();
		
		System.out.println("Elements from numbersSpliterator1:");
		numbersSpliterator1.forEachRemaining(System.out::println);
		
		System.out.println("Elements from numbersSpliterator2:");
		numbersSpliterator2.forEachRemaining(System.out::println);
	}
}
