package II_StreamOperations.I_IntermediateOperation.XI_MapToDoubleOperation;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapToDoubleOperation {
	public static void main(String[] args) {
		// Tính tổng giá trị các sản phẩm
		List<Product> products = Arrays.asList(
				new Product("Laptop", 120),
				new Product("SmartPhone", 300),
				new Product("Tablet", 300.99)
		);
		
		double totalPrice = products.stream()
				.mapToDouble(product -> product.getPrice())
				.sum();
		System.out.println("Total price: " + totalPrice);
		// Total price: 720.99
		
		// Tính giá trung bình của các sản phẩm
		
		OptionalDouble avgPrice = products.stream()
				.mapToDouble(p -> p.getPrice())
				.average();
		avgPrice.ifPresent(System.out::println);
		// 240.33
	}
}
