### Thao tác `collect` trong Java Stream API

**`collect`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để biến đổi các phần tử của `Stream` thành một dạng kết quả khác, chẳng hạn như một `List`, `Set`, `Map`, hoặc thậm chí là một giá trị đơn giản thông qua việc gộp (reduction).

### Cú pháp:
```java
<R, A> R collect(Collector<? super T, A, R> collector)
```

- **`collector`**: Là một đối tượng `Collector` xác định cách thức thu thập các phần tử của `Stream` và cách biến đổi chúng thành kết quả mong muốn.

### Mục đích:
`collect` là một trong những thao tác mạnh mẽ nhất trong Java Stream API, cho phép bạn linh hoạt thu thập và xử lý các phần tử của `Stream` để tạo ra các kết quả phức tạp, chẳng hạn như:
- Thu thập các phần tử thành một bộ sưu tập (collection) như `List`, `Set`, hoặc `Map`.
- Gộp các phần tử thành một giá trị tổng hợp như tổng, tích, hay chuỗi các phần tử.

### Các ví dụ phổ biến:

#### 1. Thu thập các phần tử thành một `List`
Giả sử bạn có một `Stream` các chuỗi và bạn muốn thu thập chúng thành một `List`.

```java
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectToListExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java", "Stream", "API");

        List<String> list = stream.collect(Collectors.toList());

        System.out.println(list);  // Output: [Java, Stream, API]
    }
}
```

**Giải thích**:
- **`collect(Collectors.toList())`**: Thu thập tất cả các phần tử của `Stream` vào một `List`.

#### 2. Thu thập các phần tử thành một `Set`
Nếu bạn muốn loại bỏ các phần tử trùng lặp trong `Stream`, bạn có thể thu thập chúng vào một `Set`.

```java
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectToSetExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java", "Stream", "API", "Java");

        Set<String> set = stream.collect(Collectors.toSet());

        System.out.println(set);  // Output: [Java, Stream, API]
    }
}
```

**Giải thích**:
- **`collect(Collectors.toSet())`**: Thu thập các phần tử vào một `Set`, tự động loại bỏ các phần tử trùng lặp.

#### 3. Thu thập các phần tử thành một `Map`
Nếu bạn muốn thu thập các phần tử vào một `Map`, bạn cần chỉ định cách xác định khóa và giá trị.

```java
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectToMapExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java", "Stream", "API");

        Map<String, Integer> map = stream.collect(Collectors.toMap(
            s -> s,          // Khóa là chính chuỗi ký tự
            String::length   // Giá trị là độ dài của chuỗi
        ));

        System.out.println(map);  // Output: {Java=4, Stream=6, API=3}
    }
}
```

**Giải thích**:
- **`collect(Collectors.toMap(s -> s, String::length))`**: Tạo một `Map` với mỗi chuỗi là một khóa và độ dài của chuỗi là giá trị.

#### 4. Gộp các phần tử thành một chuỗi
Nếu bạn muốn nối các chuỗi lại với nhau thành một chuỗi lớn, bạn có thể sử dụng `Collectors.joining()`.

```java
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectJoiningExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java", "Stream", "API");

        String result = stream.collect(Collectors.joining(", "));

        System.out.println(result);  // Output: Java, Stream, API
    }
}
```

**Giải thích**:
- **`collect(Collectors.joining(", "))`**: Nối các chuỗi lại với nhau, mỗi chuỗi cách nhau bằng dấu phẩy và dấu cách.

#### 5. Tạo một `Collector` tùy chỉnh
Bạn cũng có thể tạo một `Collector` tùy chỉnh bằng cách sử dụng phương thức `collect` với ba tham số.

```java
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CustomCollectorExample {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java", "Stream", "API");

        Set<String> set = stream.collect(
            HashSet::new,        // Cung cấp một nhà cung cấp kết quả (supplier)
            Set::add,            // Cách tích lũy các phần tử (accumulator)
            Set::addAll          // Cách kết hợp kết quả từ các luồng song song (combiner)
        );

        System.out.println(set);  // Output: [Java, Stream, API]
    }
}
```

**Giải thích**:
- **`HashSet::new`**: Cung cấp một nhà cung cấp kết quả, tạo ra một `HashSet` mới.
- **`Set::add`**: Cách thức để thêm phần tử vào kết quả.
- **`Set::addAll`**: Cách thức để kết hợp các kết quả từ các luồng song song (nếu có).

### Tóm lại:
- **`collect`** là một thao tác kết thúc mạnh mẽ và linh hoạt trong Java Stream API, cho phép bạn thu thập các phần tử từ `Stream` và biến đổi chúng thành một dạng kết quả mong muốn.
- `collect` đặc biệt hữu ích để thu thập các phần tử vào các cấu trúc dữ liệu như `List`, `Set`, `Map`, hoặc để gộp các phần tử thành các giá trị tổng hợp như chuỗi, tổng, v.v.
- Bạn có thể sử dụng các `Collector` đã có sẵn trong `Collectors` hoặc tự tạo `Collector` tùy chỉnh để phù hợp với nhu cầu của mình.