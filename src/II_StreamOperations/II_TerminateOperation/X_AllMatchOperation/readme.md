### Thao tác `allMatch` trong Java Stream API

**`allMatch`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để kiểm tra xem tất cả các phần tử trong `Stream` có thỏa mãn một điều kiện cụ thể hay không. Nó trả về một giá trị boolean (`true` hoặc `false`).

### Cú pháp:
```java
boolean allMatch(Predicate<? super T> predicate)
```

- **`predicate`**: Là một biểu thức điều kiện (biểu thức lambda hoặc method reference) được sử dụng để kiểm tra các phần tử trong `Stream`.

### Mục đích:
`allMatch` được sử dụng khi bạn muốn kiểm tra xem tất cả các phần tử trong `Stream` có thỏa mãn một điều kiện nhất định hay không. Ngay khi tìm thấy một phần tử không thỏa mãn điều kiện, `allMatch` sẽ dừng kiểm tra các phần tử còn lại và trả về `false`.

### Ví dụ sử dụng `allMatch`:

#### Ví dụ 1: Kiểm tra xem tất cả các số trong `Stream` có phải là số chẵn không
Giả sử bạn có một `Stream` các số nguyên và bạn muốn kiểm tra xem tất cả các số trong `Stream` có phải là số chẵn không.

```java
import java.util.stream.Stream;

public class AllMatchExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(2, 4, 6, 8, 10);

        boolean allEven = numbers.allMatch(n -> n % 2 == 0);

        System.out.println("All numbers are even: " + allEven);  // Output: All numbers are even: true
    }
}
```

**Giải thích**:
- **`n -> n % 2 == 0`**: Lambda này kiểm tra xem một số có phải là số chẵn hay không.
- **`allMatch(n -> n % 2 == 0)`**: Kiểm tra xem tất cả các phần tử trong `Stream` có thỏa mãn điều kiện là số chẵn hay không. Vì tất cả các số trong `Stream` đều là số chẵn, `allMatch` trả về `true`.

#### Ví dụ 2: Kiểm tra xem tất cả các chuỗi trong `Stream` có bắt đầu bằng chữ "A" không
Giả sử bạn có một `Stream` các chuỗi và bạn muốn kiểm tra xem tất cả các chuỗi trong `Stream` có bắt đầu bằng chữ "A" không.

```java
import java.util.stream.Stream;

public class AllMatchStringExample {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("Alice", "Adam", "Alex");

        boolean allStartWithA = names.allMatch(name -> name.startsWith("A"));

        System.out.println("All names start with 'A': " + allStartWithA);  // Output: All names start with 'A': true
    }
}
```

**Giải thích**:
- **`name -> name.startsWith("A")`**: Lambda này kiểm tra xem một chuỗi có bắt đầu bằng chữ "A" hay không.
- **`allMatch(name -> name.startsWith("A"))`**: Kiểm tra xem tất cả các phần tử trong `Stream` có thỏa mãn điều kiện bắt đầu bằng chữ "A" hay không. Vì tất cả các chuỗi đều bắt đầu bằng chữ "A", `allMatch` trả về `true`.

### Khi nào nên sử dụng `allMatch`?

- **Khi bạn cần kiểm tra tất cả các phần tử trong `Stream`**: `allMatch` rất hữu ích khi bạn muốn đảm bảo rằng mọi phần tử trong `Stream` đều thỏa mãn một điều kiện cụ thể.
- **Khi bạn muốn dừng kiểm tra sớm**: `allMatch` dừng lại ngay khi tìm thấy một phần tử không thỏa mãn điều kiện, do đó có thể nhanh hơn so với việc kiểm tra toàn bộ `Stream` nếu phần tử không phù hợp được tìm thấy sớm.

### Tóm lại:
- **`allMatch`** là một thao tác kết thúc trong Java Stream API, dùng để kiểm tra xem tất cả các phần tử trong `Stream` có thỏa mãn một điều kiện cụ thể hay không.
- Nó trả về `true` nếu tất cả các phần tử đều thỏa mãn điều kiện, và `false` ngay khi tìm thấy một phần tử không thỏa mãn điều kiện đó.
- `allMatch` rất hữu ích trong các tình huống cần kiểm tra sự đồng nhất của các phần tử trong `Stream` dựa trên một điều kiện nhất định.