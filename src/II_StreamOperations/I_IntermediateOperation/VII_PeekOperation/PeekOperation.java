package II_StreamOperations.I_IntermediateOperation.VII_PeekOperation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PeekOperation {
	/*
	peek() được sử dụng cho các mục đích như debugging, logging hoặc để
	kiểm tra giá trị của các phần tử trong quá trình xử lí, peek không
	thay đổi các phần tử trong stream mà chỉ để quan sát
	* */
	
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
		
		Stream<String> wordsStream = words.stream();
		
		wordsStream.filter(s->s.length()>5) //Lọc chuỗi có độ dài > 5
				.peek(s -> System.out.println("Filter value: " + s)) // In giá trị sau khi lọc
				.map(s -> s.toUpperCase()) // Chuyển đổi các chuỗi thành chữ hoa
				.peek(s -> System.out.println("Mapped value: " + s)) // In giá trị sau khi chuyển đổi
				.forEach(s->System.out.println(s)); // In ra các giá trị cuối cùng
		/*
		Filter value: banana
		Mapped value: BANANA
				BANANA
		Filter value: cherry
		Mapped value: CHERRY
				CHERRY
		*/
	}
}
