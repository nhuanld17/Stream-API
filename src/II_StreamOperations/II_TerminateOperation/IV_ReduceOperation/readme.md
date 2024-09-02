### Thao tác `reduce` trong Java Stream API

**`reduce`** là một thao tác kết thúc (terminal operation) trong Java Stream API, được sử dụng để thực hiện một phép tính gộp (reduction) trên các phần tử của `Stream`. Kết quả của `reduce` là một giá trị duy nhất được tính toán bằng cách kết hợp các phần tử của `Stream` theo một cách nào đó.

Java Stream API cung cấp ba dạng `reduce` chính:

1. **`reduce(BinaryOperator<T> accumulator)`**
2. **`reduce(T identity, BinaryOperator<T> accumulator)`**
3. **`reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)`**

### 1. `reduce(BinaryOperator<T> accumulator)`

- **Cú pháp:**
  ```java
  Optional<T> reduce(BinaryOperator<T> accumulator)
  ```

- **Mô tả:**
  Phép tính gộp này kết hợp các phần tử của `Stream` lại với nhau bằng cách sử dụng một `BinaryOperator`. Kết quả trả về là một `Optional<T>` vì `Stream` có thể rỗng, và trong trường hợp đó không có giá trị để trả về.

- **Ví dụ: Tính tổng các số trong một `Stream`**
  ```java
  import java.util.Optional;
  import java.util.stream.Stream;

  public class ReduceExample {
      public static void main(String[] args) {
          Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

          Optional<Integer> sum = numbers.reduce(Integer::sum);

          sum.ifPresent(System.out::println);  // Output: 15
      }
  }
  ```

  **Giải thích:**
    - `reduce(Integer::sum)`: Sử dụng `reduce` với `Integer::sum` để cộng dồn tất cả các phần tử trong `Stream`.
    - Kết quả trả về là một `Optional<Integer>`, trong trường hợp `Stream` rỗng, `Optional` sẽ không chứa giá trị nào.

### 2. `reduce(T identity, BinaryOperator<T> accumulator)`

- **Cú pháp:**
  ```java
  T reduce(T identity, BinaryOperator<T> accumulator)
  ```

- **Mô tả:**
  Phép tính gộp này tương tự như phiên bản đầu tiên, nhưng nó sử dụng một giá trị khởi tạo (`identity`). Giá trị khởi tạo này sẽ được trả về nếu `Stream` rỗng. Kết quả trả về là một giá trị cụ thể (không phải `Optional`).

- **Ví dụ: Tính tổng các số trong một `Stream` với giá trị khởi tạo**
  ```java
  import java.util.stream.Stream;

  public class ReduceWithIdentityExample {
      public static void main(String[] args) {
          Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

          int sum = numbers.reduce(0, Integer::sum);

          System.out.println(sum);  // Output: 15
      }
  }
  ```

  **Giải thích:**
    - `reduce(0, Integer::sum)`: Bắt đầu với giá trị khởi tạo `0`, sau đó cộng dồn tất cả các phần tử trong `Stream`.
    - Kết quả là một giá trị cụ thể (`int`), không phải `Optional`.

### 3. `reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)`

- **Cú pháp:**
  ```java
  <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
  ```

- **Mô tả:**
  Phép tính gộp này phù hợp cho các bài toán phức tạp hơn, đặc biệt là khi sử dụng `Parallel Stream`. Nó sử dụng ba đối số: một giá trị khởi tạo (`identity`), một hàm gộp (`accumulator`), và một hàm kết hợp (`combiner`). Hàm kết hợp (`combiner`) được sử dụng để kết hợp các kết quả từ các luồng khác nhau trong `Parallel Stream`.

- **Ví dụ: Tính tổng độ dài của các chuỗi ký tự trong một `Stream`**
  ```java
  import java.util.stream.Stream;

  public class ReduceWithCombinerExample {
      public static void main(String[] args) {
          Stream<String> words = Stream.of("Java", "Stream", "API");

          int totalLength = words.reduce(
                  0,                            // Giá trị khởi tạo
                  (length, word) -> length + word.length(),  // Hàm gộp
                  Integer::sum                  // Hàm kết hợp
          );

          System.out.println(totalLength);  // Output: 12
      }
  }
  ```

  **Giải thích:**
    - `reduce(0, (length, word) -> length + word.length(), Integer::sum)`: Tính tổng độ dài của các chuỗi trong `Stream`.
    - Giá trị khởi tạo là `0`, hàm gộp cộng độ dài của từng từ vào tổng, và hàm kết hợp cộng kết quả từ các luồng khác nhau (nếu `Stream` là `Parallel Stream`).

### Khi nào nên sử dụng `reduce`?

- **Khi bạn muốn gộp các phần tử của `Stream` thành một giá trị duy nhất**: Ví dụ, tính tổng, tích, chuỗi các giá trị, v.v.
- **Khi bạn muốn thực hiện các phép toán phức tạp mà không thể dễ dàng biểu diễn bằng các thao tác khác như `collect`**.

### Tóm lại:
- **`reduce`** là một thao tác kết thúc trong Java Stream API, cung cấp các cách linh hoạt để gộp các phần tử trong `Stream` lại với nhau thành một giá trị duy nhất.
- Nó có ba dạng khác nhau, từ việc gộp đơn giản với một `BinaryOperator` đến các phép gộp phức tạp hơn với `BiFunction` và `BinaryOperator` cho các trường hợp sử dụng song song.
- `reduce` là một công cụ mạnh mẽ khi bạn cần thực hiện các phép toán tổng hợp hoặc kết hợp phức tạp trên các phần tử của `Stream`.