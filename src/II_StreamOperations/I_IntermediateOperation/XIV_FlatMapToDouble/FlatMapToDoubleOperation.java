package II_StreamOperations.I_IntermediateOperation.XIV_FlatMapToDouble;

import java.util.Arrays;
import java.util.List;

public class FlatMapToDoubleOperation {
	public static void main(String[] args) {
		// Tính tổng giá trị của tất cả các sản phẩm trong danh sách
		List<Product> products = Arrays.asList(
				new Product("Shirt", Arrays.asList(19.99, 25.99)),
				new Product("Shoes", Arrays.asList(49.99, 59.99)),
				new Product("Hat", Arrays.asList(15.99, 18.99, 22.99))
		);
		
		double totalValue = products.stream()
				.flatMapToDouble(product -> product.getPrices().stream().mapToDouble(price -> price.doubleValue()))
				.sum();
		
		System.out.println("Total value: " + totalValue);
		// Total value: 213.93
		
		// Tính tổng diện tích của các hình dạng trong một danh sách
		
		List<Shape> shapes = Arrays.asList(
				new Shape("Circle", Arrays.asList(12.56, 28.27)),
				new Shape("Square", Arrays.asList(25.0, 49.0)),
				new Shape("Triangle", Arrays.asList(15.0, 30.0, 45.0))
		);
		
		double totalArea = shapes.stream()
				.flatMapToDouble(shape -> shape.getAreas().stream().mapToDouble(area -> area.doubleValue()))
				.sum();
		
		System.out.println("Total area: " + totalArea);
		// Total area: 204.82999999999998
	}
}
