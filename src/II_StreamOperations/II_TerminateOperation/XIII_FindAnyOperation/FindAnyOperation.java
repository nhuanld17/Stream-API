package II_StreamOperations.II_TerminateOperation.XIII_FindAnyOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAnyOperation {
	// Optional<T> findAny(): Trả về một phần tử bất kỳ trong Stream, đặc biệt hữu ích
	// trong Parallel Stream.
	// Ví dụ: Optional<String> any = stream.findAny();
	// Trường hợp Stream có phần tử: findAny() sẽ trả về một Optional chứa một phần tử
	// bất kỳ trong Stream.
	// Trường hợp Stream rỗng: findAny() sẽ trả về một Optional.empty().
	public static void main(String[] args) {
		// Lấy một phần tử bất kì trong 1 danh sách số nguyên
		List<Integer> numbers = Arrays.asList(1,2,4,5,6,7,8,9);
		Optional<Integer> anyNumber = numbers.stream().findAny();
		anyNumber.ifPresent(System.out::println); // 1
		
		
	}
}
