package II_StreamOperations.I_IntermediateOperation.XII_FlatMapToInt;

import java.util.Arrays;
import java.util.List;

public class FlatMapToIntOperation {
	public static void main(String[] args) {
		// Tính tổng độ dài của tất cả các từ trong 1 danh sách câu
		List<String> sentences = Arrays.asList("Hello world", "Java Stream API", "flat map example");
		
		int totalLength = sentences.stream()
				.flatMapToInt(sentence -> Arrays.stream(sentence.split(" "))
						.mapToInt(String::length))
				.sum();
		
		System.out.println("Total length of all words: " + totalLength);
		// Total length of all words: 37
		
		// Tính tổng độ dài các số trong danh sách các mảng số nguyên
		List<int[]> listOfIntArrays = Arrays.asList(
				new int[]{1,2,3},
				new int[]{4,5},
				new int[]{6,7,8,9}
		);
		
		int totalSum = listOfIntArrays.stream()
				.flatMapToInt(list -> Arrays.stream(list))
				.sum();
		
		System.out.println("Total sum of all elements: " + totalSum);
	}
}
