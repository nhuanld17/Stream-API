package II_StreamOperations.II_TerminateOperation.III_ToArrayOperation;

import java.util.stream.Stream;

public class ToArrayOperation {
	// toArray(): Chuyển đổi 1 Stream thành 1 mảng đối tượng
	public static void main(String[] args) {
		// Chuyển 1 Stream số nguyên thành 1 mảng Object[]
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
		
		Object[] array = stream.toArray();
		
		for (Object o : array) {
			System.out.print(o);
		}
		// 12345
		
		// Chuyển Stream thành mảng với kiểu cụ thể
		// --> Chuyển Stream thành mảng String[]
		
		Stream<String> stream1 = Stream.of("a", "b", "c");
		
		String[] stringArray = stream1.toArray(String[]::new);
		System.out.println();
		for (String s : stringArray) {
			System.out.print(s);
		}
		// abc
		
		
	}
}
