### Thao tác `forEachOrdered` trong Java Stream API

**`forEachOrdered`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để thực hiện một hành động nào đó trên mỗi phần tử của `Stream` theo thứ tự xuất hiện của chúng trong `Stream`, ngay cả khi bạn đang làm việc với một `Parallel Stream`.

### Cú pháp:
```java
void forEachOrdered(Consumer<? super T> action)
```

- **`action`**: Là một biểu thức lambda hoặc method reference, đại diện cho hành động sẽ được thực hiện trên từng phần tử của `Stream`.

### Mục đích:
- **Đảm bảo thứ tự xử lý**: `forEachOrdered` được sử dụng khi bạn cần đảm bảo rằng các phần tử của `Stream` được xử lý theo đúng thứ tự xuất hiện ban đầu, đặc biệt khi làm việc với `Parallel Stream`. Đây là điểm khác biệt chính so với `forEach`, vì `forEach` không đảm bảo thứ tự khi được sử dụng với `Parallel Stream`.

### Ví dụ cơ bản:

#### Ví dụ 1: In ra các phần tử của `Stream` theo thứ tự
Giả sử bạn có một `Stream` các số nguyên và bạn muốn in ra từng số theo thứ tự xuất hiện ban đầu, ngay cả khi sử dụng `Parallel Stream`.

```java
import java.util.stream.IntStream;

public class ForEachOrderedExample {
    public static void main(String[] args) {
        IntStream.range(1, 10)
                 .parallel()  // Chuyển sang Parallel Stream
                 .forEachOrdered(System.out::println);  // In ra từng số theo thứ tự ban đầu
    }
}
```

#### Kết quả:
```
1
2
3
4
5
6
7
8
9
```

### Giải thích:
- **`IntStream.range(1, 10)`**: Tạo một `IntStream` tuần tự chứa các số từ 1 đến 9.
- **`parallel()`**: Chuyển `Stream` tuần tự thành `Parallel Stream`, cho phép xử lý các phần tử đồng thời.
- **`forEachOrdered(System.out::println)`**: In ra từng phần tử theo đúng thứ tự xuất hiện trong `Stream`, đảm bảo thứ tự ngay cả khi xử lý song song.

### Khi nào nên sử dụng `forEachOrdered`?
- **Khi làm việc với `Parallel Stream`**: Nếu bạn cần xử lý các phần tử song song nhưng vẫn cần đảm bảo thứ tự xử lý, `forEachOrdered` là lựa chọn phù hợp.
- **Khi kết quả đầu ra cần có thứ tự cụ thể**: Ví dụ, nếu bạn đang xử lý dữ liệu mà kết quả đầu ra cần được giữ theo thứ tự cụ thể (như khi in dữ liệu ra console hoặc ghi dữ liệu ra file), `forEachOrdered` sẽ đảm bảo tính tuần tự.

### So sánh `forEach` và `forEachOrdered`:

- **`forEach`**:
    - Cho phép xử lý các phần tử của `Stream` mà không đảm bảo thứ tự, đặc biệt là trong `Parallel Stream`.
    - Nhanh hơn `forEachOrdered` trong `Parallel Stream` vì nó không phải duy trì thứ tự.

- **`forEachOrdered`**:
    - Đảm bảo rằng các phần tử được xử lý theo thứ tự xuất hiện ban đầu.
    - Có thể chậm hơn `forEach` trong `Parallel Stream` do phải duy trì thứ tự xử lý.

### Ví dụ 2: So sánh `forEach` và `forEachOrdered` trong `Parallel Stream`

```java
import java.util.Arrays;
import java.util.List;

public class ForEachVsForEachOrdered {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Using forEach:");
        numbers.parallelStream()
               .forEach(System.out::println);  // Kết quả có thể không theo thứ tự

        System.out.println("\nUsing forEachOrdered:");
        numbers.parallelStream()
               .forEachOrdered(System.out::println);  // Kết quả sẽ theo thứ tự
    }
}
```

#### Kết quả (có thể khác nhau):
```
Using forEach:
5
2
1
4
3
6
7
9
8
10

Using forEachOrdered:
1
2
3
4
5
6
7
8
9
10
```

### Tóm lại:
- **`forEachOrdered`** là một thao tác kết thúc trong Java Stream API, được sử dụng để đảm bảo rằng các phần tử của `Stream` được xử lý theo đúng thứ tự xuất hiện ban đầu, ngay cả khi làm việc với `Parallel Stream`.
- Nó đặc biệt hữu ích khi thứ tự của các phần tử là quan trọng trong quá trình xử lý hoặc xuất kết quả.