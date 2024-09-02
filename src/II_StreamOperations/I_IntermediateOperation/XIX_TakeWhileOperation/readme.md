### Thao tác `takeWhile` trong Java Stream API

**`takeWhile`** là một thao tác trung gian (intermediate operation) trong Java Stream API, được giới thiệu từ Java 9. Thao tác này cho phép bạn lấy các phần tử từ `Stream` cho đến khi gặp một phần tử không thỏa mãn điều kiện được chỉ định. Khi gặp phần tử đầu tiên không thỏa mãn điều kiện, `takeWhile` sẽ ngừng lấy thêm phần tử, và các phần tử sau đó sẽ bị bỏ qua, ngay cả khi chúng có thể thỏa mãn điều kiện.

### Cú pháp:
```java
Stream<T> takeWhile(Predicate<? super T> predicate)
```

- **`predicate`**: Là một biểu thức điều kiện (biểu thức lambda hoặc method reference) kiểm tra xem phần tử có thỏa mãn điều kiện hay không.

### Mục đích:
`takeWhile` hữu ích khi bạn muốn lấy các phần tử ở đầu `Stream` cho đến khi một điều kiện nào đó không còn đúng. Thao tác này rất hiệu quả với các `Stream` có thứ tự hoặc được sắp xếp, vì nó ngừng lấy thêm phần tử ngay khi điều kiện không còn đúng.

### Ví dụ cơ bản:

#### Ví dụ 1: Lấy các số nhỏ hơn 5 từ `Stream`
Giả sử bạn có một `Stream` các số nguyên, và bạn muốn lấy tất cả các số nhỏ hơn 5 từ `Stream`.

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TakeWhileExample {
    public static void main(String[] args) {
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                                      .takeWhile(n -> n < 5)  // Lấy các phần tử nhỏ hơn 5
                                      .collect(Collectors.toList());

        System.out.println(numbers);  // Output: [1, 2, 3, 4]
    }
}
```

#### Giải thích:
1. **`Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)`**: Tạo một `Stream` chứa các số từ 1 đến 10.
2. **`takeWhile(n -> n < 5)`**: Lấy các phần tử từ `Stream` cho đến khi gặp phần tử không thỏa mãn điều kiện (ở đây là số 5).
3. **`collect(Collectors.toList())`**: Thu thập các phần tử thỏa mãn điều kiện vào một `List`.

### Lưu ý:
- `takeWhile` ngừng lấy phần tử ngay khi gặp phần tử không thỏa mãn điều kiện đầu tiên, và nó sẽ không kiểm tra các phần tử sau đó, ngay cả khi chúng thỏa mãn điều kiện.
- `takeWhile` hoạt động tốt nhất với các `Stream` đã được sắp xếp hoặc có thứ tự, vì thứ tự này ảnh hưởng đến việc thao tác sẽ ngừng lại ở đâu.

#### Ví dụ 2: Sử dụng `takeWhile` với chuỗi ký tự
Giả sử bạn có một `Stream` các chuỗi ký tự, và bạn muốn lấy tất cả các chuỗi bắt đầu bằng chữ cái trước khi gặp chuỗi không thỏa mãn điều kiện.

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TakeWhileStringExample {
    public static void main(String[] args) {
        List<String> words = Stream.of("apple", "banana", "apricot", "orange", "avocado")
                                   .takeWhile(s -> s.startsWith("a"))  // Lấy các chuỗi bắt đầu bằng "a"
                                   .collect(Collectors.toList());

        System.out.println(words);  // Output: [apple, apricot]
    }
}
```

#### Giải thích:
1. **`Stream.of("apple", "banana", "apricot", "orange", "avocado")`**: Tạo một `Stream` chứa các chuỗi ký tự.
2. **`takeWhile(s -> s.startsWith("a"))`**: Lấy các phần tử bắt đầu bằng chữ cái "a" từ `Stream` cho đến khi gặp phần tử không thỏa mãn điều kiện (ở đây là "banana").
3. **`collect(Collectors.toList())`**: Thu thập các phần tử thỏa mãn điều kiện vào một `List`.

### So sánh `takeWhile` với các thao tác khác:
- **`filter`**: `filter` sẽ giữ lại tất cả các phần tử thỏa mãn điều kiện, bất kể thứ tự. Ngược lại, `takeWhile` ngừng lại ngay khi gặp phần tử đầu tiên không thỏa mãn điều kiện.
- **`dropWhile`**: `dropWhile` là thao tác ngược lại với `takeWhile`. Thay vì lấy các phần tử thỏa mãn điều kiện từ đầu, `dropWhile` bỏ qua các phần tử thỏa mãn điều kiện và bắt đầu lấy phần tử từ vị trí mà điều kiện không còn đúng.

### Tóm lại:
- **`takeWhile`** là một thao tác trung gian mạnh mẽ trong Java Stream API, cho phép bạn lấy các phần tử từ `Stream` cho đến khi gặp phần tử đầu tiên không thỏa mãn điều kiện.
- Nó đặc biệt hữu ích với các `Stream` có thứ tự hoặc đã sắp xếp, nơi bạn muốn ngừng xử lý ngay khi điều kiện không còn đúng.