package II_StreamOperations.I_IntermediateOperation.VIII_SkipOperation;

import java.util.List;
import java.util.stream.Stream;

public class SkipOperation {
	/*
	Thao tác skip dùng để bỏ qua một số lượng phần tử nhất định từ đầu
	của stream
	* */
	
	public static void main(String[] args) {
		
		// Bỏ qua hai phần tử đầu tiên trong 1 stream chứa các chuỗi
		
		List<String> result = Stream.of("apple", "banana", "cherry", "date", "fig")
				.skip(2) // Bỏ qua hai phần tử đầu tiên apple, banana
				.toList();
		System.out.println(result);
		// [cherry, date, fig]
		
		// Kết hợp skip và limit
		
		List<String> result2 = Stream.of("a", "b", "c", "d", "e", "f", "g", "h")
				.skip(2) // Bỏ qua hai phần tử đầu tiên
				.limit(3) // Lấy ba phần tử tiếp theo
				.toList();
		
		System.out.println(result2);
		// [c, d, e]
		
	}
}
