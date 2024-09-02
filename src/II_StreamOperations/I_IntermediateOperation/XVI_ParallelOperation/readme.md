### Hàm `parallel()` trong Java Stream API

**`parallel()`** là một phương thức trong Java Stream API được sử dụng để chuyển đổi một `Stream` tuần tự (sequential stream) thành một `Parallel Stream` (stream song song). Khi một `Stream` trở thành `Parallel Stream`, các thao tác trên các phần tử của `Stream` có thể được thực hiện đồng thời trên nhiều luồng (threads), giúp cải thiện hiệu suất cho các tác vụ có thể chạy song song.

### Cú pháp:
```java
Stream<T> parallel()
```

### Mục đích:
Hàm `parallel()` giúp bạn tận dụng khả năng xử lý song song của CPU đa lõi. Khi gọi `parallel()` trên một `Stream`, các thao tác tiếp theo trên `Stream` sẽ được thực hiện đồng thời bởi nhiều luồng, cho phép bạn xử lý một lượng lớn dữ liệu nhanh hơn so với xử lý tuần tự.

### Ví dụ cơ bản:

#### Ví dụ 1: Sử dụng `parallel()` để tính tổng
Giả sử bạn có một danh sách các số nguyên và muốn tính tổng của chúng một cách song song.

```java
import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = numbers.stream()
                         .parallel()  // Chuyển đổi sang Parallel Stream
                         .mapToInt(Integer::intValue)
                         .sum();

        System.out.println("Sum: " + sum);  // Output: Sum: 55
    }
}
```

#### Giải thích:
- **`numbers.stream()`**: Tạo một `Stream` tuần tự từ danh sách các số nguyên.
- **`parallel()`**: Chuyển `Stream` này thành một `Parallel Stream`, cho phép các phần tử được xử lý song song.
- **`mapToInt(Integer::intValue)`**: Ánh xạ các đối tượng `Integer` thành các giá trị nguyên thủy `int`.
- **`sum()`**: Tính tổng tất cả các giá trị `int` trong `Stream`.

### Khi nào nên dùng `parallel()`?

#### Sử dụng `parallel()` phù hợp khi:
- **Khối lượng dữ liệu lớn**: Khi bạn có một tập dữ liệu lớn mà việc xử lý tuần tự có thể mất nhiều thời gian.
- **Cấu hình CPU đa lõi**: Khi chương trình chạy trên một hệ thống có nhiều lõi CPU, việc sử dụng `parallel()` có thể giúp tăng tốc độ xử lý.
- **Tác vụ phức tạp**: Khi các thao tác trên dữ liệu là phức tạp và đòi hỏi nhiều thời gian tính toán.

#### Cần cân nhắc khi dùng `parallel()`:
- **Overhead từ việc quản lý luồng**: Việc chia nhỏ công việc và quản lý luồng có thể tạo ra thêm overhead, đặc biệt là với tập dữ liệu nhỏ hoặc tác vụ đơn giản, khiến việc xử lý song song có thể chậm hơn so với tuần tự.
- **Tính thread-safe**: Khi xử lý song song, bạn cần đảm bảo các thao tác trên dữ liệu là thread-safe để tránh các vấn đề về cạnh tranh dữ liệu (data race).

### Ví dụ nâng cao: Kiểm tra hiệu suất giữa `Stream` và `Parallel Stream`
Dưới đây là một ví dụ đơn giản để so sánh thời gian xử lý giữa `Stream` tuần tự và `Parallel Stream`.

```java
import java.util.stream.LongStream;

public class StreamPerformanceComparison {
    public static void main(String[] args) {
        long n = 10_000_000;

        // Tính toán với Stream tuần tự
        long startTime = System.currentTimeMillis();
        long sequentialSum = LongStream.rangeClosed(1, n).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential sum: " + sequentialSum + " in " + (endTime - startTime) + " ms");

        // Tính toán với Parallel Stream
        startTime = System.currentTimeMillis();
        long parallelSum = LongStream.rangeClosed(1, n).parallel().sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel sum: " + parallelSum + " in " + (endTime - startTime) + " ms");
    }
}
```

### Kết quả:
- **Sequential sum**: Tổng tính toán theo cách tuần tự.
- **Parallel sum**: Tổng tính toán bằng cách sử dụng `Parallel Stream`.

Trong trường hợp này, bạn sẽ thấy `Parallel Stream` có thể nhanh hơn đáng kể khi xử lý dữ liệu lớn, nhưng điều này còn tùy thuộc vào cấu hình hệ thống và bản chất của công việc.

### Tóm lại:
- **`parallel()`** là một phương thức mạnh mẽ trong Java Stream API, cho phép xử lý dữ liệu song song.
- Nó giúp tận dụng tối đa tài nguyên CPU, nhưng cũng cần được sử dụng một cách khôn ngoan để tránh các vấn đề về hiệu suất và tính đồng thời.
- `parallel()` có thể mang lại lợi ích lớn khi xử lý dữ liệu lớn hoặc tác vụ phức tạp trên hệ thống có CPU đa lõi.