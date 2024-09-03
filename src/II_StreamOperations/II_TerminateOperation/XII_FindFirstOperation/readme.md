### Thao tác `findFirst` trong Java Stream API

**`findFirst`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để tìm và trả về phần tử đầu tiên trong `Stream`. Kết quả trả về là một `Optional<T>`, vì `Stream` có thể rỗng và trong trường hợp đó, sẽ không có phần tử nào để trả về.

### Cú pháp:
```java
Optional<T> findFirst()
```

### Mục đích:
`findFirst` được sử dụng khi bạn muốn lấy phần tử đầu tiên trong `Stream`, dựa trên thứ tự tự nhiên hoặc thứ tự được xác định trong `Stream`. Thao tác này đảm bảo rằng luôn trả về phần tử đầu tiên theo thứ tự mà `Stream` cung cấp.

### Ví dụ sử dụng `findFirst`:

#### Ví dụ 1: Tìm phần tử đầu tiên trong `Stream` các số nguyên
Giả sử bạn có một `Stream` các số nguyên và muốn lấy phần tử đầu tiên.

```java
import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(5, 10, 15, 20, 25);

        Optional<Integer> firstNumber = numbers.findFirst();

        firstNumber.ifPresent(System.out::println);  // Output: 5
    }
}
```

**Giải thích**:
- **`findFirst()`**: Tìm phần tử đầu tiên trong `Stream`. Vì `Stream` này tuần tự, kết quả sẽ là phần tử đầu tiên (`5`).
- **`Optional<Integer>`**: Kết quả trả về là một `Optional` chứa phần tử đầu tiên, hoặc rỗng nếu `Stream` không có phần tử nào.

#### Ví dụ 2: Tìm phần tử đầu tiên trong `Parallel Stream`
Khi làm việc với `Parallel Stream`, `findFirst` vẫn đảm bảo trả về phần tử đầu tiên theo thứ tự tự nhiên, bất kể các luồng khác xử lý song song.

```java
import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstParallelExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(5, 10, 15, 20, 25).parallel();

        Optional<Integer> firstNumber = numbers.findFirst();

        firstNumber.ifPresent(System.out::println);  // Output: 5
    }
}
```

**Giải thích**:
- **`Stream.of(5, 10, 15, 20, 25).parallel()`**: Tạo một `Parallel Stream`.
- **`findFirst()`**: Tìm phần tử đầu tiên trong `Parallel Stream`. Dù các phần tử được xử lý song song, `findFirst` vẫn đảm bảo trả về phần tử đầu tiên (`5`) theo thứ tự tự nhiên.

### Khi nào nên sử dụng `findFirst`?

- **Khi bạn cần phần tử đầu tiên theo thứ tự**: `findFirst` là lựa chọn lý tưởng khi bạn cần phần tử đầu tiên từ `Stream`, đặc biệt khi thứ tự là quan trọng.
- **Khi bạn xử lý dữ liệu tuần tự**: `findFirst` thường được sử dụng khi bạn có `Stream` tuần tự hoặc khi thứ tự các phần tử quan trọng.

### Sự khác biệt giữa `findFirst` và `findAny`:
- **`findFirst`**: Luôn trả về phần tử đầu tiên theo thứ tự tự nhiên hoặc thứ tự đã xác định trong `Stream`. Hữu ích khi thứ tự quan trọng.
- **`findAny`**: Trả về một phần tử bất kỳ mà không đảm bảo thứ tự, đặc biệt hữu ích trong `Parallel Stream` để tối ưu hóa hiệu suất.

### Tóm lại:
- **`findFirst`** là một thao tác kết thúc trong Java Stream API, dùng để tìm và trả về phần tử đầu tiên trong `Stream`.
- Nó trả về một `Optional`, chứa phần tử đầu tiên hoặc rỗng nếu `Stream` không có phần tử nào.
- `findFirst` đảm bảo trả về phần tử đầu tiên theo thứ tự tự nhiên hoặc thứ tự được xác định, ngay cả trong `Parallel Stream`.