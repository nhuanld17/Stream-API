package II_StreamOperations.I_IntermediateOperation.X_MapToLongOperation;

import java.util.*;

public class MapToLongOperation {
	/*
	mapToLong dùng để chuyển đổi các phần tử trong 1 Stream thành các giá trị
	kiểu long, kết quả của thao tác này là 1 LongStream, một phiên bản chuyên
	biệt của Stream danh cho các giá trị nguyên thủy kiểu long
	
	mapToLong được sử dụng khi bạn có 1 stream chứa các đối tượng và bạn muốn
	ánh xạ chúng thành các giá trị nguyên thủy long để thực hiện các phép toán
	như tính tổng, tìm giá trị lớn nhất, nhỏ nhất, hoặc tận dụng các phương thức
	chuyên biệt của LongStream
	* */
	public static void main(String[] args) {
		// Tính tổng độ dài các chuỗi trong danh sách
		List<String> words = Arrays.asList("abc", "cd", "edfff");
		
		long totalLength = words.stream()
				.mapToLong(s -> s.length())
				.sum();
		System.out.println("Total Length: " + totalLength);
		
		// Tính trung bình độ dài chuỗi trong danh sách
		OptionalDouble avgLength = words.stream()
				.mapToLong(s -> s.length())
				.average();
		avgLength.ifPresent(System.out::println);
	}
	
}
