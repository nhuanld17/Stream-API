### `flatMapToDouble` trong Java Stream API

**`flatMapToDouble`** là một thao tác trung gian trong Java Stream API, được sử dụng để chuyển đổi mỗi phần tử của một `Stream<T>` thành một `DoubleStream` (stream chứa các giá trị kiểu `double`). Sau đó, tất cả các `DoubleStream` kết quả được hợp nhất thành một `DoubleStream` duy nhất. Điều này có nghĩa là nó "làm phẳng" nhiều `DoubleStream` từ nhiều phần tử thành một `DoubleStream` liên tục.

### Cú pháp:
```java
DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper)
```

- **`mapper`**: Là một hàm (thường là biểu thức lambda hoặc method reference) được áp dụng cho mỗi phần tử của `Stream<T>` để chuyển đổi nó thành một `DoubleStream`.

### Mục đích:
`flatMapToDouble` rất hữu ích khi bạn có một `Stream` mà mỗi phần tử có thể được chuyển đổi thành một chuỗi các giá trị `double`. Nó cho phép bạn chuyển đổi và hợp nhất các `DoubleStream` này thành một `DoubleStream` duy nhất, từ đó dễ dàng áp dụng các thao tác như `sum()`, `average()`, `max()`, v.v.

### Ví dụ minh họa:

#### Ví dụ 1: Tính tổng giá trị của tất cả các sản phẩm trong danh sách
Giả sử bạn có một danh sách các đối tượng `Product`, mỗi sản phẩm có một danh sách các giá trị khác nhau (ví dụ: giá theo các kích thước khác nhau), và bạn muốn tính tổng giá trị của tất cả các sản phẩm.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

class Product {
    private String name;
    private List<Double> prices;

    public Product(String name, List<Double> prices) {
        this.name = name;
        this.prices = prices;
    }

    public List<Double> getPrices() {
        return prices;
    }
}

public class FlatMapToDoubleExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Shirt", Arrays.asList(19.99, 25.99)),
            new Product("Shoes", Arrays.asList(49.99, 59.99)),
            new Product("Hat", Arrays.asList(15.99, 18.99, 22.99))
        );

        double totalValue = products.stream()
                                    .flatMapToDouble(product -> product.getPrices().stream().mapToDouble(Double::doubleValue))
                                    .sum();

        System.out.println("Total value of all products: " + totalValue);  // Output: Total value of all products: 213.93
    }
}
```

#### Giải thích:
1. **`product.getPrices().stream()`**: Lấy danh sách giá của mỗi sản phẩm và chuyển đổi nó thành một `Stream<Double>`.
2. **`mapToDouble(Double::doubleValue)`**: Chuyển đổi `Stream<Double>` thành `DoubleStream`.
3. **`flatMapToDouble(...)`**: "Làm phẳng" tất cả các `DoubleStream` thành một `DoubleStream` duy nhất.
4. **`sum()`**: Tính tổng tất cả các giá trị `double` trong `DoubleStream`.

#### Ví dụ 2: Tính tổng diện tích của các hình dạng trong một danh sách
Giả sử bạn có một danh sách các đối tượng `Shape`, mỗi đối tượng có thể có nhiều biến thể kích thước, và bạn muốn tính tổng diện tích của tất cả các biến thể.

```java
import java.util.Arrays;
import java.util.List;

class Shape {
    private String type;
    private List<Double> areas;

    public Shape(String type, List<Double> areas) {
        this.type = type;
        this.areas = areas;
    }

    public List<Double> getAreas() {
        return areas;
    }
}

public class FlatMapToDoubleAreaExample {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
            new Shape("Circle", Arrays.asList(12.56, 28.27)),
            new Shape("Square", Arrays.asList(25.0, 49.0)),
            new Shape("Triangle", Arrays.asList(15.0, 30.0, 45.0))
        );

        double totalArea = shapes.stream()
                                 .flatMapToDouble(shape -> shape.getAreas().stream().mapToDouble(Double::doubleValue))
                                 .sum();

        System.out.println("Total area of all shapes: " + totalArea);  // Output: Total area of all shapes: 204.83
    }
}
```

#### Giải thích:
1. **`shape.getAreas().stream()`**: Lấy danh sách diện tích của mỗi hình dạng và chuyển nó thành một `Stream<Double>`.
2. **`mapToDouble(Double::doubleValue)`**: Chuyển đổi `Stream<Double>` thành `DoubleStream`.
3. **`flatMapToDouble(...)`**: "Làm phẳng" tất cả các `DoubleStream` thành một `DoubleStream` duy nhất.
4. **`sum()`**: Tính tổng tất cả các giá trị `double` trong `DoubleStream`.

### Tóm lại:
- **`flatMapToDouble`** giúp chuyển đổi và hợp nhất nhiều `DoubleStream` thành một `DoubleStream` duy nhất.
- Nó rất hữu ích trong các tình huống cần xử lý nhiều chuỗi giá trị `double` từ các nguồn dữ liệu khác nhau, sau đó thực hiện các phép toán trên `DoubleStream` kết quả.

Cả hai ví dụ trên đều minh họa việc sử dụng `flatMapToDouble` để tính tổng các giá trị `double` từ các nguồn dữ liệu phức tạp (giá sản phẩm hoặc diện tích hình dạng).