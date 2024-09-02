Trong Java Stream API, thao tác `mapToInt` là một thao tác trung gian (intermediate operation) được sử dụng để chuyển đổi các phần tử trong một `Stream` thành các giá trị kiểu `int`. Kết quả của thao tác này là một `IntStream`, một phiên bản chuyên biệt của `Stream` dành cho các giá trị nguyên thủy kiểu `int`.

### Cú pháp:
```java
IntStream mapToInt(ToIntFunction<? super T> mapper)
```

- **`mapper`**: Một hàm chuyển đổi (thường là lambda expression hoặc method reference) được áp dụng cho mỗi phần tử của `Stream` để chuyển nó thành một giá trị kiểu `int`.

### Mục đích:
`mapToInt` thường được sử dụng khi bạn có một `Stream` chứa các đối tượng và bạn muốn ánh xạ chúng thành các giá trị nguyên thủy `int` để thực hiện các phép toán như tính tổng, tính trung bình, hoặc để tận dụng các phương thức chuyên biệt của `IntStream`.

### Ví dụ sử dụng `mapToInt`:

Giả sử bạn có một danh sách các chuỗi và bạn muốn tính tổng độ dài của tất cả các chuỗi trong danh sách:

```java
import java.util.Arrays;
import java.util.List;

public class MapToIntExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        int totalLength = words.stream()
                               .mapToInt(String::length)  // Ánh xạ từng chuỗi thành độ dài của nó
                               .sum();  // Tính tổng các giá trị int

        System.out.println("Total length: " + totalLength);  // Output: Total length: 17
    }
}
```

### Kết quả:
```
Total length: 17
```

### Các phương thức hữu ích của `IntStream`:
Sau khi chuyển đổi `Stream` thành `IntStream`, bạn có thể sử dụng các phương thức hữu ích khác mà `IntStream` cung cấp, chẳng hạn như:

- **`sum()`**: Tính tổng các giá trị `int` trong `IntStream`.
- **`average()`**: Tính trung bình của các giá trị `int`.
- **`max()`**: Tìm giá trị lớn nhất.
- **`min()`**: Tìm giá trị nhỏ nhất.
- **`count()`**: Đếm số lượng phần tử trong `IntStream`.
- **`boxed()`**: Chuyển `IntStream` thành `Stream<Integer>` nếu bạn cần quay lại kiểu đối tượng.

### Ví dụ thêm:

Tính trung bình độ dài của các chuỗi trong danh sách:

```java
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapToIntAverageExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        OptionalDouble averageLength = words.stream()
                                            .mapToInt(String::length)  // Ánh xạ từng chuỗi thành độ dài của nó
                                            .average();  // Tính giá trị trung bình

        averageLength.ifPresent(avg -> System.out.println("Average length: " + avg));  // Output: Average length: 5.666666666666667
    }
}
```

### Kết quả:
```
Average length: 5.666666666666667
```

`mapToInt` là một thao tác hữu ích khi bạn cần làm việc với các giá trị nguyên thủy `int` trong Java, đặc biệt là khi bạn muốn thực hiện các phép toán số học trên các phần tử trong `Stream`.