package I_CreateStream.FromCollections;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamFromCollectionsExample {
	public static void main(String[] args) {
		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add(1);
		numberList.add(2);
		numberList.add(3);
		
		// Create a stream from a list
		Stream<Integer> streamFromList = numberList.stream();
		
		// Performing an operation on the stream
		streamFromList.forEach(element -> System.out.println(element));
	}
}
