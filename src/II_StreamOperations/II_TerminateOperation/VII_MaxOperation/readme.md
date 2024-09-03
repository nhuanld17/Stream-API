### Thao tác `max` trong Java Stream API

**`max`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để tìm phần tử lớn nhất trong một `Stream` dựa trên một `Comparator` được cung cấp. Kết quả trả về là một `Optional<T>`, bởi vì `Stream` có thể rỗng và trong trường hợp đó, sẽ không có phần tử nào để trả về.

### Cú pháp:
```java
Optional<T> max(Comparator<? super T> comparator)
```

- **`comparator`**: Là một `Comparator` được sử dụng để so sánh các phần tử trong `Stream`.

### Mục đích:
`max` được sử dụng để tìm phần tử lớn nhất trong `Stream` theo một tiêu chí cụ thể, chẳng hạn như giá trị số, độ dài chuỗi, hoặc bất kỳ thuộc tính nào khác mà bạn có thể xác định thông qua `Comparator`.

### Ví dụ sử dụng `max`:

#### Ví dụ 1: Tìm số lớn nhất trong một `Stream` các số nguyên
Giả sử bạn có một `Stream` các số nguyên và bạn muốn tìm số lớn nhất.

```java
import java.util.Optional;
import java.util.stream.Stream;

public class MaxExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(5, 10, 3, 7, 2, 9);

        Optional<Integer> max = numbers.max((a, b) -> a - b);

        max.ifPresent(System.out::println);  // Output: 10
    }
}
```

**Giải thích**:
- **`max((a, b) -> a - b)`**: Lambda này so sánh hai số nguyên `a` và `b`, trả về số lớn hơn. Đây là cách đơn giản để tìm phần tử lớn nhất trong `Stream`.
- **`Optional<Integer>`**: Kết quả trả về là một `Optional`, để xử lý trường hợp `Stream` rỗng. Nếu `Stream` có phần tử, giá trị lớn nhất sẽ được trả về.

#### Ví dụ 2: Tìm chuỗi có độ dài lớn nhất trong một `Stream` các chuỗi
Giả sử bạn có một `Stream` các chuỗi ký tự và bạn muốn tìm chuỗi có độ dài lớn nhất.

```java
import java.util.Optional;
import java.util.stream.Stream;

public class MaxStringLengthExample {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Java", "Stream", "API", "Maximum", "Example");

        Optional<String> maxLengthWord = words.max((s1, s2) -> s1.length() - s2.length());

        maxLengthWord.ifPresent(System.out::println);  // Output: Maximum
    }
}
```

**Giải thích**:
- **`max((s1, s2) -> s1.length() - s2.length())`**: Lambda này so sánh độ dài của hai chuỗi, trả về chuỗi có độ dài lớn hơn.
- **`Optional<String>`**: Kết quả trả về là một `Optional` chứa chuỗi có độ dài lớn nhất, hoặc rỗng nếu `Stream` không có phần tử nào.

### Khi nào nên sử dụng `max`?

- **Khi bạn cần tìm phần tử lớn nhất**: `max` là lựa chọn lý tưởng khi bạn cần tìm phần tử lớn nhất trong `Stream` dựa trên một tiêu chí so sánh cụ thể.
- **Khi bạn xử lý các `Stream` có thể rỗng**: Sử dụng `Optional` giúp bạn xử lý an toàn trong trường hợp `Stream` không có phần tử nào.

### Tóm lại:
- **`max`** là một thao tác kết thúc trong Java Stream API, cho phép bạn tìm phần tử lớn nhất trong `Stream` dựa trên một `Comparator`.
- Kết quả của `max` là một `Optional`, giúp bạn xử lý các trường hợp `Stream` rỗng một cách an toàn.
- `max` rất hữu ích khi bạn cần so sánh các phần tử trong `Stream` và tìm ra giá trị lớn nhất dựa trên một tiêu chí cụ thể.