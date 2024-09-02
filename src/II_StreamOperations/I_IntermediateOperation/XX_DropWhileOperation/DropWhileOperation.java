package II_StreamOperations.I_IntermediateOperation.XX_DropWhileOperation;

import java.util.List;
import java.util.stream.Stream;

public class DropWhileOperation {
	// dropWhile(): Bỏ qua các phần tử từ đầu Stream đến khi gặp
	// một phần tử không thỏa mãn điều kiện được chỉ định. ngay khi
	// gặp phần tử không thỏa mãn điều kiện, dropWhile sẽ bắt đầu
	// lấy tất cả các phần tử còn lại trong stream
	
	public static void main(String[] args) {
		// Bỏ qua các số nhỏ hơn 5 từ Stream
		List<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10)
				.dropWhile(n -> n < 5) // Bỏ qua các phần tử nhỏ hơn 5
				.toList();
		System.out.println(numbers);
		
		// Bỏ qua các chuỗi kí tự có độ dài nhỏ hơn 5
		List<String> words = Stream.of("abc", "abcd", "abcde", "abcdef", "abbccddee")
				.dropWhile(element -> element.length() < 5)
				.toList();
		
		System.out.println(words);
	}
}
