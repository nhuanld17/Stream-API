Trong Java Stream API, thao tác `mapToDouble` là một thao tác trung gian (intermediate operation) dùng để chuyển đổi các phần tử trong một `Stream` thành các giá trị kiểu `double`. Kết quả của thao tác này là một `DoubleStream`, một phiên bản chuyên biệt của `Stream` dành cho các giá trị nguyên thủy kiểu `double`.

### Cú pháp:
```java
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
```

- **`mapper`**: Là một hàm chuyển đổi (thường là biểu thức lambda hoặc method reference) được áp dụng cho mỗi phần tử của `Stream` để chuyển nó thành một giá trị kiểu `double`.

### Mục đích:
`mapToDouble` thường được sử dụng khi bạn có một `Stream` chứa các đối tượng và bạn muốn ánh xạ chúng thành các giá trị nguyên thủy `double` để thực hiện các phép toán như tính tổng, tính trung bình, hoặc sử dụng các phương thức chuyên biệt của `DoubleStream`.

### Ví dụ sử dụng `mapToDouble`:

Giả sử bạn có một danh sách các đối tượng `Product` với thuộc tính `price` kiểu `double`, và bạn muốn tính tổng giá trị của tất cả các sản phẩm.

```java
import java.util.Arrays;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

public class MapToDoubleExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200.50),
            new Product("Smartphone", 800.75),
            new Product("Tablet", 300.99)
        );

        double totalPrice = products.stream()
                                    .mapToDouble(Product::getPrice)  // Ánh xạ mỗi Product thành giá trị price
                                    .sum();  // Tính tổng giá trị price

        System.out.println("Total Price: " + totalPrice);  // Output: Total Price: 2302.24
    }
}
```

### Kết quả:
```
Total Price: 2302.24
```

### Các phương thức hữu ích của `DoubleStream`:
Khi bạn đã chuyển đổi `Stream` thành `DoubleStream`, bạn có thể sử dụng nhiều phương thức hữu ích mà `DoubleStream` cung cấp, chẳng hạn như:

- **`sum()`**: Tính tổng các giá trị `double` trong `DoubleStream`.
- **`average()`**: Tính giá trị trung bình của các giá trị `double`, trả về một `OptionalDouble`.
- **`max()`**: Tìm giá trị lớn nhất, trả về một `OptionalDouble`.
- **`min()`**: Tìm giá trị nhỏ nhất, trả về một `OptionalDouble`.
- **`count()`**: Đếm số lượng phần tử trong `DoubleStream`.
- **`boxed()`**: Chuyển `DoubleStream` thành `Stream<Double>` nếu bạn cần làm việc với đối tượng `Double`.

### Ví dụ thêm:

Tính giá trị trung bình của tất cả giá trị `price` trong danh sách sản phẩm:

```java
import java.util.OptionalDouble;

public class AveragePriceExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200.50),
            new Product("Smartphone", 800.75),
            new Product("Tablet", 300.99)
        );

        OptionalDouble averagePrice = products.stream()
                                              .mapToDouble(Product::getPrice)  // Ánh xạ mỗi Product thành giá trị price
                                              .average();  // Tính giá trị trung bình

        averagePrice.ifPresent(avg -> System.out.println("Average Price: " + avg));  // Output: Average Price: 767.7466666666667
    }
}
```

### Kết quả:
```
Average Price: 767.7466666666667
```

### Tại sao `mapToDouble` hữu ích?

`mapToDouble` rất hữu ích khi bạn cần làm việc với các giá trị kiểu `double` trong một stream, đặc biệt là khi thực hiện các phép toán số học trên các phần tử trong `Stream`. Nó cho phép chuyển đổi linh hoạt và hiệu quả từ các đối tượng trong `Stream` sang các giá trị nguyên thủy để tính toán.