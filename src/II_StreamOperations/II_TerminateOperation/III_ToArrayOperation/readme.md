### Thao tác `toArray` trong Java Stream API

**`toArray`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để chuyển đổi các phần tử của `Stream` thành một mảng (array). Đây là một cách tiện lợi để thu thập các phần tử từ `Stream` và lưu trữ chúng trong một mảng, thay vì sử dụng các cấu trúc dữ liệu khác như `List` hay `Set`.

### Cú pháp:
`toArray` có hai phiên bản:

1. **`Object[] toArray()`**
    - Chuyển đổi các phần tử của `Stream` thành một mảng kiểu `Object[]`.
    - Ví dụ: `Object[] array = stream.toArray();`

2. **`<A> A[] toArray(IntFunction<A[]> generator)`**
    - Chuyển đổi các phần tử của `Stream` thành một mảng với kiểu cụ thể được xác định bởi hàm generator.
    - Ví dụ: `String[] array = stream.toArray(String[]::new);`

### Mục đích:
`toArray` được sử dụng khi bạn muốn chuyển đổi kết quả từ `Stream` thành một mảng, để bạn có thể truy cập các phần tử bằng chỉ số hoặc sử dụng các phương thức liên quan đến mảng.

### Ví dụ sử dụng `toArray`:

#### Ví dụ 1: Sử dụng `toArray()` để chuyển `Stream` thành mảng `Object[]`
Giả sử bạn có một `Stream` các số nguyên và bạn muốn chuyển chúng thành một mảng `Object[]`.

```java
import java.util.stream.Stream;

public class ToArrayExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        Object[] array = stream.toArray();

        for (Object obj : array) {
            System.out.println(obj);
        }
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
```

### Giải thích:
- **`Stream.of(1, 2, 3, 4, 5)`**: Tạo một `Stream` chứa các số nguyên.
- **`toArray()`**: Chuyển đổi `Stream` này thành một mảng `Object[]`.
- **`for (Object obj : array)`**: Lặp qua mảng và in ra từng phần tử.

#### Ví dụ 2: Sử dụng `toArray(IntFunction<A[]> generator)` để chuyển `Stream` thành mảng với kiểu cụ thể
Giả sử bạn có một `Stream` các chuỗi ký tự và muốn chuyển chúng thành một mảng `String[]`.

```java
import java.util.stream.Stream;

public class ToArraySpecificTypeExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("apple", "banana", "cherry");

        String[] array = stream.toArray(String[]::new);

        for (String str : array) {
            System.out.println(str);
        }
    }
}
```

#### Kết quả:
```
apple
banana
cherry
```

### Giải thích:
- **`Stream.of("apple", "banana", "cherry")`**: Tạo một `Stream` chứa các chuỗi ký tự.
- **`toArray(String[]::new)`**: Sử dụng phiên bản `toArray` với hàm generator để chuyển đổi `Stream` thành mảng `String[]`.
- **`for (String str : array)`**: Lặp qua mảng và in ra từng phần tử.

### Khi nào nên sử dụng `toArray`?
- **Khi cần mảng**: Sử dụng `toArray` khi bạn cần truy cập các phần tử của `Stream` bằng chỉ số, hoặc khi bạn muốn sử dụng mảng như một cấu trúc dữ liệu để lưu trữ các phần tử.
- **Khi hiệu suất quan trọng**: Trong một số trường hợp, việc sử dụng mảng có thể tối ưu hơn so với các cấu trúc dữ liệu khác về mặt hiệu suất, đặc biệt khi bạn không cần các tính năng bổ sung của `List` hoặc `Set`.

### Lưu ý:
- **Không thể sử dụng lại `Stream`**: Sau khi gọi `toArray`, `Stream` sẽ bị "tiêu thụ" và không thể sử dụng lại. Mỗi lần gọi `toArray` đều cần một `Stream` mới.
- **Chọn phiên bản phù hợp**: Nếu bạn biết kiểu của các phần tử trong `Stream`, hãy sử dụng phiên bản `toArray(IntFunction<A[]> generator)` để tạo ra mảng với kiểu cụ thể thay vì kiểu `Object[]`.

### Tóm lại:
- **`toArray`** là một thao tác kết thúc trong Java Stream API, cho phép bạn chuyển đổi các phần tử trong `Stream` thành một mảng.
- Nó có hai phiên bản: một phiên bản trả về mảng `Object[]` và một phiên bản trả về mảng với kiểu cụ thể do bạn chỉ định.
- `toArray` rất hữu ích khi bạn cần truy cập các phần tử bằng chỉ số hoặc làm việc với các API yêu cầu đầu vào là mảng.