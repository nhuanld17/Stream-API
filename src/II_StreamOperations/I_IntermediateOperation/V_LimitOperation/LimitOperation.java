package II_StreamOperations.I_IntermediateOperation.V_LimitOperation;

import java.util.Arrays;
import java.util.List;

public class LimitOperation {
	/*
	Phương thức limit() là 1 thao tác trung gian để cắt ngắn stream,
	giới hạn số lượng phần tử trong Stream theo 1 số lượng cụ thể, khi
	sử dụng limit(), chỉ 1 số lượng phần tử đầu tiên của stream được giữ
	lại, còn lại bị bỏ qua
	* */
	
	public static void main(String[] args) {
		// lấy ra 3 phần tử đầu tiên của 1 danh sách số nguyên
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		
		List<Integer> limitedNumbers = numbers.stream()
				.limit(3)
				.toList();
		System.out.println(limitedNumbers);
		// [1, 2, 3]
		
		// Lấy hai phần tử đầu tiên từ 1 stream chứa các chuỗi
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
		
		List<String> limitedWords = words.stream()
				.limit(2)
				.toList();
		System.out.println(limitedWords);
		// [apple, banana]
		
		// Sử dụng limit() kết hợp với các thao tác khác
		List<String> result = words.stream()
				.filter(word -> word.length() > 5)
				.limit(2)
				.toList();
		System.out.println(result);
		// [banana, cherry]
	}
}
