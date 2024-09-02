### Thao tác `forEach` trong Java Stream API

**`forEach`** là một thao tác kết thúc (terminal operation) trong Java Stream API. Nó được sử dụng để thực hiện một hành động nào đó trên mỗi phần tử của `Stream`. Khi `forEach` được gọi, tất cả các phần tử trong `Stream` sẽ được xử lý, và hành động được chỉ định sẽ được thực hiện trên từng phần tử.

### Cú pháp:
```java
void forEach(Consumer<? super T> action)
```

- **`action`**: Là một biểu thức lambda hoặc method reference, đại diện cho hành động sẽ được thực hiện trên từng phần tử của `Stream`.

### Mục đích:
`forEach` được sử dụng để lặp qua tất cả các phần tử của `Stream` và thực hiện một hành động nào đó cho mỗi phần tử. Đây là một cách ngắn gọn và tiện lợi để thay thế cho các vòng lặp thông thường (`for`, `while`).

### Ví dụ cơ bản:

#### Ví dụ 1: In ra các phần tử của `Stream`
Giả sử bạn có một `Stream` các số nguyên và bạn muốn in ra từng số.

```java
import java.util.stream.Stream;

public class ForEachExample {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
              .forEach(System.out::println);  // In ra từng phần tử của Stream
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

### Cách hoạt động:
- **`Stream.of(1, 2, 3, 4, 5)`**: Tạo một `Stream` chứa các số nguyên từ 1 đến 5.
- **`forEach(System.out::println)`**: Sử dụng `forEach` để lặp qua từng phần tử của `Stream` và in ra từng phần tử bằng cách sử dụng method reference `System.out::println`.

### Lưu ý:
- **Thao tác kết thúc**: `forEach` là một thao tác kết thúc, điều này có nghĩa là sau khi bạn gọi `forEach`, `Stream` sẽ bị "tiêu thụ" và không thể sử dụng lại.
- **Không đảm bảo thứ tự trong `Parallel Stream`**: Khi sử dụng `forEach` với `Parallel Stream`, thứ tự xử lý các phần tử không được đảm bảo. Nếu bạn cần đảm bảo thứ tự, hãy sử dụng `forEachOrdered`.

### Ví dụ 2: Thực hiện các hành động khác với `forEach`
Bạn có thể thực hiện bất kỳ hành động nào khác trên các phần tử của `Stream`, chẳng hạn như tích lũy giá trị, cập nhật biến bên ngoài, hoặc xử lý các đối tượng phức tạp.

```java
import java.util.Arrays;
import java.util.List;

public class ForEachComplexExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");

        names.stream()
             .forEach(name -> {
                 if (name.startsWith("J")) {
                     System.out.println(name + " starts with J");
                 } else {
                     System.out.println(name + " does not start with J");
                 }
             });
    }
}
```

#### Kết quả:
```
John starts with J
Jane starts with J
Jack starts with J
Doe does not start with J
```

### Cách hoạt động:
- **`names.stream()`**: Tạo một `Stream` từ danh sách `names`.
- **`forEach(name -> { ... })`**: Lặp qua từng tên trong `Stream` và thực hiện các hành động kiểm tra điều kiện với từng phần tử.

### Khi nào không nên sử dụng `forEach`?
- **Không nên dùng để thu thập kết quả**: Nếu bạn cần thu thập kết quả từ các phần tử trong `Stream`, hãy sử dụng các thao tác như `collect()`, `reduce()`, hoặc `map()` thay vì `forEach`.
- **Đối với xử lý song song**: Khi xử lý với `Parallel Stream` mà cần đảm bảo thứ tự, `forEachOrdered` sẽ là lựa chọn tốt hơn.

### Tóm lại:
- **`forEach`** là một thao tác kết thúc trong Java Stream API, cho phép bạn thực hiện một hành động trên mỗi phần tử của `Stream`.
- Nó rất hữu ích cho các tác vụ như in ra kết quả, thực hiện các hành động phụ, nhưng không phù hợp khi bạn cần thu thập hoặc kết hợp kết quả từ `Stream`.