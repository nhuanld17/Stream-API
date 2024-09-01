package II_StreamOperations.I_IntermediateOperation.III_SortedOperation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedOperation {
	/*
	Phương thức sorted() là 1 thao tác trung gian, dùng để sắp xếp các phần
	tử của Stream theo thứ tự tự nhiên hoặc theo 1 tiêu chí cụ thể được xác
	định bởi 1 Comparator
	* */
	
	public static void main(String[] args) {
		// Sắp xếp các số theo thứ tự tăng dần (thứ tự tự nhiên)
		List<Integer> numbers = Arrays.asList(5, 1, 3, 2,4);
		
		List<Integer> sortedNumbers = numbers.stream()
				.sorted()
				.toList();
		System.out.println(sortedNumbers);
		// [1, 2, 3, 4, 5]
		
		/**********************************************************************/
		// Sắp xếp chuỗi theo thứ tự bảng chữ cái
		List<String> words = Arrays.asList("banana", "apple", "cherry");
		
		List<String> sortedWords = words.stream()
				.sorted()
				.toList();
		System.out.println(sortedWords);
		// [apple, banana, cherry]
		
		/************************************************************************/
		// Sắp xếp số theo thứ tự giảm dần (Sử dụng Comparator)
		List<Integer> numbers2 = Arrays.asList(5, 1, 3, 2,4);
		
		List<Integer> sortedNumbers2 = numbers2.stream()
				.sorted(Comparator.reverseOrder())
				.toList();
		System.out.println(sortedNumbers2);
		// [5, 4, 3, 2, 1]
		
		/***********************************************************************/
		// Sắp xếp các đối tượng tùy chỉnh theo 1 tiêu chí cụ thể
		List<Person> people = Arrays.asList(
				new Person("Alice", 23),
				new Person("Bob", 30),
				new Person("Charlie", 28)
		);
		
		List<Person> sortedPeople = people.stream()
				.sorted(Comparator.comparing(person -> person.getAge()))
			//	.sorted(Comparator.comparing(Person::getAge)) // Hoặc dùng cái này
				.toList();
		System.out.println(sortedPeople);
		// [Alice (23), Charlie (28), Bob (30)]
		
		// Hoặc theo thứ tự ngược lại
		
		sortedPeople = people.stream()
				.sorted(Comparator.comparing(Person::getAge).reversed())
				.toList();
		System.out.println(sortedPeople);
	}
}
