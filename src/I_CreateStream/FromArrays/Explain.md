Đoạn mã này là một ví dụ về cách sử dụng **Stream API** trong Java để xử lý một mảng số nguyên (`int[]`). Hãy cùng phân tích từng phần của đoạn mã:

```java
public class StreamFromArrayExample {
    public static void main(String[] args) {
        int[] numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // Creating a stream from array
        Stream<Integer> streamFromArray = Arrays.stream(numbersArray).boxed();
        
        streamFromArray.forEach(element -> System.out.println(element));
    }
}
```

### Giải thích chi tiết:

1. **`int[] numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};`**
    - Ở dòng này, bạn khai báo và khởi tạo một mảng số nguyên `numbersArray` chứa các giá trị từ 1 đến 10.

2. **`Stream<Integer> streamFromArray = Arrays.stream(numbersArray).boxed();`**
    - `Arrays.stream(numbersArray)`: Dòng này chuyển đổi mảng `numbersArray` thành một **IntStream**. `IntStream` là một dạng stream chuyên xử lý các giá trị nguyên (`int`).
    - `.boxed()`: Phương thức `boxed()` chuyển đổi `IntStream` thành `Stream<Integer>`. Nó bọc (box) các giá trị nguyên (`int`) vào các đối tượng `Integer` (lớp bao của `int`). Điều này là cần thiết vì **Stream API** hoạt động trên các đối tượng thay vì các kiểu dữ liệu nguyên thủy.

3. **`streamFromArray.forEach(element -> System.out.println(element));`**
    - Phương thức `forEach` là một **terminal operation** (phép toán kết thúc) trong Stream API. Nó được sử dụng để lặp qua từng phần tử trong stream.
    - `element -> System.out.println(element)` là một biểu thức lambda. Nó đại diện cho một hàm ẩn danh nhận đầu vào là `element` và in giá trị của `element` ra console.

   Tóm lại, dòng này sẽ in từng phần tử của mảng `numbersArray` ra màn hình.

### Kết quả khi chạy đoạn mã này:
Khi bạn chạy chương trình, các số từ 1 đến 10 sẽ được in ra console, mỗi số trên một dòng:

```
1
2
3
4
5
6
7
8
9
10
```

### Tóm tắt:
- **Mảng `int[]`** được chuyển thành `IntStream` bằng cách sử dụng `Arrays.stream()`.
- `IntStream` sau đó được chuyển đổi thành `Stream<Integer>` bằng cách sử dụng `boxed()`.
- Cuối cùng, stream được lặp qua với `forEach` để in ra các giá trị của mảng.

Đoạn mã này minh họa cách xử lý mảng nguyên thủy bằng Stream API, cụ thể là cách chuyển đổi mảng nguyên thủy thành stream đối tượng để có thể sử dụng đầy đủ các tính năng của Stream API.