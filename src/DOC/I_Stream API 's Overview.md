### Giới thiệu về Stream API trong Java

**Stream API** là một phần của Java 8 và các phiên bản sau này, giúp xử lý các tập hợp dữ liệu (collections) một cách dễ dàng và hiệu quả. Stream API cung cấp một cách tiếp cận hướng chức năng để xử lý các tập hợp dữ liệu như List, Set, hoặc thậm chí là Array. Khái niệm “stream” trong Java không đại diện cho một cấu trúc dữ liệu mà là một chuỗi các đối tượng mà các phép toán được áp dụng theo kiểu pipeline (chuỗi các bước liên tiếp).

### Các tính năng chính của Stream API

1. **Lazy Evaluation (Đánh giá lười biếng)**: Stream API chỉ thực hiện các phép toán khi kết quả được yêu cầu. Điều này có nghĩa là các phép toán trung gian (intermediate operations) sẽ không được thực thi cho đến khi một phép toán kết thúc (terminal operation) được gọi.

2. **Intermediate Operations**: Đây là các phép toán áp dụng lên stream để chuyển đổi, lọc, hoặc ánh xạ các phần tử, ví dụ như `filter`, `map`, `sorted`. Các phép toán này không thay đổi nguồn dữ liệu ban đầu mà tạo ra một stream mới.

3. **Terminal Operations**: Đây là các phép toán kết thúc stream, như `forEach`, `collect`, `reduce`. Các phép toán này thực thi toàn bộ pipeline và trả về kết quả cụ thể hoặc thay đổi trạng thái của hệ thống.

4. **Parallel Processing (Xử lý song song)**: Stream API hỗ trợ xử lý song song một cách tự động, giúp tận dụng sức mạnh của các CPU đa lõi mà không cần phải tự quản lý các luồng (threads).

### Ví dụ minh họa

Dưới đây là ví dụ về việc sử dụng Stream API để lọc ra các số chẵn từ một danh sách các số nguyên và sau đó sắp xếp các số này:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Danh sách các số nguyên
        List<Integer> numbers = Arrays.asList(3, 2, 7, 5, 10, 6, 1, 8);

        // Sử dụng Stream API để lọc các số chẵn và sắp xếp
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0) // Lọc các số chẵn
            .sorted()                // Sắp xếp
            .collect(Collectors.toList()); // Thu thập kết quả thành List

        // In ra các số chẵn đã được sắp xếp
        evenNumbers.forEach(System.out::println);
    }
}
```

**Giải thích ví dụ:**

1. **`numbers.stream()`**: Chuyển đổi danh sách `numbers` thành một stream.
2. **`filter(n -> n % 2 == 0)`**: Chỉ giữ lại các phần tử chia hết cho 2 (các số chẵn).
3. **`sorted()`**: Sắp xếp các phần tử theo thứ tự tăng dần.
4. **`collect(Collectors.toList())`**: Thu thập kết quả vào một danh sách mới.
5. **`forEach(System.out::println)`**: In ra từng phần tử của danh sách kết quả.

Kết quả của chương trình trên sẽ là:

```
2
6
8
10
```

### Kết luận

Stream API trong Java là một công cụ mạnh mẽ cho việc xử lý các tập hợp dữ liệu một cách linh hoạt và hiệu quả. Nó không chỉ giúp mã nguồn trở nên ngắn gọn hơn mà còn tận dụng tốt khả năng xử lý song song của hệ thống, làm tăng hiệu suất thực thi của ứng dụng.