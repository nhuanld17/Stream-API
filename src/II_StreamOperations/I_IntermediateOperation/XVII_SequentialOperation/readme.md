### Thao tác `sequential()` trong Java Stream API

**`sequential()`** là một phương thức trong Java Stream API được sử dụng để đảm bảo rằng một `Stream` sẽ được xử lý tuần tự, tức là từng phần tử trong `Stream` sẽ được xử lý lần lượt trên một luồng duy nhất. Điều này trái ngược với xử lý song song (parallel processing), nơi các phần tử có thể được xử lý đồng thời trên nhiều luồng.

### Cú pháp:
```java
Stream<T> sequential()
```

### Mục đích:
- **`sequential()`** được sử dụng để chuyển một `Parallel Stream` trở lại thành một `Sequential Stream` (stream tuần tự).
- Nếu `Stream` hiện tại đã là tuần tự, việc gọi `sequential()` sẽ không thay đổi gì.
- `sequential()` đảm bảo rằng các thao tác trên `Stream` sẽ được thực hiện theo thứ tự xuất hiện của các phần tử trong nguồn dữ liệu, một cách tuần tự, không song song.

### Khi nào nên dùng `sequential()`?

- **Khi bạn cần đảm bảo thứ tự xử lý**: Một số tác vụ yêu cầu xử lý theo thứ tự, ví dụ như ghi dữ liệu ra file hoặc thực hiện các phép toán mà kết quả phụ thuộc vào thứ tự của các phần tử.
- **Khi song song không hiệu quả**: Nếu bạn nhận thấy rằng `Parallel Stream` không mang lại hiệu suất tốt hơn hoặc thậm chí làm chậm quá trình xử lý do overhead quản lý luồng, bạn có thể sử dụng `sequential()` để đảm bảo xử lý tuần tự.

### Ví dụ cơ bản:

#### Ví dụ 1: Chuyển `Parallel Stream` thành `Sequential Stream`
Giả sử bạn có một `Stream` mà bạn đã chuyển thành song song, và bạn muốn chuyển nó trở lại chế độ tuần tự.

```java
import java.util.Arrays;
import java.util.List;

public class SequentialStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Tạo một Parallel Stream
        numbers.stream()
               .parallel()  // Chuyển thành Parallel Stream
               .sequential()  // Chuyển trở lại thành Sequential Stream
               .forEach(System.out::println);  // In ra các số theo thứ tự tuần tự
    }
}
```

#### Giải thích:
1. **`parallel()`**: Chuyển `Stream` tuần tự thành `Parallel Stream`.
2. **`sequential()`**: Chuyển `Stream` song song trở lại thành tuần tự, đảm bảo các phần tử được xử lý theo thứ tự xuất hiện ban đầu.

### Ví dụ 2: Sử dụng `sequential()` khi cần đảm bảo thứ tự xử lý

```java
import java.util.stream.IntStream;

public class SequentialStreamOrderingExample {
    public static void main(String[] args) {
        IntStream.range(1, 10)
                 .parallel()  // Chuyển thành Parallel Stream
                 .sequential()  // Chuyển trở lại thành Sequential Stream
                 .forEach(System.out::println);  // In ra các số theo thứ tự tuần tự
    }
}
```

### Khi nào **không cần** sử dụng `sequential()`?
- **Mặc định, stream là tuần tự**: Khi bạn khởi tạo một `Stream` thông thường (từ `Collection`, `Array`, hoặc bất kỳ nguồn nào khác), nó mặc định là tuần tự, vì vậy bạn chỉ cần sử dụng `sequential()` nếu bạn đã chuyển `Stream` đó thành song song trước đó.
- **Không cần thiết nếu stream đã là tuần tự**: Nếu bạn chắc chắn `Stream` của bạn đã là tuần tự và không cần chuyển đổi từ song song, thì bạn không cần gọi `sequential()`.

### Tóm lại:
- **`sequential()`** là một phương thức trong Java Stream API giúp bạn đảm bảo rằng `Stream` sẽ được xử lý tuần tự, không song song.
- Nó đặc biệt hữu ích khi bạn muốn chuyển đổi một `Parallel Stream` trở lại thành tuần tự hoặc khi bạn cần đảm bảo rằng các thao tác trên `Stream` được thực hiện theo thứ tự xuất hiện của các phần tử.
- `sequential()` có thể được sử dụng để kiểm soát cách xử lý dữ liệu, giúp bạn linh hoạt trong việc chọn giữa xử lý tuần tự và song song dựa trên yêu cầu cụ thể của ứng dụng.