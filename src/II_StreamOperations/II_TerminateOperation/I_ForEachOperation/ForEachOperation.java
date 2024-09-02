package II_StreamOperations.II_TerminateOperation.I_ForEachOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachOperation {
	public static void main(String[] args) {
		// In ra các phần tử của Stream
		Stream.of(1,2,3,4,5,6,7,8,9)
				.forEach(System.out::print);
		// 123456789
		
		// Một ví dụ khác
		List<String> names = Arrays.asList("John", "Jance", "Jack", "Doe");
		
		names.stream()
				.forEach(name -> {
					if (name.startsWith("J")){
						System.out.println(name + " start with J");
					} else {
						System.out.println(name + " does not start with J");
					}
				});
		// Jance start with J
		// Jack start with J
		// Doe does not start with J
	}
}
