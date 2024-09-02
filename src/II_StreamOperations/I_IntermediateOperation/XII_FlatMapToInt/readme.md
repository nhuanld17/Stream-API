### `flatMapToInt` trong Java Stream API

**`flatMapToInt`** là một thao tác trung gian trong Java Stream API, được sử dụng để chuyển đổi mỗi phần tử của một `Stream<T>` thành một `IntStream` (stream chứa các giá trị kiểu `int`). Sau đó, tất cả các `IntStream` kết quả được hợp nhất thành một `IntStream` duy nhất. Điều này có thể hiểu đơn giản là "làm phẳng" nhiều `IntStream` thành một `IntStream` liên tục.

### Cú pháp:
```java
IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper)
```

- **`mapper`**: Là một hàm (biểu thức lambda hoặc method reference) được áp dụng cho mỗi phần tử của `Stream<T>` để chuyển đổi nó thành một `IntStream`.

### Mục đích:
`flatMapToInt` rất hữu ích khi bạn có một `Stream` mà mỗi phần tử trong đó có thể tạo ra một số lượng `int` khác nhau (tức là một `IntStream`). Nó cho phép bạn chuyển đổi và hợp nhất các `IntStream` con này thành một `IntStream` duy nhất, từ đó dễ dàng áp dụng các thao tác như `sum()`, `average()`, `max()`, v.v.

### Ví dụ minh họa:

#### Ví dụ 1: Tính tổng độ dài của tất cả các từ trong một danh sách câu
Giả sử bạn có một danh sách các câu, và bạn muốn tính tổng độ dài của tất cả các từ trong các câu đó.

```java
import java.util.Arrays;
import java.util.List;

public class FlatMapToIntExample {
	public static void main(String[] args) {
		List<String> sentences = Arrays.asList("Hello world", "Java Stream API", "flatMap example");
		
		int totalLength = sentences.stream()
				.flatMapToInt(sentence -> Arrays.stream(sentence.split(" "))
						.mapToInt(String::length))
				.sum();
		
		System.out.println("Total length of all words: " + totalLength);  // Output: Total length of all words: 33
	}
}
```

#### Giải thích:
1. **`sentence.split(" ")`**: Mỗi câu được tách thành các từ dựa trên dấu cách.
2. **`Arrays.stream(...)`**: Tạo một `Stream<String>` từ các từ trong câu.
3. **`mapToInt(String::length)`**: Chuyển đổi mỗi từ thành độ dài của nó, tạo thành một `IntStream`.
4. **`flatMapToInt(...)`**: "Làm phẳng" tất cả các `IntStream` thành một `IntStream` duy nhất.
5. **`sum()`**: Tính tổng tất cả các độ dài.

#### Ví dụ 2: Tính tổng tất cả các số trong một danh sách các mảng số nguyên
Giả sử bạn có một danh sách các mảng số nguyên, và bạn muốn tính tổng của tất cả các số trong tất cả các mảng.

```java
import java.util.Arrays;
import java.util.List;

public class FlatMapToIntArrayExample {
	public static void main(String[] args) {
		List<int[]> listOfIntArrays = Arrays.asList(
				new int[]{1, 2, 3},
				new int[]{4, 5},
				new int[]{6, 7, 8, 9}
		);
		
		int totalSum = listOfIntArrays.stream()
				.flatMapToInt(Arrays::stream)  // Làm phẳng tất cả các mảng thành một IntStream
				.sum();  // Tính tổng tất cả các phần tử
		
		System.out.println("Total sum of all elements: " + totalSum);  // Output: Total sum of all elements: 45
	}
}
```

#### Giải thích:
1. **`Arrays::stream`**: Chuyển đổi mỗi mảng `int[]` thành một `IntStream`.
2. **`flatMapToInt(...)`**: "Làm phẳng" tất cả các `IntStream` thành một `IntStream` duy nhất.
3. **`sum()`**: Tính tổng tất cả các giá trị `int` trong `IntStream` kết quả.

### Tóm lại:
- **`flatMapToInt`** giúp chuyển đổi và hợp nhất nhiều `IntStream` thành một `IntStream` duy nhất.
- Nó rất hữu ích trong các tình huống cần xử lý nhiều chuỗi giá trị `int` liên tục từ các nguồn dữ liệu khác nhau, sau đó thực hiện các phép toán trên `IntStream` kết quả.

Cả hai ví dụ trên đều minh họa việc sử dụng `flatMapToInt` để tính tổng các giá trị `int` từ các nguồn dữ liệu phức tạp (chuỗi hoặc mảng).