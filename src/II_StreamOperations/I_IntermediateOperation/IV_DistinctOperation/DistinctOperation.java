package II_StreamOperations.I_IntermediateOperation.IV_DistinctOperation;

import java.util.Arrays;
import java.util.List;

public class DistinctOperation {
	/*
	Phương thức distinct() là 1 thao tác trung gian dùng để loại bỏ các phần
	tử trùng lặp trong stream, giữ lại các phần tử duy nhất
	* */
	public static void main(String[] args) {
		// Loại bỏ các số trùng lặp trong một danh sách số nguyên
		List<Integer> numbers = Arrays.asList(1,2,2,3,3,4,4,5,5);
		
		List<Integer> distinctNumbers = numbers.stream()
				.distinct()
				.toList();
		System.out.println(distinctNumbers);
		// [1, 2, 3, 4, 5]
		
		/***********************************************************/
		// Loại bỏ các chuỗi trùng lặp trong 1 danh sách
		List<String> words = Arrays.asList("abc","abc","def","def","ghi","jkl");
		
		List<String> distictWords = words.stream()
				.distinct()
				.toList();
		System.out.println(distictWords);
		// [abc, def, ghi, jkl]
		
		/**************************************************************/
		// Sử dụng distinct trên các đối tượng tùy chỉnh, cần đảm bảo lớp đối tượng
		// đã ghì đè phương thức equals() và hashCode() để xác định khi nào hai đối
		// tượng là bằng nhau
		
		List<Person> people = Arrays.asList(
				new Person("Alice", 23),
				new Person("Bob", 30),
				new Person("Alice", 23),
				new Person("Charlie", 31)
		);
		
		List<Person> distinctPeople = people.stream()
				.distinct()
				.toList();
		System.out.println(distinctPeople);
		// [Alice (23), Bob (30), Charlie (31)]
		/************************************************************************/
		
	}
}
