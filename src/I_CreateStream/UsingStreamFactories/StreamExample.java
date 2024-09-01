package I_CreateStream.UsingStreamFactories;

import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		// Creating a stream using Stream.of()
		Stream<Integer> streamOfValues = Stream.of(1, 2, 3, 4, 5);
		
		// Performing an operation on the stream
		streamOfValues.forEach(System.out::println);
	}
}
