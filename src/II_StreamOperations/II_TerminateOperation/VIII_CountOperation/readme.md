### Thao tác `count` trong Java Stream API

**`count`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để đếm số lượng phần tử trong một `Stream`. Kết quả trả về là một giá trị kiểu `long`, đại diện cho số lượng phần tử trong `Stream`.

### Cú pháp:
```java
long count()
```

### Mục đích:
`count` được sử dụng khi bạn muốn biết số lượng phần tử có trong `Stream`. Nó đặc biệt hữu ích khi bạn cần đếm các phần tử sau khi đã áp dụng các thao tác lọc (`filter`), chuyển đổi (`map`), hoặc bất kỳ thao tác trung gian nào khác.

### Ví dụ sử dụng `count`:

#### Ví dụ 1: Đếm số lượng phần tử trong một `Stream`
Giả sử bạn có một `Stream` các số nguyên và bạn muốn đếm số lượng phần tử trong `Stream`.

```java
import java.util.stream.Stream;

public class CountExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long count = numbers.count();

        System.out.println("Number of elements: " + count);  // Output: Number of elements: 10
    }
}
```

**Giải thích**:
- **`numbers.count()`**: Đếm số lượng phần tử trong `Stream` và trả về giá trị `long`.

#### Ví dụ 2: Đếm số lượng phần tử sau khi lọc
Giả sử bạn có một `Stream` các số nguyên và bạn muốn đếm số lượng các số chẵn.

```java
import java.util.stream.Stream;

public class CountFilteredExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long count = numbers.filter(n -> n % 2 == 0).count();

        System.out.println("Number of even elements: " + count);  // Output: Number of even elements: 5
    }
}
```

**Giải thích**:
- **`filter(n -> n % 2 == 0)`**: Lọc các phần tử trong `Stream`, chỉ giữ lại các số chẵn.
- **`count()`**: Đếm số lượng phần tử còn lại sau khi lọc.

### Khi nào nên sử dụng `count`?

- **Khi bạn cần đếm số lượng phần tử trong `Stream`**: Sử dụng `count` là cách đơn giản và hiệu quả nhất để biết có bao nhiêu phần tử trong `Stream`, đặc biệt sau khi đã áp dụng các thao tác trung gian.
- **Khi bạn cần một giá trị số nguyên biểu diễn số lượng phần tử**: Kết quả của `count` là một giá trị kiểu `long`, có thể dùng trong các phép toán hoặc kiểm tra logic khác.

### Lưu ý:
- `count` là một thao tác kết thúc, tức là sau khi gọi `count`, `Stream` sẽ không thể sử dụng lại được.
- Nếu `Stream` có các phần tử lớn hoặc vô hạn, hãy cẩn thận với hiệu suất khi sử dụng `count`.

### Tóm lại:
- **`count`** là một thao tác kết thúc trong Java Stream API, dùng để đếm số lượng phần tử trong `Stream`.
- Nó trả về một giá trị `long`, biểu thị số lượng phần tử, và rất hữu ích khi bạn cần biết số lượng phần tử trong `Stream` sau khi đã áp dụng các thao tác trung gian khác.