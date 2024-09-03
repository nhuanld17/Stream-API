### Thao tác `min` trong Java Stream API

**`min`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để tìm phần tử nhỏ nhất trong một `Stream` dựa trên một `Comparator` được cung cấp. Kết quả trả về là một `Optional<T>` vì `Stream` có thể rỗng, và trong trường hợp đó, sẽ không có phần tử nào để trả về.

### Cú pháp:
```java
Optional<T> min(Comparator<? super T> comparator)
```

- **`comparator`**: Là một `Comparator` được sử dụng để so sánh các phần tử trong `Stream`.

### Mục đích:
`min` được sử dụng để tìm phần tử nhỏ nhất trong `Stream` theo một tiêu chí cụ thể, chẳng hạn như số lượng, độ dài chuỗi, hoặc bất kỳ thuộc tính nào khác mà bạn có thể xác định thông qua `Comparator`.

### Ví dụ sử dụng `min`:

#### Ví dụ 1: Tìm số nhỏ nhất trong một `Stream` các số nguyên
Giả sử bạn có một `Stream` các số nguyên và bạn muốn tìm số nhỏ nhất.

```java
import java.util.Optional;
import java.util.stream.Stream;

public class MinExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(5, 10, 3, 7, 2, 9);

        Optional<Integer> min = numbers.min((a, b) -> a - b);

        min.ifPresent(System.out::println);  // Output: 2
    }
}
```

**Giải thích**:
- **`min((a, b) -> a - b)`**: Lambda này so sánh hai số nguyên `a` và `b`, trả về số nhỏ hơn. Đây là cách đơn giản để tìm phần tử nhỏ nhất trong `Stream`.
- **`Optional<Integer>`**: Kết quả trả về là một `Optional` để xử lý trường hợp `Stream` rỗng. Nếu `Stream` có phần tử, giá trị nhỏ nhất sẽ được trả về.

#### Ví dụ 2: Tìm chuỗi có độ dài nhỏ nhất trong một `Stream` các chuỗi
Giả sử bạn có một `Stream` các chuỗi ký tự và bạn muốn tìm chuỗi có độ dài nhỏ nhất.

```java
import java.util.Optional;
import java.util.stream.Stream;

public class MinStringLengthExample {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Java", "Stream", "API", "Min", "Example");

        Optional<String> minLengthWord = words.min((s1, s2) -> s1.length() - s2.length());

        minLengthWord.ifPresent(System.out::println);  // Output: Min
    }
}
```

**Giải thích**:
- **`min((s1, s2) -> s1.length() - s2.length())`**: Lambda này so sánh độ dài của hai chuỗi, trả về chuỗi có độ dài ngắn hơn.
- **`Optional<String>`**: Kết quả trả về là một `Optional` chứa chuỗi có độ dài nhỏ nhất, hoặc rỗng nếu `Stream` không có phần tử nào.

### Khi nào nên sử dụng `min`?

- **Khi bạn cần tìm phần tử nhỏ nhất**: `min` là lựa chọn lý tưởng khi bạn cần tìm phần tử nhỏ nhất trong `Stream` dựa trên một tiêu chí so sánh cụ thể.
- **Khi bạn xử lý các `Stream` có thể rỗng**: Sử dụng `Optional` giúp bạn xử lý an toàn trong trường hợp `Stream` không có phần tử nào.

### Tóm lại:
- **`min`** là một thao tác kết thúc trong Java Stream API, cho phép bạn tìm phần tử nhỏ nhất trong `Stream` dựa trên một `Comparator`.
- Kết quả của `min` là một `Optional` để giúp bạn xử lý các trường hợp `Stream` rỗng một cách an toàn.
- `min` rất hữu ích khi bạn cần so sánh các phần tử trong `Stream` và tìm ra giá trị nhỏ nhất dựa trên một tiêu chí cụ thể.