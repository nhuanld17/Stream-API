package II_StreamOperations.I_IntermediateOperation.II_MapOperation;

import java.util.Arrays;
import java.util.List;

public class MapOperation {
	/*
	Phương thức map() là 1 intermadiate operation được dùng để ánh xạ(map)
	từng phần tử trong stream thành 1 phần tử mới theo 1 hàm chuyển đổi
	Kết quả của map là 1 stream mới chứa các phần tử đã được chuyển đổi
	* */
	
	public static void main(String[] args) {
		// Chuyển đổi danh sách số nguyên thành dạng bình phương của chúng
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		List<Integer> squaredNumbers = numbers.stream()
				.map(num -> num*num)
				.toList();
		System.out.println(squaredNumbers);
		// [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
		
		/*******************************************************************/
		// Chuyển đổi danh sách các chuỗi thành danh sách các độ dài của chúng
		List<String> words = Arrays.asList("apple", "banana", "cherry");
		
		List<Integer> lengths = words.stream()
				.map(element -> element.length())
				.toList();
		System.out.println(lengths);
		// [5, 6, 6]
		
		/****************************************************/
		// Chuyển đổi danh sách các chuỗi thành danh sách các độ dài của chúng
		// có sử dụng hàm chuyển đổi
		
		List<String> words2 = Arrays.asList("apple", "banana", "cherry");
		
		List<Integer> lengths2 = words2.stream()
				.map(element -> getStringLength(element))
				.toList();
		System.out.println(lengths2);
		
		/**************************************************************/
		// Chuyển đổi một danh sách các đối tượng thành một danh sách
		// các thuộc tính của chúng
		
		List<Person> persons = Arrays.asList(
				new Person("Nhuanj", 10),
				new Person("QuangK", 12),
				new Person("Shanghai", 20)
		);
		
		List<String> names = persons.stream()
				.map(person -> person.name)
				.toList();
		System.out.println(names);
		// [Nhuanj, QuangK, Shanghai]
		
		/*************************************************************************/
	}
	
	public static int getStringLength(String str) {
		return str.length();
	}
}
