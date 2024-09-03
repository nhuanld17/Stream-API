### Thao tác `noneMatch` trong Java Stream API

**`noneMatch`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để kiểm tra xem không có bất kỳ phần tử nào trong `Stream` thỏa mãn một điều kiện cụ thể. Nó trả về một giá trị boolean (`true` hoặc `false`).

### Cú pháp:
```java
boolean noneMatch(Predicate<? super T> predicate)
```

- **`predicate`**: Là một biểu thức điều kiện (biểu thức lambda hoặc method reference) được sử dụng để kiểm tra các phần tử trong `Stream`.

### Mục đích:
`noneMatch` được sử dụng khi bạn muốn đảm bảo rằng không có phần tử nào trong `Stream` thỏa mãn điều kiện đã cho. Ngay khi tìm thấy một phần tử thỏa mãn điều kiện, `noneMatch` sẽ dừng kiểm tra và trả về `false`.

### Ví dụ sử dụng `noneMatch`:

#### Ví dụ 1: Kiểm tra xem không có số lẻ trong `Stream`
Giả sử bạn có một `Stream` các số nguyên và bạn muốn kiểm tra xem không có số lẻ nào trong `Stream`.

```java
import java.util.stream.Stream;

public class NoneMatchExample {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(2, 4, 6, 8, 10);

        boolean noOddNumbers = numbers.noneMatch(n -> n % 2 != 0);

        System.out.println("No odd numbers: " + noOddNumbers);  // Output: No odd numbers: true
    }
}
```

**Giải thích**:
- **`n -> n % 2 != 0`**: Lambda này kiểm tra xem một số có phải là số lẻ hay không.
- **`noneMatch(n -> n % 2 != 0)`**: Kiểm tra xem không có phần tử nào trong `Stream` là số lẻ. Vì tất cả các số trong `Stream` là số chẵn, `noneMatch` trả về `true`.

#### Ví dụ 2: Kiểm tra xem không có chuỗi nào bắt đầu bằng "Z"
Giả sử bạn có một `Stream` các chuỗi và bạn muốn kiểm tra xem không có chuỗi nào bắt đầu bằng chữ "Z".

```java
import java.util.stream.Stream;

public class NoneMatchStringExample {
    public static void main(String[] args) {
        Stream<String> names = Stream.of("Alice", "Bob", "Charlie");

        boolean noNamesStartWithZ = names.noneMatch(name -> name.startsWith("Z"));

        System.out.println("No names start with 'Z': " + noNamesStartWithZ);  // Output: No names start with 'Z': true
    }
}
```

**Giải thích**:
- **`name -> name.startsWith("Z")`**: Lambda này kiểm tra xem một chuỗi có bắt đầu bằng chữ "Z" hay không.
- **`noneMatch(name -> name.startsWith("Z"))`**: Kiểm tra xem không có phần tử nào trong `Stream` bắt đầu bằng chữ "Z". Vì không có tên nào trong `Stream` bắt đầu bằng "Z", `noneMatch` trả về `true`.

### Khi nào nên sử dụng `noneMatch`?

- **Khi bạn cần đảm bảo rằng không có phần tử nào trong `Stream` thỏa mãn điều kiện**: `noneMatch` rất hữu ích khi bạn muốn kiểm tra rằng một điều kiện không áp dụng cho bất kỳ phần tử nào trong `Stream`.
- **Khi bạn muốn dừng kiểm tra sớm**: `noneMatch` dừng lại ngay khi tìm thấy một phần tử thỏa mãn điều kiện, do đó có thể nhanh hơn so với việc kiểm tra toàn bộ `Stream` nếu phần tử phù hợp được tìm thấy sớm.

### Tóm lại:
- **`noneMatch`** là một thao tác kết thúc trong Java Stream API, dùng để kiểm tra xem không có phần tử nào trong `Stream` thỏa mãn một điều kiện cụ thể.
- Nó trả về `true` nếu không có phần tử nào thỏa mãn điều kiện, và `false` ngay khi tìm thấy một phần tử thỏa mãn điều kiện đó.
- `noneMatch` rất hữu ích khi bạn cần kiểm tra rằng một điều kiện không xảy ra đối với bất kỳ phần tử nào trong `Stream`.