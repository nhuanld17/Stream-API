Trong Java Stream API, thao tác `mapToLong` là một thao tác trung gian (intermediate operation) dùng để chuyển đổi các phần tử trong một `Stream` thành các giá trị kiểu `long`. Kết quả của thao tác này là một `LongStream`, một phiên bản chuyên biệt của `Stream` dành cho các giá trị nguyên thủy kiểu `long`.

### Cú pháp:
```java
LongStream mapToLong(ToLongFunction<? super T> mapper)
```

- **`mapper`**: Là một hàm chuyển đổi (thường là biểu thức lambda hoặc method reference) được áp dụng cho mỗi phần tử của `Stream` để chuyển nó thành một giá trị kiểu `long`.

### Mục đích:
`mapToLong` được sử dụng khi bạn có một `Stream` chứa các đối tượng và bạn muốn ánh xạ chúng thành các giá trị nguyên thủy `long` để thực hiện các phép toán như tính tổng, tìm giá trị lớn nhất/nhỏ nhất, hoặc tận dụng các phương thức chuyên biệt của `LongStream`.

### Ví dụ sử dụng `mapToLong`:

Giả sử bạn có một danh sách các đối tượng `Employee` và bạn muốn tính tổng lương của tất cả nhân viên:

```java
import java.util.Arrays;
import java.util.List;

class Employee {
    private String name;
    private long salary;

    public Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }
}

public class MapToLongExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 50000),
            new Employee("Jane", 60000),
            new Employee("Jack", 55000)
        );

        long totalSalary = employees.stream()
                                    .mapToLong(Employee::getSalary)  // Ánh xạ mỗi Employee thành lương của họ
                                    .sum();  // Tính tổng lương

        System.out.println("Total Salary: " + totalSalary);  // Output: Total Salary: 165000
    }
}
```

### Kết quả:
```
Total Salary: 165000
```

### Các phương thức hữu ích của `LongStream`:
Khi bạn đã chuyển đổi `Stream` thành `LongStream`, bạn có thể sử dụng nhiều phương thức hữu ích mà `LongStream` cung cấp, chẳng hạn như:

- **`sum()`**: Tính tổng các giá trị `long` trong `LongStream`.
- **`average()`**: Tính giá trị trung bình của các giá trị `long`.
- **`max()`**: Tìm giá trị lớn nhất.
- **`min()`**: Tìm giá trị nhỏ nhất.
- **`count()`**: Đếm số lượng phần tử trong `LongStream`.
- **`boxed()`**: Chuyển `LongStream` thành `Stream<Long>` nếu bạn cần làm việc với đối tượng `Long`.

### Ví dụ thêm:

Tìm giá trị lương cao nhất trong danh sách nhân viên:

```java
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;

public class MaxSalaryExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 50000),
            new Employee("Jane", 60000),
            new Employee("Jack", 55000)
        );

        OptionalLong maxSalary = employees.stream()
                                          .mapToLong(Employee::getSalary)  // Ánh xạ mỗi Employee thành lương của họ
                                          .max();  // Tìm giá trị lương cao nhất

        maxSalary.ifPresent(salary -> System.out.println("Max Salary: " + salary));  // Output: Max Salary: 60000
    }
}
```

### Kết quả:
```
Max Salary: 60000
```

`mapToLong` là một thao tác quan trọng và tiện lợi khi bạn cần làm việc với các giá trị nguyên thủy `long` trong Java, đặc biệt là khi xử lý các phép toán số học hoặc các tính toán hiệu suất cao trên các phần tử trong `Stream`.