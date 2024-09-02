package II_StreamOperations.II_TerminateOperation.V_CollectOperation;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectOperation {
	// collect(): Biến đổi các phần tử của Stream thành
	// 1 List, Set, Map
	public static void main(String[] args) {
		// Thu thập các phần tử thành 1 List
		
		Stream<String> stream = Stream.of("a", "b", "c");
		
		List<String> list = stream.collect(Collectors.toList());
		System.out.println(list); // [a, b, c]
		
		// Thu thập các phần tử thành 1 Set
		Stream<String> stream2 = Stream.of("a", "b", "c");
		Set<String> list2 = stream2.collect(Collectors.toSet());
		System.out.println(list2); // [a, b, c]
		
		// Thu thập các phần tử thành 1 Map, chỉ định cách xác định khóa và giá trị
		Stream<String> stream3 = Stream.of("a", "b", "c");
		Map<String, Integer> map = stream3.collect(Collectors.toMap(
				s -> s, // Khóa chính là chuỗi kí tự
				s -> s.length() // Giá trị là độ dài của chuỗi
		));
		
		System.out.println(map); // {a=1, b=1, c=1}
		
		// Gộp các phần tử thành 1 chuỗi Collectors.joining()
		
		Stream<String> stream4 = Stream.of("a", "b", "c");
		
		String res = stream4.collect(Collectors.joining());
		System.out.println(res); // abc
		
		// Tạo 1 Collector tùy chỉnh bằng phương thức collect() với 3 tham số
		Stream<String> stream5 = Stream.of("a", "b", "c");
		
		Set<String> set = stream5.collect(
				() -> new HashSet<>(), // Tạo 1 nhà cung cấp kết quả ( thay cho HashSet::new)
				(s, item) -> s.add(item), // Cách tích lũy các phần tử (thay cho Set::add)
				(s1, s2) -> s1.addAll(s2) // Kết hợp kết quả từ các luồng song song (thay cho Set::addAll)
		);
		
		System.out.println(set); // [a, b, c]
		
	}
}
