package II_StreamOperations.I_IntermediateOperation.I_FilterOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOperation {
	public static void main(String[] args) {
		/*******************************************************/
		// Lọc ra các số chẵn (Điều kiện: chia hết cho 2)
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		
		List<Integer> evenNumbers = numbers.stream()
				.filter(element -> element % 2 == 0) // Phương thức trung gian
				.collect(Collectors.toList());
		
		System.out.println(evenNumbers); // [2, 4, 6, 8, 10]
		/********************************************************/
		// Lọc các chuỗi có độ dài lớn hơn 3
		List<String> strings = Arrays.asList("apple", "banana", "kiw", "pear");
		
		List<String> longStrings = strings.stream()
				.filter(str -> str.length() > 3)
				.toList();
		System.out.println(longStrings); // [apple, banana, pear]
		
		/********************************************************/
		// Lọc các đối tượng trong danh sách
		List<Person> persons = Arrays.asList(
			new Person("Nhuận", 15),
			new Person("Quảng", 16),
			new Person("Huỳnh Bút", 19),
			new Person("Phúc Du", 20)
		);
		
		// Lọc ra các Person có tuổi trên 18
		List<Person> adults = persons.stream()
				.filter(person -> person.getAge() > 18)
				.toList();
		System.out.println(adults);
	}
}
