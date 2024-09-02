package II_StreamOperations.I_IntermediateOperation.IX_MapToIntOperation;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapToIntOperation {
	/*
	mapToInt được dùng để chuyển đổi các phần tử trong 1 stream thành
	các giá trị kiểu int, kết quả của thao tác mapToInt là 1 IntStream
	, 1 phiên bản chuyên biệt của stream dành cho các giá trị nguyên thủy
	kiểu int
	
	- được sử dụng khi bạn có 1 stream chứa các đối tượng và bạn muốn ánh
	xạ chúng thành các giá trị nguyên thủy int để thực hiện các thao tác
	như tính tổng, trung bình hoặc tận dụng các phương thức chuyên biệt
	của IntStream
	* */
	
	public static void main(String[] args) {
		// Tính tổng độ dài tất cả các chuỗi trong danh sách
		List<String> words = Arrays.asList("apple", "banana", "cherry");
		
		int totalLength = words.stream()
				.mapToInt(s -> s.length())
				.sum();
		System.out.println("Total length: " + totalLength);
		// Total length: 17
		
		// Tính trung bình độ dài chuỗi trong dánh sách
		OptionalDouble averageLength = words.stream()
				.mapToInt(s->s.length())
				.average();
		
		averageLength.ifPresent(System.out::println); // Java Optional này
	}
}
