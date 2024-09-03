package II_StreamOperations.II_TerminateOperation.XIV_IteratorOperation;

import java.util.*;
import java.util.stream.Stream;

public class IteratorOperation {
	// Iterator<T> iterator(): Trả về một Iterator cho các phần tử trong Stream.
	// Ví dụ: Iterator<T> iterator = stream.iterator();
	public static void main(String[] args) {
		// Duyệt Stream bằng Iterator
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
		Stream<String> namesStream = names.stream();
		Iterator<String> namesIterator = namesStream.iterator();
		
		while (namesIterator.hasNext()) {
			System.out.println(namesIterator.next());
		}
		// Alice
		// Bob
		// Charlie
		// David
		
		// kết hợp Iterator và Stream để đọc dữ liệu
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Stream<Integer> numbersStream = numbers.stream().filter(x -> x % 2 == 0);
		Iterator<Integer> numbersIterator = numbersStream.iterator();
		
		System.out.println("Even number:");
		while (numbersIterator.hasNext()) {
			System.out.println(numbersIterator.next());
		}
		
		// Even number:
		// 2
		// 4
		// 6
		// 8
		// 10
		
		// Sử dụng Iterator để kết hợp các Collection khác
		
		List<String> fruits = Arrays.asList("Apple", "Banana", "Mango", "Cherry", "Onanah");
		
		Stream<String> fruitsStream = fruits.stream().filter(f -> f.startsWith("A") || f.startsWith("B"));
		Iterator<String> fruitsIterator = fruitsStream.iterator();
		
		Set<String> fruitsSet = new TreeSet<>();
		while (fruitsIterator.hasNext()) {
			fruitsSet.add(fruitsIterator.next());
		}
		
		System.out.println("Fruits that start with A or B (sorted): " + fruitsSet);
		// Fruits that start with A or B (sorted): [Apple, Banana]
	}
}
