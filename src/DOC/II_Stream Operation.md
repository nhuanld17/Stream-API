**Stream Operation** trong Java là các phép toán hoặc thao tác được thực hiện trên một Stream để xử lý và biến đổi dữ liệu. Stream Operations có thể được chia thành hai loại chính: **Intermediate Operations** và **Terminal Operations**.

### 1. Intermediate Operations (Phép toán trung gian)
Intermediate Operations là các thao tác được áp dụng lên một Stream nhưng không làm thay đổi hoặc kết thúc Stream đó ngay lập tức. Thay vào đó, chúng trả về một Stream mới để có thể tiếp tục áp dụng các thao tác khác. Các phép toán trung gian thường được đánh giá "lười biếng" (lazy evaluation), có nghĩa là chúng chỉ thực sự được thực thi khi một phép toán kết thúc (terminal operation) được gọi.

Các ví dụ về Intermediate Operations:
- **`filter(Predicate)`**: Lọc các phần tử dựa trên một điều kiện.
- **`map(Function)`**: Ánh xạ các phần tử từ dạng này sang dạng khác.
- **`sorted()`**: Sắp xếp các phần tử.
- **`distinct()`**: Loại bỏ các phần tử trùng lặp.
- **`limit(n)`**: Giới hạn số lượng phần tử trong Stream.

Ví dụ:

```java
List<String> names = Arrays.asList("John", "Peter", "Jane", "Tom");

List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("J")) // Lọc các tên bắt đầu bằng "J"
    .collect(Collectors.toList());
```

Trong ví dụ trên, `filter()` là một Intermediate Operation.

### 2. Terminal Operations (Phép toán kết thúc)
Terminal Operations là các thao tác kết thúc Stream. Khi một Terminal Operation được thực hiện, nó sẽ kích hoạt toàn bộ chuỗi các Intermediate Operations và tạo ra kết quả cuối cùng hoặc thực hiện hành động cần thiết. Sau khi một Terminal Operation được gọi, Stream sẽ không thể được sử dụng lại.

Các ví dụ về Terminal Operations:
- **`forEach(Consumer)`**: Thực hiện một hành động cho mỗi phần tử của Stream.
- **`collect(Collector)`**: Thu thập các phần tử từ Stream vào một collection (như List, Set).
- **`count()`**: Đếm số lượng phần tử trong Stream.
- **`reduce(BinaryOperator)`**: Gộp các phần tử lại để tạo ra một giá trị duy nhất.
- **`anyMatch(Predicate)`**: Kiểm tra xem có bất kỳ phần tử nào thỏa mãn điều kiện hay không.

Ví dụ:

```java
List<String> names = Arrays.asList("John", "Peter", "Jane", "Tom");

names.stream()
    .filter(name -> name.startsWith("J")) // Intermediate Operation
    .forEach(System.out::println);        // Terminal Operation
```

Trong ví dụ trên, `forEach()` là một Terminal Operation. Nó sẽ kết thúc Stream và thực hiện hành động in ra tên các phần tử bắt đầu bằng "J".

### 3. Lazy Evaluation (Đánh giá lười biếng)
Như đã đề cập, các Intermediate Operations trong Stream được đánh giá một cách lười biếng. Điều này có nghĩa là không có thao tác nào thực sự được thực hiện cho đến khi một Terminal Operation được gọi. Điều này giúp tối ưu hóa hiệu suất bằng cách giảm thiểu các thao tác không cần thiết.

### Tóm tắt
- **Stream Operations** là các phép toán được thực hiện trên Stream để xử lý dữ liệu.
- **Intermediate Operations** như `filter()`, `map()`, `sorted()` là các phép toán trung gian trả về một Stream mới.
- **Terminal Operations** như `forEach()`, `collect()`, `reduce()` là các phép toán kết thúc, kết thúc quá trình xử lý của Stream và tạo ra kết quả cuối cùng.

Stream API cung cấp một cách linh hoạt và mạnh mẽ để xử lý các tập hợp dữ liệu một cách hiệu quả trong Java.