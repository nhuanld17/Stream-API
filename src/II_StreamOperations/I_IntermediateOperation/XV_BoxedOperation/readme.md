Trong Java Stream API, thao tác `boxed()` là một thao tác trung gian (intermediate operation) được sử dụng để chuyển đổi một stream của các giá trị nguyên thủy (như `IntStream`, `LongStream`, `DoubleStream`) thành một stream của các đối tượng wrapper tương ứng (như `Stream<Integer>`, `Stream<Long>`, `Stream<Double>`).

### Mục đích:
Java có các kiểu nguyên thủy (`int`, `long`, `double`, v.v.) và các lớp đối tượng tương ứng (`Integer`, `Long`, `Double`, v.v.). Trong một số trường hợp, bạn cần chuyển đổi từ kiểu nguyên thủy sang đối tượng (quá trình này được gọi là "boxing") để có thể sử dụng các phương thức của `Stream` không có sẵn trong các stream nguyên thủy hoặc để tương thích với các API yêu cầu đối tượng thay vì kiểu nguyên thủy.

### Cú pháp:
```java
Stream<Integer> boxed()  // Đối với IntStream
Stream<Long> boxed()     // Đối với LongStream
Stream<Double> boxed()   // Đối với DoubleStream
```

### Ví dụ 1: Chuyển đổi `IntStream` thành `Stream<Integer>`
Giả sử bạn có một `IntStream` và bạn muốn chuyển đổi nó thành một `Stream<Integer>` để có thể sử dụng các phương thức của `Stream` mà chỉ làm việc với đối tượng.

```java
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoxedExample {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 5);  // Tạo IntStream từ 1 đến 4

        Stream<Integer> boxedStream = intStream.boxed();

        boxedStream.forEach(System.out::println);  // Output: 1, 2, 3, 4
    }
}
```

#### Giải thích:
1. **`IntStream.range(1, 5)`**: Tạo một `IntStream` từ 1 đến 4 (không bao gồm 5).
2. **`boxed()`**: Chuyển đổi `IntStream` thành `Stream<Integer>`.
3. **`forEach(System.out::println)`**: In từng giá trị của `Stream<Integer>`.

### Ví dụ 2: Tạo danh sách từ một `IntStream`
Giả sử bạn muốn chuyển đổi một `IntStream` thành một `List<Integer>` để lưu trữ và sử dụng sau này.

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxedListExample {
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1, 5)
                                             .boxed()  // Chuyển đổi IntStream thành Stream<Integer>
                                             .collect(Collectors.toList());  // Thu thập các phần tử thành một List

        System.out.println(integerList);  // Output: [1, 2, 3, 4, 5]
    }
}
```

#### Giải thích:
1. **`IntStream.rangeClosed(1, 5)`**: Tạo một `IntStream` từ 1 đến 5 (bao gồm 5).
2. **`boxed()`**: Chuyển đổi `IntStream` thành `Stream<Integer>`.
3. **`collect(Collectors.toList())`**: Thu thập các phần tử của `Stream<Integer>` thành một `List<Integer>`.

### Ví dụ 3: Sử dụng `boxed()` để tương tác với các API yêu cầu đối tượng
Trong một số trường hợp, các API yêu cầu các đối tượng thay vì các kiểu nguyên thủy. Ví dụ, nếu bạn muốn sử dụng `IntStream` với một phương thức yêu cầu `Stream<Integer>`, bạn cần sử dụng `boxed()`.

```java
import java.util.Optional;

public class BoxedExampleWithMax {
    public static void main(String[] args) {
        Optional<Integer> max = IntStream.of(10, 20, 30, 40, 50)
                                         .boxed()  // Chuyển đổi IntStream thành Stream<Integer>
                                         .max(Integer::compareTo);  // Tìm giá trị lớn nhất

        max.ifPresent(System.out::println);  // Output: 50
    }
}
```

#### Giải thích:
1. **`IntStream.of(10, 20, 30, 40, 50)`**: Tạo một `IntStream` từ các giá trị đã cho.
2. **`boxed()`**: Chuyển đổi `IntStream` thành `Stream<Integer>`.
3. **`max(Integer::compareTo)`**: Tìm giá trị lớn nhất trong `Stream<Integer>`.

### Tóm lại:
- **`boxed()`** được sử dụng khi bạn cần chuyển đổi một `IntStream`, `LongStream`, hoặc `DoubleStream` thành `Stream<Integer>`, `Stream<Long>`, hoặc `Stream<Double>` tương ứng.
- Nó rất hữu ích khi bạn cần tương tác với các API yêu cầu đối tượng thay vì kiểu nguyên thủy hoặc khi bạn muốn sử dụng các phương thức `Stream` chỉ khả dụng với đối tượng.