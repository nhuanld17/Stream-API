package I_CreateStream.FromArrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFromArrayExample {
	public static void main(String[] args) {
		int[] numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// Creating a stream from array
		Stream<Integer> streamFromArray = Arrays.stream(numbersArray).boxed();
		
		streamFromArray.forEach(element -> System.out.println(element));
	}
}
